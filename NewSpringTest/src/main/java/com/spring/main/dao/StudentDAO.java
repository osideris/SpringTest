package com.spring.main.dao;

import java.util.List;

import com.spring.main.model.Student;

public interface StudentDAO {

	public void saveOrUpdate(Student student);
	
//	SchoolYr INT NOT NULL,
//    Campus VARCHAR(100) NOT NULL,
//    StudentID INT NOT NULL,
//    EntryDate DATE NOT NULL,
//    GradeLevel INT NOT NULL,
//    Name VARCHAR(100) NOT NULL
	
	public void delete(int studentID);
	
	public Student get(int studentID);
	
	public List<Student> list();
}