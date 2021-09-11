package com.studentManagementSystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.studentManagementSystem.model.Student;
import com.studentManagementSystem.service.StudentService;

@Controller
@RequestMapping("api/student")
public class StudentController {

	private StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		super();

		this.studentService = studentService;
	}

	// hendler method to hendle list of studients to view
	@GetMapping("/all")
	public String listStudents(Model model) {
		model.addAttribute("students", this.studentService.getAllStudents());
		return "students";
	}

	// Création d'un nouveau etudiant
	@GetMapping("/new")
	public String createStudentForm(Model model) {
		// create un etudiant 
		Student student =new Student();
		model.addAttribute("student", student);
		return "create_student";

	}
	
	@PostMapping("/save")
	public String saveStudent(@ModelAttribute("student") Student student)
	{
		this.studentService.saveStudent(student);
		return "redirect:/api/student/all";
	}

}
