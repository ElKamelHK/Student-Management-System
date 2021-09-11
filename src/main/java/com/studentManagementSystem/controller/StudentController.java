package com.studentManagementSystem.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";

	}

	@PostMapping("/save")
	public String saveStudent(@ModelAttribute("student") Student student) {
		this.studentService.saveStudent(student);
		return "redirect:/api/student/all";
	}

	// create update student view
	@GetMapping("/update/{id}")
	public String updateStudentForm(Model model, @PathVariable("id") Long id) {
		Optional<Student> opStudent = this.studentService.optionalStudentById(id);
		if (!opStudent.isPresent())
			return "404";
		else {
			model.addAttribute("student", opStudent.get());
			return "update_student";
		}

	}

	@PostMapping("/update")
	public String updateStudent(@ModelAttribute("student") Student student, RedirectAttributes redirectAttributes) {

		Student st = this.studentService.updateStudent(student);
		
		if (st == null) {
			redirectAttributes.addFlashAttribute("message", "THIS STUDENT NOT FOUND BLEASE VERIFY YOUR REQUEST !!");
			redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
			return "redirect:/api/student/update/" + student.getId();
		}

		redirectAttributes.addFlashAttribute("message", "Success");
		redirectAttributes.addFlashAttribute("alertClass", "alert-success");
		return "redirect:/api/student/update/" + student.getId();

	}

}
