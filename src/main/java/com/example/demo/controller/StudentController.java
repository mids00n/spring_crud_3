package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
	private StudentService studentService;
	@GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable long id) {
        return studentService.getStudentById(id).orElse(null);
    }
    @PostMapping
    public ResponseEntity<Student> createStudent( 
    			@RequestParam String firstName,
    			@RequestParam String middleName,
    			@RequestParam String lastName) {
    	Student student = new Student();
    
    	student.setFirstName(firstName);
    	student.setMiddleName(middleName);
    	student.setLastName(lastName);

return new ResponseEntity<>(studentService.createStudent(student), HttpStatus.OK);
}

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestParam String firstName,
                                                 @RequestParam String middleName, @RequestParam String lastName) {
        Student updatedStudent = new Student();
        updatedStudent.setId(id);
        updatedStudent.setFirstName(firstName);
        updatedStudent.setMiddleName(middleName);
        updatedStudent.setLastName(lastName);

        Student updated = studentService.updateStudent(id, updatedStudent);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable long id) {
        studentService.deleteStudent(id);
    }
	
}
