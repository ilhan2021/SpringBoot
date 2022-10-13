package com.tpe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpe.domain.StudentBean04;
import com.tpe.repository.StudentBean04Repository;

@Service
public class StudentBean04Service {

	private StudentBean04Repository studentRepo;
	@Autowired
	public StudentBean04Service(StudentBean04Repository repo) {
		this.studentRepo=repo;
	}
	
	//id si ile ogrenci getiren method create ediniz
	public StudentBean04 selectStudentById(Long id) {
		if(studentRepo.findById(id).isPresent()) {
			return studentRepo.findById(id).get();
		}
		return new StudentBean04();
	}
	
	//tum ogrencileri getiren method create ediniz
	public List<StudentBean04> selectStudentAll(){
		return studentRepo.findAll();
	}
	
	
	
}
