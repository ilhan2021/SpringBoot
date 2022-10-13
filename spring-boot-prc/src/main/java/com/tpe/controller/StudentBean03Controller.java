package com.tpe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tpe.domain.StudentBean03;
import com.tpe.service.StudentBean03Service;

@RestController
public class StudentBean03Controller {

	
	private StudentBean03Service std;
	
	@Autowired
	public StudentBean03Controller(StudentBean03Service std) {
		this.std=std;
	}
	
	@GetMapping(path="/getStudentById/{id}")
	public StudentBean03 getStudentById(@PathVariable Long id) {
		
		return std.getStudentById(id);
	}
	@GetMapping(path="/getStudentAll")
	public List<StudentBean03> getStudentAll() {
		
		return std.getAllStudents();
	}
	
	
	
}
