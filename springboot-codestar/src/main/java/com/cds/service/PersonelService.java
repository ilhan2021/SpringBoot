package com.cds.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cds.domain.Personel;
import com.cds.exception.ConflictException;
import com.cds.exception.ResourceNotFoundException;
import com.cds.personelDTO.PersonelDTO;
import com.cds.repository.PersonelRepository;

@Service
public class PersonelService {
	
	@Autowired
	 private PersonelRepository personelRepository;
	

	public List<Personel> getAllPersonel() {
		return personelRepository.findAll();
		
		
		
	}


	public void createPersonel( Personel personel) {
		if (personelRepository.existsByEmail(personel.getEmail())) {
			
			throw new ConflictException("Email zaten var ");
			
			
		}
	
		personelRepository.save(personel);
	}


	public Personel findPersonel(Long id) {
		return personelRepository.findById(id).
				orElseThrow(()-> new ResourceNotFoundException(id+" id'li personel yok"));
		
		
	}


	public void deletePersonel(Long id) {
		personelRepository.delete(findPersonel(id));
	}


	public void updatePersonelById(Long id, PersonelDTO personelDTO) {
		Personel personel=findPersonel(id);
		personel.setName(personelDTO.getName());
		personel.setLastName(personelDTO.getLastName());
		personel.setPhoneNumber(personelDTO.getPhoneNumber());
		personel.setJob(personelDTO.getJob());
		personel.setAddress(personelDTO.getAddress());
		personelRepository.save(personel);
		
	}


	public Page<Personel> getAllWithPagePs(Pageable pageable) {
		
		return personelRepository.findAll(pageable);
	}


	public List<Personel> findAllPersonelJob(String job) {
	
		return personelRepository.findAllEqualsJob(job);
	}


	public PersonelDTO findPersonelDTOById(Long id) {
		
		return personelRepository.findPersonelDTOById(id).
				orElseThrow(()-> new ResourceNotFoundException("personel yok"+ id ));
	}


	
		
		
	}


