package com.OYazilim.demo.DataAccess;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.OYazilim.demo.Entities.Film;

@Repository
public class HibernateFilmDal implements IFilmDal{

	@Autowired
	private EntityManager entityManager;
	
	public HibernateFilmDal(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public List<Film> getAll() {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class);
		List<Film> films=session.createQuery("from Film").getResultList();
		return films;
	}

	@Override
	@Transactional
	public void update(Film film) {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class);
		session.saveOrUpdate(film);
	}

	@Override
	@Transactional
	public void insert(Film film) {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class);
		session.saveOrUpdate(film);
	}

	@Override
	@Transactional
	public void delete(Film film) {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class);
		session.delete(film);
	}

	@Override
	@Transactional
	public Film getById(int id) {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class);
		Film film=session.get(Film.class, id);
		return film;
	}

	@Override
	@Transactional
	public List<Film> sortByYear() {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class);
		List<Film> films=session.createQuery("from Film f ORDER BY f.yayin_yil").getResultList();
		return films;
	}

}
