package com.OYazilim.demo.DataAccess;

import java.util.List;

import com.OYazilim.demo.Entities.Oyuncu;

public interface IOyuncuDal {

	List<Oyuncu> getAll();
	void update(Oyuncu oyuncu);
	void insert(Oyuncu oyuncu);
	void delete(Oyuncu oyuncu);
	Oyuncu getById(int id);
}
