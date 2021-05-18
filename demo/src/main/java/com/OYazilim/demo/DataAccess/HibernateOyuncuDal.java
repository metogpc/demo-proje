package com.OYazilim.demo.DataAccess;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.OYazilim.demo.Entities.Oyuncu;

@Repository
public class HibernateOyuncuDal implements IOyuncuDal{

	@Autowired
	private EntityManager entityManager;
	
	public HibernateOyuncuDal(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public List<Oyuncu> getAll() {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class);
		List<Oyuncu> oyuncular=session.createQuery("from Oyuncu").getResultList();
		return oyuncular;
	}

	@Override
	@Transactional
	public void update(Oyuncu oyuncu) {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class);
		session.update(oyuncu);
	}

	@Override
	@Transactional
	public void insert(Oyuncu oyuncu) {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class);
		session.save(oyuncu);	}

	@Override
	@Transactional
	public void delete(Oyuncu oyuncu) {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class);
		session.delete(oyuncu);
	}

	@Override
	@Transactional
	public Oyuncu getById(int id) {
		// TODO Auto-generated method stub
		Session session=entityManager.unwrap(Session.class);
		Oyuncu oyuncu=session.get(Oyuncu.class, id);
		return oyuncu;
	}

	
}
