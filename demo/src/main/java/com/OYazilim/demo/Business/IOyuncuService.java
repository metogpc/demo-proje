package com.OYazilim.demo.Business;

import java.util.List;

import com.OYazilim.demo.Entities.Oyuncu;

public interface IOyuncuService {

	List<Oyuncu> getAll();
	void update(Oyuncu oyuncu);
	void insert(Oyuncu oyuncu);
	void delete(Oyuncu oyuncu);
	Oyuncu getById(int id);
}
