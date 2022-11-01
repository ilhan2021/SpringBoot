package com.realestate.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.realestate.service.ContactMessageService;

@RestController
@RequestMapping("/contactmessage")
public class ContactMessageController {
	
	private ContactMessageService contactMessageService;

	public ContactMessageController(ContactMessageService contactMessageService) {
	
		this.contactMessageService = contactMessageService;
	}
	
	

}
