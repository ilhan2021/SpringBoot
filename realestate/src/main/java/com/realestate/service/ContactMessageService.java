package com.realestate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realestate.domain.ContactMessage;
import com.realestate.repository.ContactMessageRepository;

@Service
public class ContactMessageService {

	private ContactMessageRepository contactMessageRepository;

	@Autowired
	public ContactMessageService(ContactMessageRepository contactMessageRepository) {
		super();
		this.contactMessageRepository = contactMessageRepository;
	}

	public void saveMessage(ContactMessage contactMessage) {
		contactMessageRepository.save(contactMessage);
	}

	public List<ContactMessage> getAllMessage() {
		return contactMessageRepository.findAll();
	}

}
