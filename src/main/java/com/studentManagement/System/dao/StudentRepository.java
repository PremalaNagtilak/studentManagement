package com.studentManagement.System.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentManagement.System.entity.Student;

/**
 * @author Premala
 *
 */
public interface StudentRepository extends JpaRepository<Student,Long> {
	List<Student> findByFirstName(String firstName);

}
