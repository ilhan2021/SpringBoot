package com.tpro.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
<<<<<<< HEAD

=======
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
>>>>>>> 6a9d3e2701882f8f7481aa6fe02c51b5a5b55278

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="First name can not be null")
	@NotBlank(message="Last name can not be White space")
	@Size(min=2, max=25, message="First Name '${validateValue}' must be between {min} and {max} long")
	@Column(nullable = false , length = 25)
<<<<<<< HEAD
	private String name;
=======
	private String firstname;
>>>>>>> 6a9d3e2701882f8f7481aa6fe02c51b5a5b55278
	@Column(nullable = false , length = 25)
	private String lastName;
	@Column
	private Integer grade;
	@Column(nullable =false , length = 50)
	@Email(message="Provide valid email")
	private String email;
	@Column
	private String phoneNumber;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy HH:mm:ss",timezone = "Turkey")
	private LocalDateTime createDate = LocalDateTime.now();
	
	@OneToMany(mappedBy = "student")
	private List<Book> books = new ArrayList<>();
		
	}
