package com.bridge.crud.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bridge.crud.example.entity.Student;
import com.bridge.crud.example.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;

	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student) {
		return service.saveStudent(student);
	}

	@PostMapping("/addStudents")
	public List<Student> addStudent(@RequestBody List<Student> student) {
		return service.saveStudents(student);
	}

	@GetMapping("/students")
	public List<Student> findAllStudents() {
		return service.getStudents();
	}

	@GetMapping("/student/{id}")
	public Student findStudentbyId(@PathVariable int id) {
		return service.getStudentByID(id);
	}

	@PutMapping("/update")
	public Student updateStudent(@RequestBody Student student) {
		return service.updateStudent(student);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id) {
		return service.deleteStudent(id);
	}
	@PostMapping(value="/login/{userName}/{password}")
	public String login(@PathVariable String userName, @PathVariable String password) {

		return service.checkPassword(userName, password);
	}
	
	@PutMapping(value="/forgotPassword/{userName}/{password}")
	public String forgot(@PathVariable String userName, @PathVariable String password) {

		return service.resetPassword(userName, password);
	}

}
