package com.zemoso.springboot.thymeleafdemo.service;

import java.util.List;

import com.zemoso.springboot.thymeleafdemo.dto.StudentDto;
import com.zemoso.springboot.thymeleafdemo.entity.Student;



public interface StudentService {

	public List<StudentDto> findAll();
	public StudentDto findById(int theId);
	public void save(StudentDto theStudent);
	public void deleteById(int theId);
	

}
