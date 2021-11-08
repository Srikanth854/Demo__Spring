package com.zemoso.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zemoso.springboot.thymeleafdemo.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

	public List<Department> findAll();

}
