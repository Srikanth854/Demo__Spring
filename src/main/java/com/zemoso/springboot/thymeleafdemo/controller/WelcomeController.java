package com.zemoso.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.zemoso.springboot.thymeleafdemo.dto.StudentDto;
import com.zemoso.springboot.thymeleafdemo.service.StudentService;

@Controller
public class WelcomeController {

    private StudentService studentService;


    public WelcomeController(StudentService theStudentService) {
        studentService=theStudentService;
    }

    @GetMapping("/")
    public String listStudents(Model theModel)

    {

        List<StudentDto> theStudents = studentService.findAll();

        theModel.addAttribute("students",theStudents);

        return "students/list-students";
    }

}
