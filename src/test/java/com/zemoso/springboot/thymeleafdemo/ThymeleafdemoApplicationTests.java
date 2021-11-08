package com.zemoso.springboot.thymeleafdemo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.zemoso.springboot.thymeleafdemo.dao.DepartmentRepository;
import com.zemoso.springboot.thymeleafdemo.dao.StudentRepository;
import com.zemoso.springboot.thymeleafdemo.entity.Department;
import com.zemoso.springboot.thymeleafdemo.entity.Student;
import com.zemoso.springboot.thymeleafdemo.service.DepartmentService;
import com.zemoso.springboot.thymeleafdemo.service.StudentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThymeleafdemoApplicationTests{

	@Autowired
	private StudentService studentService;

	@MockBean
	private StudentRepository studentRepository;
	
	@Autowired
	private DepartmentService departmentService;
	
	@MockBean
	private DepartmentRepository departmentRepository;
	

	@Test
	public void Test1() {
		when(departmentRepository.findAll()).thenReturn(Stream
				.of(new Department( 1,"dname",  "dcode","demail"), new Department(2, "dname", "dcode","demail")).collect(Collectors.toList()));
		assertEquals(2, departmentService.findAll().size());
	}
	@Test
	public  void check()
	{
		Department dept=new Department(1,"dname","dcode","demail");
		Student thestudent=new Student();
		thestudent.setId(1);
		thestudent.setFirstName("student2firstname");
		thestudent.setLastName("student2lastname");
		thestudent.setEmail("email");
		thestudent.setDepartment(dept);

		Student thestudent2=new Student();
		thestudent2.setId(2);
		thestudent2.setFirstName("student2firstname");
		thestudent2.setLastName("student2lastname");
		thestudent2.setEmail("student2email");
		thestudent2.setDepartment(dept);

		ArrayList<Student> studentList=new ArrayList<>();
		studentList.add(thestudent);
		studentList.add(thestudent2);
		when(studentRepository.findAll()).thenReturn(studentList);
		assertEquals(studentList.size(),2);



	}
	}


