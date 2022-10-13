package com.cds.personelDTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.cds.domain.Personel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonelDTO {
	
	
	private Long id;
	
	@NotNull(message = "bos gecilemez")
	@NotBlank(message = "bos gecmeyelim gardas :)")
	@Size(min = 2, max = 30, message = " name '${validatedValue}' must be between {min} and {max} long")
	
	private String name;
	
	
	private String lastName;
	
	
	private String phoneNumber;
	
	
	@Email(message = "Gecerli bir email giriniz")
	private String email;
	
	
	private String job;
	
	
	private String address;
	
	public PersonelDTO(Personel personel) {
		this.id=personel.getId();
		this.name=personel.getName();
		this.lastName=personel.getLastName();
		this.phoneNumber=personel.getPhoneNumber();
		this.job=personel.getJob();
		this.address=personel.getAddress();
		
	}

}



