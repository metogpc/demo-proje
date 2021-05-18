package com.OYazilim.demo.Business;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.OYazilim.demo.DataAccess.IUserDal;
import com.OYazilim.demo.Entities.User;

@Repository
public class UserManager implements IUserService{

	private IUserDal userDal;
	
	@Autowired
	public UserManager(IUserDal userDal) {
		super();
		this.userDal = userDal;
	}

	
	@Override
	@Transactional
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userDal.getAll();
	}


	@Override
	@Transactional
	public void update(User user) {
		// TODO Auto-generated method stub
		userDal.update(user);
	}

	@Override
	@Transactional
	public void insert(User user) {
		// TODO Auto-generated method stub
		userDal.insert(user);
	}

	@Override
	@Transactional
	public void delete(User user) {
		// TODO Auto-generated method stub
		userDal.delete(user);
	}

	@Override
	@Transactional
	public User getById(int id) {
		// TODO Auto-generated method stub
		return userDal.getById(id);
	}
	
	

}