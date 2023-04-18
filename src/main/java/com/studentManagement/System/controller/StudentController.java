package com.studentManagement.System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentManagement.System.entity.Student;
import com.studentManagement.System.exception.DataNotFoundException;
import com.studentManagement.System.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
	StudentService studentService;
	
	@Autowired
	public StudentController(StudentService studentService) {
		super();
		this.studentService=studentService;
	}
	
	@GetMapping("/students")
	public List<Student> findAll(){
		return studentService.findAll();
	}
	
	@GetMapping("/student/{studentId}")
	public Student getStudentById(@PathVariable int studentId) throws DataNotFoundException {
		Student student=studentService.findById(studentId);
		return student;
	}
	
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student) {
		//setting id as 0 because just in case they are passing id in JSON
		//force it to insert
		student.setStudentId(0);
		studentService.save(student);
		return student;
	}
	
	@PutMapping("/students")
	public Student updateStudent(@RequestBody Student student) {
			studentService.save(student);
			return student;
		}
	
	@DeleteMapping("/student/{studentId}")
		public String deleteStudent(@PathVariable int studentId) throws DataNotFoundException {
			String msg=studentService.delete(studentId);
			return msg;
			
		}
	@GetMapping("/students/name/{firstName}")
	public List<Student> findStudentByfirstName(@PathVariable String firstName) throws DataNotFoundException{
		List<Student> student=studentService.findByFirstName(firstName);
		return student;
		
	}
}
