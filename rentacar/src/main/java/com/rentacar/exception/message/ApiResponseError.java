package com.rentacar.exception.message;

import java.time.LocalDateTime;

import javax.management.loading.PrivateClassLoader;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import antlr.TokenStreamHiddenTokenFilter;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ApiResponseError {
	private HttpStatus status;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy HH:mm")
	@Setter(AccessLevel.NONE)
	private LocalDateTime timeStamp;
	
	private String message;
	
	private String requestURI;
	
	private ApiResponseError() {
		timeStamp = LocalDateTime.now();
	}
	


	public ApiResponseError(HttpStatus status) {
		this();
		this.status = status;
		
	}
	
	public ApiResponseError(HttpStatus status, String meesage, String requestURI ) {
		this(status);
		this.status = status;
		this.message = message;
		this.requestURI = requestURI;
	}

	
	
	

}
