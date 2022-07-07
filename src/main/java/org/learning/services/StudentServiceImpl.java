package org.learning.services;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.learning.beans.Student;
import org.learning.repository.StudentRepository;
import org.learning.utils.StudenStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	
	@Override
	@Transactional
	public Student save(Student student) throws Exception {
		student.setStatus(StudenStatus.REGISTERD_STUDENT);
		try {
			student = studentRepository.save(student);
			return student;
		
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}

	@Transactional
	@Override
	public Student findById(Integer id) throws Exception {
		try {
			Optional<Student> student = studentRepository.findById(id);
			return student.get();
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
	@Transactional
	@Override
	public Student findByNumberIdentf(String numberIdentification)throws Exception{
		try {
			 Student student = studentRepository.findbyIdentification(numberIdentification);
			return student;
			
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}	
	
	}

	@Override
	public List<Student> findByGenderCyty(String gender, String city) throws Exception {
		try {
			List<Student> studend = studentRepository.findbyGenderCity(gender, city);
			return studend;
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	
	}
	

	@Transactional
	@Override
	public Student Update(Student stud) throws Exception {
		try {
			Optional<Student> students = studentRepository.findById(stud.getIdStudent());
			stud = students.get();
			stud.setStatus(StudenStatus.UNREGISTERD_STUDENT);
			studentRepository.save(stud);
			return stud;
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}


}
