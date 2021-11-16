package com.zemoso.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zemoso.springboot.thymeleafdemo.dto.StudentDto;
import com.zemoso.springboot.thymeleafdemo.entity.Student;
import com.zemoso.springboot.thymeleafdemo.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

	
	private StudentService studentService;
	
	
	public StudentController(StudentService theStudentService) {
		studentService=theStudentService;
	}
	

	
	
	@GetMapping("/list")
	public String listStudents(Model theModel)
	
	{

			List<StudentDto> theStudents = studentService.findAll();
		 
		theModel.addAttribute("students",theStudents);
		
		return "students/list-students";
	}
	
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int theId,
									Model theModel) {
		
		// get the employee from the service
		StudentDto theStudent = studentService.findById(theId);

		
		// set employee as a model attribute to pre-populate the form
		theModel.addAttribute("student", theStudent);
		
		// send over to our form
		return "students/student-form";
	}
	
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Student theStudent = new Student();
		
		theModel.addAttribute("student", theStudent);
		
		return "students/student-form";
	}
	@PostMapping("/save")
	public String saveStudent(@ModelAttribute("student") StudentDto theStudent, BindingResult bindingResult,Model model) {
		if(bindingResult.hasErrors())
		{
			
			return "students/student-form";
		}

		
		studentService.save(theStudent);
		
		return "redirect:/students/list";
		
	}
	@GetMapping("/delete")
	public String delete(@RequestParam("studentId") int theId) {
		studentService.deleteById(theId);
		return "redirect:/students/list";
	}

	@GetMapping("/logout")
	public String logout(){
		return "fancy-login";
	}
}
