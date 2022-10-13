package com.tpe.config;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tpe.domain.StudentBean04;
import com.tpe.repository.StudentBean04Repository;

@Configuration
public class StudentBean04Config {
	
	@Bean//CommandLineRunner third party  Class i IoC ye bean olarak verildi
	CommandLineRunner commandLineRunner1(StudentBean04Repository studentRepo) {
		
		return args -> {//args in icine istedigimiz kadar istedigimiz type da objeler create eddili
			
			StudentBean04 aliCan = new StudentBean04(101L, "Ali Can", "ac@gmail.com", LocalDate.of(2002, Month.JANUARY, 21));
			StudentBean04 veliHan = new StudentBean04(102L, "Veli Han", "vh@gmail.com", LocalDate.of(2000, Month.MAY, 2));
			StudentBean04 maryStar = new StudentBean04(103L, "Mary Star", "ms@gmail.com", LocalDate.of(2001, Month.FEBRUARY, 12));
			
			studentRepo.saveAll(List.of(aliCan, veliHan, maryStar));//db mize jpa nin saveALl methodu ile insert edildi
		};
		
	}

}
