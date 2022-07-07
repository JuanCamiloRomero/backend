package org.learning.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.Media;

import org.learning.beans.Gender;
import org.learning.beans.Student;
import org.learning.services.StudentService;
import org.learning.services.StudentServiceImpl;
import org.learning.utils.StudenStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins =  "*")
@RequestMapping(path = "api/student-registration")
public class StudentController {
	
	@Autowired
	private StudentServiceImpl studentService;
	

	@PostMapping("")
	public ResponseEntity<?> save(@RequestBody Student student){
		
		try {
			if(student.getAge() > 18) {
				return ResponseEntity.status(HttpStatus.OK).body("El estudiante no puede ser matriculado,"
						+ "debe comunicarse telefónicamente  con la institución");
			}else
			{
				return ResponseEntity.status(HttpStatus.OK).body(studentService.save(student));
				
			}
				
			
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CHECKPOINT).body("{\"error\":\"Error. por favor intente mas tarde. \"}");
		}
	}
	@GetMapping
	public ResponseEntity<?> getStudent() {
		byte age = 22;
		LocalDate fecha = LocalDate.of(2000, 10, 01);
		Gender gender = Gender.MALE;
		Student student = new Student("fulano", age, "MALE", "2000-10-03", "100000", "Caqueta", "florencia");
		Student student1 = new Student("sara", age, "female", "2000-12-05", "878787", "Putumayo", "Mocoa");
		List<Student> studensa = new ArrayList<>();
		studensa.add(student);
		studensa.add(student1);
		try {
			return ResponseEntity.status(HttpStatus.OK).body(studensa);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("{\"error\":\"Error. por favor intente mas tarde. \"}");
		}
	}

	@GetMapping("/{numberIdentification}")
	public ResponseEntity<?> findByNumberIdent(@PathVariable String numberIdentification){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(studentService.findByNumberIdentf(numberIdentification));
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CHECKPOINT).body("{\"error\":\"Error. por favor intente mas tarde. \"}");
		}
	}

	@GetMapping("/{gender}/{city}")
	public ResponseEntity<?> findByGenderCity(@PathVariable String gender, @PathVariable String city){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(studentService.findByGenderCyty(gender, city));
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CHECKPOINT).body("{\"error\":\"Error. por favor intente mas tarde. \"}");
		}
	}
	
	@DeleteMapping("/{idstudent}")
	public ResponseEntity<?> deleteStudent(@PathVariable Integer idstudent){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(studentService.Update(new Student(idstudent)));
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CHECKPOINT).body("{\"error\":\"Error. por favor intente mas tarde. \"}");
		}
	}
}
