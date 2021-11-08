package com.zemoso.springboot.thymeleafdemo.serviceImpl;

import java.util.List;
import java.util.Optional;

import com.zemoso.springboot.thymeleafdemo.exceptionhandler.DepartmentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zemoso.springboot.thymeleafdemo.converter.StudentConverter;
import com.zemoso.springboot.thymeleafdemo.dao.StudentRepository;
import com.zemoso.springboot.thymeleafdemo.dto.StudentDto;
import com.zemoso.springboot.thymeleafdemo.entity.Student;
import com.zemoso.springboot.thymeleafdemo.exceptionhandler.StudentNotFoundException;
import com.zemoso.springboot.thymeleafdemo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	private StudentRepository studentRepository;
	
	@Autowired
	 public StudentServiceImpl(StudentRepository theStudentRepository) {
		studentRepository=theStudentRepository ;
	}
	
	@Autowired
	public StudentConverter studentConverter;


	@Override
	public List<StudentDto> findAll() {
		List<Student> students=studentRepository.findAllByOrderByLastNameAsc();


		return studentConverter.entityToDto(students);

	}
	@Override
	public void save(StudentDto studentDto) {
			Student student = studentConverter.dtoToEntity(studentDto);


		studentRepository.save(student);

	}

	@Override
	public StudentDto findById(int theId) {
		Optional<Student> result = studentRepository.findById(theId);
		Student theStudent=null;
		if(result.isPresent())
		{
			theStudent=result.get();
		}
		else {
			throw new StudentNotFoundException("Did not find Student Id - "+theId);
		}
		return studentConverter.entityToDto(theStudent);
		}

	@Override
	public void deleteById(int theId) {
		
		
		studentRepository.deleteById(theId);
		
	}

}
