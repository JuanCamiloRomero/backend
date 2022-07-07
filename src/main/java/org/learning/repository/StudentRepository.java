package org.learning.repository;

import java.util.List;

import org.learning.beans.Student;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
	//SELECT s FROM Student s  WHERE s.identificationNumber=1
	@Query("SELECT * FROM student s WHERE s.identification_number =:identificationNumber ")
	Student findbyIdentification(String identificationNumber);

	@Query("select * FROM student s WHERE s.gender=:gender AND s.municipality_of_birth=:city ORDER BY s.name")
	List<Student> findbyGenderCity(String gender, String city);
	
	
}
