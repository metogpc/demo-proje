package com.OYazilim.demo.Business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OYazilim.demo.DataAccess.IFilmDal;
import com.OYazilim.demo.Entities.Film;

@Service
public class FilmManager implements IFilmService{

	@Autowired
	private IFilmDal filmDal;
	
	public FilmManager(IFilmDal filmDal) {
		super();
		this.filmDal = filmDal;
	}

	
	
	@Override
	public List<Film> getAll() {
		// TODO Auto-generated method stub
		return filmDal.getAll();
	}

	@Override
	public void update(Film film) {
		// TODO Auto-generated method stub
		System.out.println(film.getAd()+" "+film.getId()+" güncellendi");
		filmDal.update(film);
	}

	@Override
	public void insert(Film film) {
		// TODO Auto-generated method stub
		filmDal.insert(film);
	}

	@Override
	public void delete(Film film) {
		// TODO Auto-generated method stub
		System.out.println(film+" silindi service");
		filmDal.delete(film);
	}

	@Override
	public Film getById(int id) {
		// TODO Auto-generated method stub
		return filmDal.getById(id);
	}

	@Override
	public List<Film> sortByYear() {
		// TODO Auto-generated method stub
		return filmDal.sortByYear();
	}

	
}
