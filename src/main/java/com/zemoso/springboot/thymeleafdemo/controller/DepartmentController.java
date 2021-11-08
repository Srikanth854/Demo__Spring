package com.zemoso.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zemoso.springboot.thymeleafdemo.entity.Department;

import com.zemoso.springboot.thymeleafdemo.service.DepartmentService;

@Controller
@RequestMapping("/departments")
public class
DepartmentController {

private DepartmentService departmentService;


@Autowired
public DepartmentController(DepartmentService theDepartmentService) {

	departmentService=theDepartmentService;
}


@GetMapping("/list")
public String listDepartments(Model theModel)
{
	 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	List<Department> theDepartments=departmentService.findAll(); 
	 
	theModel.addAttribute("departments",theDepartments);
	return "departments/list-departments";
}
@PostMapping("/save")
public String saveDepartment(@ModelAttribute("department") Department theDepartment) {
	
	departmentService.save(theDepartment);
	
	return "redirect:/departments/list";
	
}


@GetMapping("/showFormForAdd")
public String showFormForAdd(Model theModel) {
	
	// create model attribute to bind form data
	Department theDepartment = new Department();
	
	theModel.addAttribute("department", theDepartment);
	
	return "departments/department-form";
}

@GetMapping("/showFormForUpdate")
public String showFormForUpdate(@RequestParam("departmentId") int theId,
								Model theModel) {
	
	// get the employee from the service
	Department theDepartment = departmentService.findById(theId);
	
	// set employee as a model attribute to pre-populate the form
	theModel.addAttribute("department", theDepartment);
	
	// send over to our form
	return "departments/department-form";

}
@GetMapping("/delete")
public String delete(@RequestParam("departmentId") int theId) {
	departmentService.deleteById(theId);
	return "redirect:/departments/list";
}

}
