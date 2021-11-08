package com.zemoso.springboot.thymeleafdemo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zemoso.springboot.thymeleafdemo.dao.DepartmentRepository;
import com.zemoso.springboot.thymeleafdemo.entity.Department;
import com.zemoso.springboot.thymeleafdemo.exceptionhandler.DepartmentNotFoundException;
import com.zemoso.springboot.thymeleafdemo.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentRepository departmentRepository;
	
	@Autowired
	public DepartmentServiceImpl(DepartmentRepository theDepartmentRepository) {
		departmentRepository =theDepartmentRepository;
	}
	
	
	
	@Override
	public List<Department> findAll() {
		
		return departmentRepository.findAll();
	}



	@Override
	public Department findById(int theId) {
		Optional<Department> result = departmentRepository.findById(theId);
		Department theDepartment=null;
		if(result.isPresent())
		{
			theDepartment=result.get();
		}
		else {
			throw new DepartmentNotFoundException("Did not find DEPARTMENT id - "+theId);
		}
		return theDepartment;
		
		
	}
	
	@Override
	public void save(Department theDepartment) {

		departmentRepository.save(theDepartment);

	}



	@Override
	public void deleteById(int theId) {
		departmentRepository.deleteById(theId);
		
	}


}
