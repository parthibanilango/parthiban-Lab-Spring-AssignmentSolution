package com.greatlearning.springbootstudentapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.greatlearning.springbootstudentapp.entity.Student;
import com.greatlearning.springbootstudentapp.repository.StudentRepository;

/**
 * @author Parthiban Ilango
 * Implementation for student service
 */
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Override
	@Transactional
	public List<Student> findAll() {
		List<Student> students = studentRepository.findAll();
		return students;
	}

	@Override
	@Transactional
	public Student findById(int theId) {
		return studentRepository.findById(theId).get();
	}

	@Override
	@Transactional
	public void save(Student student) {
		studentRepository.save(student);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		studentRepository.deleteById(theId);
	}

}
