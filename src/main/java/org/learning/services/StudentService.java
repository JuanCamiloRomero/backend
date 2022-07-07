package org.learning.services;

import java.util.List;

import org.learning.beans.Student;



public interface StudentService{
	public Student findById(Integer IdStudent) throws Exception;
	public Student Update(Student student) throws Exception;
	public Student save(Student student) throws Exception;
	public Student  findByNumberIdentf(String numberIdentification) throws Exception;
	public List<Student>findByGenderCyty(String gender, String city)throws Exception;
		
}
