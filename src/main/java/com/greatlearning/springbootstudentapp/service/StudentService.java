package com.greatlearning.springbootstudentapp.service;

import java.util.List;

import com.greatlearning.springbootstudentapp.entity.Student;

/**
 * @author Parthiban Ilango
 * Student service interface
 */
public interface StudentService {

	public List<Student> findAll();

	public Student findById(int theId);

	public void save(Student student);

	public void deleteById(int theId);

	

}
