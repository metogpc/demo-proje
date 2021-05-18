package com.OYazilim.demo.Business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OYazilim.demo.DataAccess.IOyuncuDal;
import com.OYazilim.demo.Entities.Oyuncu;

@Service
public class OyuncuManager implements IOyuncuService{

	@Autowired
	private IOyuncuDal oyuncuDal;

	public OyuncuManager(IOyuncuDal oyuncuDal) {
		super();
		this.oyuncuDal = oyuncuDal;
	}

	@Override
	public List<Oyuncu> getAll() {
		// TODO Auto-generated method stub
		return oyuncuDal.getAll();
	}

	@Override
	public void update(Oyuncu oyuncu) {
		// TODO Auto-generated method stub
		oyuncuDal.update(oyuncu);
	}

	@Override
	public void insert(Oyuncu oyuncu) {
		// TODO Auto-generated method stub
		oyuncuDal.insert(oyuncu);
	}

	@Override
	public void delete(Oyuncu oyuncu) {
		// TODO Auto-generated method stub
		oyuncuDal.delete(oyuncu);
	}

	@Override
	public Oyuncu getById(int id) {
		// TODO Auto-generated method stub
		return oyuncuDal.getById(id);
	}
	
	

}
