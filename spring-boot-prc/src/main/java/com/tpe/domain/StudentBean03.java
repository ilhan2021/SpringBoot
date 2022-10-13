package com.tpe.domain;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class StudentBean03 {
	private Long id;
	private String name;
	private String email;
	private LocalDate dob;
	private Integer age;
	
	private String errMsg;
	public StudentBean03(Long id, String name, String email, LocalDate dob) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.errMsg="no error...";
	}

	public StudentBean03() {
		this.errMsg="there is no any studdents like that ....";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	@Override
	public String toString() {
		return "StudentBean03 [id=" + id + ", name=" + name + ", email=" + email + ", dob=" + dob + ", age=" + age
				+ ", errMsg=" + errMsg + "]";
	}


		
	
	
}
