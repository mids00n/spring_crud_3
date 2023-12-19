package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

	private final StudentService studentService;
	@GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable long id) {
        return studentService.getStudentById(id).orElse(null);
    }
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
    	return new ResponseEntity<>(studentService.createStudent(student), HttpStatus.OK);
}

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return new ResponseEntity<> (studentService.updateStudent(id, student), HttpStatus.OK);
        
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable long id) {
        studentService.deleteStudent(id);
    }
	
}
