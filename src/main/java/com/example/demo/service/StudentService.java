package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class StudentService {
	 
	    private final StudentRepository studentRepository;
	 
	 public List<Student> getAllStudents(){
		 return studentRepository.findAll();
	 }
	 public Optional<Student> getStudentById(Long Id){
		 return studentRepository.findById(Id);
		 
	 }
	    public Student createStudent(Student student) {
	        return studentRepository.save(student);
	    } 
	    public Student updateStudent(Long id, Student updatedStudent) {
	        Optional<Student> existingStudentOptional = studentRepository.findById(id);
	        if (existingStudentOptional.isPresent()) {
	           
	            return studentRepository.save(updatedStudent);
	        } else {
	         
	            return null;
	        }
	        }
	 public void deleteStudent (Long id) {
		 studentRepository.deleteById(id);
	 }
}
