package com.studentManagement.System.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentManagement.System.dao.StudentRepository;
import com.studentManagement.System.entity.Student;
import com.studentManagement.System.exception.DataNotFoundException;
import com.studentManagement.System.service.StudentService;


@Service
public class StudentServiceImpl implements StudentService {
	
	StudentRepository studentRepository;
	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
	this.studentRepository=studentRepository;
	}
	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}
	@Override
	public String save(Student student) {
		studentRepository.save(student);
		return student.getFirstName()+student.getLastName()+"saved successfully!!";
	}
	@Override
	public String delete(long studentId) throws DataNotFoundException {
		Student student=findById(studentId);
		if(student!=null) {
			studentRepository.deleteById(studentId);
		}
		return "deleted student having id: "+studentId;
	}
	@Override
	public Student findById(long studentId) throws DataNotFoundException {
		Optional<Student> result = studentRepository.findById(studentId);
		Student student = null;
		if (result.isPresent()) {
			student = result.get();
		} else {
			throw new DataNotFoundException("studentId not found....");
		}
		return student;
	}
	@Override
	public List<Student> findByFirstName(String firstName) throws DataNotFoundException {
		List<Student> studentList=new ArrayList<Student>();
		
		 studentList = studentRepository.findByFirstName(firstName);
		if(studentList==null) {
			throw new DataNotFoundException("Student with name "+firstName+"not found...!");
		}
		return studentList;
	}
}
