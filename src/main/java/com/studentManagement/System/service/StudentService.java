package com.studentManagement.System.service;

import java.util.List;

import com.studentManagement.System.entity.Student;
import com.studentManagement.System.exception.DataNotFoundException;


public interface StudentService  {
	List<Student> findAll();
	String save(Student student);
	String delete(long studentId) throws DataNotFoundException;
	Student findById(long studentId) throws DataNotFoundException;
	List<Student> findByFirstName(String firstName)throws DataNotFoundException;
}
