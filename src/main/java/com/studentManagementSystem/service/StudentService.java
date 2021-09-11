package com.studentManagementSystem.service;

import java.util.List;
import java.util.Optional;

import com.studentManagementSystem.model.Student;

public interface StudentService {
List<Student> getAllStudents();

Student saveStudent(Student student);
Student updateStudent(Student student);
Optional  <Student> optionalStudentById(Long id);

}
