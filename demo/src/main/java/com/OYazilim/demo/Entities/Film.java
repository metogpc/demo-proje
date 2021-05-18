package com.OYazilim.demo.Entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="film")
public class Film {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="ad")
	private String ad;
	@Column(name="yayin_yil")
	private int yayin_yil;
	@Column(name="aciklama")
	private String aciklama;
	@Column(name="medya")
	private String medya;
	@Column(name="dil")
	private String dil;
	@Column(name="tur")
	private String tur;
	
	@OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
	private List<Oyuncu> Oyuncular;

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", ad=" + ad + ", yayin_yil=" + yayin_yil + ", aciklama=" + aciklama + ", medya="
				+ medya + ", Oyuncular=" + Oyuncular + "]";
	}

	public List<Oyuncu> getOyuncular() {
		return Oyuncular;
	}

	public void setOyuncular(List<Oyuncu> oyuncular) {
		Oyuncular = oyuncular;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public int getYayin_yil() {
		return yayin_yil;
	}

	public void setYayin_yil(int yayin_yil) {
		this.yayin_yil = yayin_yil;
	}

	public String getAciklama() {
		return aciklama;
	}

	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}

	public String getMedya() {
		return medya;
	}

	public void setMedya(String medya) {
		this.medya = medya;
	}

	public String getDil() {
		return dil;
	}

	public void setDil(String dil) {
		this.dil = dil;
	}

	public String getTur() {
		return tur;
	}

	public void setTur(String tur) {
		this.tur = tur;
	}

	
}
