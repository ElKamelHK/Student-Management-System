package com.studentManagementSystem.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentManagementSystem.model.Student;
import com.studentManagementSystem.repository.StudentRepository;
@Transactional
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


	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return this.studentRepository.save(student);
	}


	@Override
	public Optional<Student> optionalStudentById(Long id) {
		// TODO Auto-generated method stub
		return this.studentRepository.findById(id);
	}


	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		Optional<Student> opStudent=this.optionalStudentById(student.getId());
		if(opStudent.isPresent())
		{
			opStudent.get().setFirstName(student.getFirstName());
			opStudent.get().setLastName(student.getLastName());
			opStudent.get().setEmail(student.getEmail());
			return opStudent.get();
		}else
			return null;
	}

}
