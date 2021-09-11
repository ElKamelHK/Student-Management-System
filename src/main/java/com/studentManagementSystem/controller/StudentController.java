package com.studentManagementSystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.studentManagementSystem.model.Student;
import com.studentManagementSystem.service.StudentService;
 

@Controller
public class StudentController {
	
	private StudentService studentService;
	 
	
 
	@Autowired
	public StudentController(StudentService studentService) {
		super();
		 
		this.studentService = studentService;
	}
	
	//hendler method to hendle list of studients to view
	@GetMapping("/students")
	public String listStudents(Model model)
	{
		model.addAttribute("students", this.studentService.getAllStudents());
		return "students";
	}
	
	
	

}
