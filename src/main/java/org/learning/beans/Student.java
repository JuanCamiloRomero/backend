package org.learning.beans;

import java.io.Serializable;
import java.time.LocalDate;




import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.learning.utils.StudenStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("student")
public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column("id")
	private Integer idStudent;

	@Column("name")
	private String studenty;
	@Column("age")
	private byte age;
	@Column("gender")
	private Gender gender;
	@Column("birth_date")
	private LocalDate birthDate;
	@Column("identification_number")
	private String identificationNumber;
	@Column("department_of_birth")
	private String departmentOfBirth;
	@Column("municipality_of_birth")
	private String municipalityOfBirth;
	private byte status;
	
	public Student() {
		
	}
	public Student(String nameStudent, int age, String gender, String birthDate,
			String identificationNumber, String departmentOfBirth, String municipalityOfBirth) {
	
		this.studenty = nameStudent;
		this.age = (byte) age;
		this.gender = toGender(gender);
		this.birthDate = StudenStatus.toDate(birthDate);
		this.identificationNumber = identificationNumber;
		this.departmentOfBirth = departmentOfBirth;
		this.municipalityOfBirth = municipalityOfBirth;	
	}

	
	public Student(String nameStudent, byte age, Gender gender, LocalDate birthDate, String identificationNumber,
			String departmentOfBirth, String municipalityOfBirth) {
		this.studenty = nameStudent;
		this.age = age;
		this.gender = gender;
		this.birthDate = birthDate;
		this.identificationNumber = identificationNumber;
		this.departmentOfBirth = departmentOfBirth;
		this.municipalityOfBirth = municipalityOfBirth;
	}


	public Student(Gender gender, String municipalityOfBirth) {
		this.gender = gender;
		this.municipalityOfBirth = municipalityOfBirth;
	}

	public Student(Integer idStudent) {
		this.idStudent = idStudent;
	}

	public Integer getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}

	public String getNameStudent() {
		return studenty;
	}

	public void setNameStudent(String nameStudent) {
		this.studenty = nameStudent;
	}

	public byte getAge() {
		return age;
	}

	public void setAge(byte age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	public String getDepartmentOfBirth() {
		return departmentOfBirth;
	}

	public void setDepartmentOfBirth(String departmentOfBirth) {
		this.departmentOfBirth = departmentOfBirth;
	}

	public String getMunicipalityOfBirth() {
		return municipalityOfBirth;
	}

	public void setMunicipalityOfBirth(String municipalityOfBirth) {
		this.municipalityOfBirth = municipalityOfBirth;
	}

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public Gender toGender(String gender) {
		Gender genderStudent = null;
		if(gender.equalsIgnoreCase("Male")|| gender.equalsIgnoreCase("M")) {
			genderStudent = Gender.MALE;
		}else if(gender.equalsIgnoreCase("Female")|| gender.equalsIgnoreCase("F")) {
			genderStudent = Gender.FEMALE;
		}
		return genderStudent;
	}

	@Override
	public String toString() {
		return "Student [idStudent=" + idStudent + ", nameStudent=" + studenty + ", age=" + age + ", gender="
				+ gender + ", birthDate=" + birthDate + ", identificationNumber=" + identificationNumber
				+ ", departmentOfBirth=" + departmentOfBirth + ", municipalityOfBirth=" + municipalityOfBirth
				+ ", status=" + status + "]";
	}
	
	
	
	
	
	


}
