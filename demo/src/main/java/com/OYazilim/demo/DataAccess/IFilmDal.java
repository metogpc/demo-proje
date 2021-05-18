package com.OYazilim.demo.DataAccess;

import java.util.List;

import com.OYazilim.demo.Entities.Film;

public interface IFilmDal {
	
	List<Film> getAll();
	void update(Film film);
	void insert(Film film);
	void delete(Film film);
	Film getById(int id);
	List<Film> sortByYear();
	
}
