package com.greatlearning.springbootstudentapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.springbootstudentapp.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
}