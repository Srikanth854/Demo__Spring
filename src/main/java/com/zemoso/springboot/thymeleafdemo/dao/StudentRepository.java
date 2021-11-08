package com.zemoso.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zemoso.springboot.thymeleafdemo.entity.Student;


public interface StudentRepository extends JpaRepository<Student, Integer> {

	public List<Student> findAllByOrderByLastNameAsc();
	
	 
}
