package com.OYazilim.demo.Business;

import java.util.List;

import com.OYazilim.demo.Entities.User;

public interface IUserService {
	List<User> getAll();
	void update(User user);
	void insert(User user);
	void delete(User user);
	User getById(int id);
}