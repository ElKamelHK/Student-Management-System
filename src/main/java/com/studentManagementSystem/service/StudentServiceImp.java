package com.studentManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentManagementSystem.model.Student;
import com.studentManagementSystem.repository.StudentRepository;

@Service
public class StudentServiceImp implements StudentService{
	
	private StudentRepository studentRepository;	

	@Autowired
	public StudentServiceImp(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}


	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

}
