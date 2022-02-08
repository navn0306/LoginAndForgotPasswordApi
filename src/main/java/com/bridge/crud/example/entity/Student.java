package com.bridge.crud.example.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "subject")
	private String subject;

	@Column(name = "email")
	private String email;

	@Column(name = "userName")
	private String userName;

	@Column(name = "password")
	private String password;

	public Student(int id, String name, String subject, String email, String userName, String password) {
		super();
		this.id = id;
		this.name = name;
		this.subject = subject;
		this.email = email;
		this.userName = userName;
		this.password = password;
	}

	public Student(Student s) {
		this.id = s.id;
		this.name = s.name;
		this.subject = s.subject;
		this.email = s.email;
		this.userName = s.userName;
		this.password = s.password;
	}

	public Student() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {

		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, name, password, subject, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(email, other.email) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && Objects.equals(subject, other.subject)
				&& Objects.equals(userName, other.userName);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", subject=" + subject + ", email=" + email + ", userName="
				+ userName + ", password=" + password + "]";
	}

}
