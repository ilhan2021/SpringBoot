package com.tpe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.tpe.domain.Kisi;
import com.tpe.repository.KisiRepository;

@Service
public class KisiService {

	private KisiRepository kisiRepository;
	@Autowired
	public KisiService(KisiRepository kisiRepo) {
		this.kisiRepository=kisiRepo;
	}
	
	//veritabanına kişi ekleyen servis metodu oluşturalım
	public Kisi createKisi(Kisi kisi) {
		return kisiRepository.save(kisi);
	}
	
	public List<Kisi> getKisi(){
		return kisiRepository.findAll();
	}
	
	//id ile kişi güncelle
	public Kisi idIleKisiGuncelle(Integer id,Kisi updateKisi) {
		Kisi bulubanKisi= kisiRepository.findById(id).orElseThrow(()-> new IllegalStateException(id+" li kişi bulunamadı"));
		if (updateKisi.getAd()!=null) {
			bulubanKisi.setAd(updateKisi.getAd());
		}
		if (updateKisi.getSoyad()!=null) {
			bulubanKisi.setSoyad(updateKisi.getSoyad());
		}
		if (updateKisi.getYas()!=0) {
			bulubanKisi.setYas(updateKisi.getYas());
		}
		return kisiRepository.save(bulubanKisi);
	}
	
	public String idIleKisiSilen(Integer id) {
		if (kisiRepository.findById(id)==null) {
			throw new EmptyResultDataAccessException(id);
		}
		kisiRepository.deleteById(id);
		return id+" id'li kişi silindi";
	}
}
