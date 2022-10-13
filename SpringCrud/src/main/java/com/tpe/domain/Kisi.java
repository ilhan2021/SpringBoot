package com.tpe.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="kisiler")
//@Data    //parametreli cons+getter+setter
//@NoArgsConstructor //parametresiz cons.
//https://projectlombok.org/download
public class Kisi {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // id yi otomatik versin
	private Integer id;
	
	private String ad;
	
	private String soyad;
	
	private int yas; 
	public Kisi() {}
	public Kisi(Integer id, String ad, String soyad, int yas) {
	
		this.id = id;
		this.ad = ad;
		this.soyad = soyad;
		this.yas = yas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public int getYas() {
		return yas;
	}

	public void setYas(int yas) {
		this.yas = yas;
	}

	@Override
	public String toString() {
		return "Kisi [id=" + id + ", ad=" + ad + ", soyad=" + soyad + ", yas=" + yas + "]";
	}
	
	
	
}
