package com.realestate.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.realestate.domain.ContactMessage;
import com.realestate.dto.ContactMessageDTO;
import com.realestate.dto.request.ContactMessageRequest;
import com.realestate.dto.response.VRResponse;
import com.realestate.mapper.ContactMessageMapper;
import com.realestate.service.ContactMessageService;

@RestController
@RequestMapping("/contactmessage")
public class ContactMessageController {

	private ContactMessageService contactMessageService;

	private ContactMessageMapper contactMessageMapper;

	@Autowired
	public ContactMessageController(ContactMessageService contactMessageService,
			ContactMessageMapper contactMessageMapper) {
		super();
		this.contactMessageService = contactMessageService;
		this.contactMessageMapper = contactMessageMapper;
	}

	@PostMapping("/visitors")
	public ResponseEntity<VRResponse> createMessage(@Valid @RequestBody ContactMessageRequest contactMessageRequest) {

		ContactMessage contactMessage = contactMessageMapper.contactMessageRequestToMessage(contactMessageRequest);

		contactMessageService.saveMessage(contactMessage);
		VRResponse vrResponse = new VRResponse("Your message create successfully ", true);

		return ResponseEntity.ok(vrResponse);
	}

	@GetMapping("/visitors")
	public ResponseEntity<List<ContactMessageDTO>> getAllMessage() {
		List<ContactMessage> contactMessagesList = contactMessageService.getAllMessage();
		List<ContactMessageDTO> contactMessageDTOsList = contactMessageMapper.map(contactMessagesList);
		return ResponseEntity.ok(contactMessageDTOsList); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ContactMessageDTO> getMessageWithPath(@PathVariable("id") Long id){
		
		ContactMessage contactMessage=contactMessageService.getMessage(id);
		ContactMessageDTO contactMessageDTO=contactMessageMapper.contactMessageToDTO(contactMessage);
		
		return ResponseEntity.ok(contactMessageDTO);
	}
	
	@GetMapping("/request")
	public ResponseEntity<ContactMessageDTO> getMessageWithParam(@RequestParam("id") Long id){
		
		ContactMessage contactMessage=contactMessageService.getMessage(id);
		ContactMessageDTO contactMessageDTO=contactMessageMapper.contactMessageToDTO(contactMessage);
		
		return ResponseEntity.ok(contactMessageDTO);
	}

}
