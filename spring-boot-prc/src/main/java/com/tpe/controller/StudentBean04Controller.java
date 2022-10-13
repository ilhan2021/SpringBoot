package com.tpe.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tpe.domain.StudentBean04;
import com.tpe.service.StudentBean04Service;

@RestController
//gelirken javaya giderken jsona jockson dependency gururla sunar // Osman beyden
public class StudentBean04Controller {

	private StudentBean04Service studentBean04Service;
	//@Autowired
	public StudentBean04Controller(StudentBean04Service studentBean04) {
		this.studentBean04Service=studentBean04;
	}
	
	//http://localhost:8082/selectStudentById/101
	@GetMapping(path="/selectStudentById/{id}")
	public StudentBean04 selectStudentByIdCont(@PathVariable Long id) {
		return studentBean04Service.selectStudentById(id);
	}
	
	@GetMapping(path="/selectStudentAll")
	public List<StudentBean04> selectStudentAll() {
		return studentBean04Service.selectStudentAll();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
