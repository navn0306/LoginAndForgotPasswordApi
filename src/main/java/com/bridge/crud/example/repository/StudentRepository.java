package com.bridge.crud.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridge.crud.example.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
