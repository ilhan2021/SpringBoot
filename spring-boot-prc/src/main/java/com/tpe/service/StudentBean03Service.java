package com.tpe.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tpe.domain.StudentBean03;

@Service
public class StudentBean03Service {

	List<StudentBean03> listOfStudent=List.of(new StudentBean03(101L,"ali can","as@gmail.com",
			LocalDate.of(2020, 5, 5)),
			new StudentBean03(102L,"memet can","asa@gmail.com",
					LocalDate.of(2020, 5, 5)),
			new StudentBean03(103L,"ismail can","ass@gmail.com",
					LocalDate.of(2020, 5, 5)),
			new StudentBean03(104L,"kerem can","ass@gmail.com",
					LocalDate.of(2020, 5, 5))
			);
	public StudentBean03 getStudentById(Long id) {
		if(listOfStudent.stream().filter(t->t.getId()==id).collect(Collectors.toList()).isEmpty()) {
			return new StudentBean03();
		}
		
		return listOfStudent.stream().filter(t->t.getId()==id).findFirst().get();
	}
	//tum ogrencileri donduren
	public List<StudentBean03> getAllStudents(){
		return listOfStudent;
	}
	
	
	
	
}
