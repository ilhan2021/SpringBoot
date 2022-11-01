package com.rentacar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentacar.service.ContactMessageService;

@RestController
@RequestMapping("/contactmessage")
public class ContactMessageController {
	
	private ContactMessageService contactMessageService;

	@Autowired
	public ContactMessageController(ContactMessageService contactMessageService) {
		this.contactMessageService = contactMessageService;
	}
	

}
