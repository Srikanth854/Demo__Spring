package com.zemoso.springboot.thymeleafdemo.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.zemoso.springboot.thymeleafdemo.dto.StudentDto;
import com.zemoso.springboot.thymeleafdemo.entity.Student;

@Component
public class StudentConverter {
    public StudentDto entityToDto(Student student){
        StudentDto dto=new StudentDto();
        dto.setId(student.getId());
        dto.setFirstName(student.getFirstName());
        dto.setLastName(student.getLastName());
        dto.setEmail(student.getEmail());
        dto.setDepartment(student.getDepartment());
        return dto;
    }
    public Student dtoToEntity(StudentDto studentDto){
        Student student=new Student();
        student.setId(studentDto.getId());
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setEmail(studentDto.getEmail());
        student.setDepartment(studentDto.getDepartment());
        return student;
    }
    public List<StudentDto> entityToDto(List<Student> student){

        return student.stream().map(x->entityToDto(x)).collect(Collectors.toList());
     }

     public List<Student> dotToEntity(List<StudentDto> studentDtos){

         return studentDtos.stream().map(x->dtoToEntity(x)).collect(Collectors.toList());
     }




}
