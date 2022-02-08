package com.bridge.crud.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridge.crud.example.entity.Student;
import com.bridge.crud.example.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepo;

	public Student saveStudent(Student student) {
		return studentRepo.save(student);
	}

	public List<Student> saveStudents(List<Student> student) {
		return studentRepo.saveAll(student);
	}

	public List<Student> getStudents() {
		return studentRepo.findAll();
	}

	public Student getStudentByID(int id) {
		return studentRepo.findById(id).orElse(null);
	}

	public String deleteStudent(int id) {
		studentRepo.deleteById(id);
		return "Student Deleted !!!";
	}

	public Student updateStudent(Student student) {
		Student existingStudent = studentRepo.findById(student.getId()).orElse(null);
		existingStudent.setName(student.getName());
		existingStudent.setSubject(student.getSubject());
		existingStudent.setEmail(student.getEmail());
		return studentRepo.save(existingStudent);
	}

	public String checkPassword(String userName, String password) {
		List<Student> students = studentRepo.findAll();
		for (Student other : students) {
			if (other.getUserName().equals(userName) && other.getPassword().equals(password)) {
				return "Logged In";
			}
		}
		return "Login Failed";
	}

	public String resetPassword(String userName, String password) {
		List<Student> students = studentRepo.findAll();
		for (Student other : students) {
			if (other.getUserName().equals(userName)) {
				Student student = new Student(other);
				student.setPassword(password);
				studentRepo.delete(other);
				studentRepo.save(student);
				return "Updated Password";
			}
		}
		return "UserName not found";
	}
	
}
