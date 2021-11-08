package com.zemoso.springboot.thymeleafdemo.service;

import java.util.List;

import com.zemoso.springboot.thymeleafdemo.entity.Department;


public interface DepartmentService {

	public List<Department> findAll();
	public Department findById(int theId);
	public void save(Department theDepartment);
	public void deleteById(int theId);

}
