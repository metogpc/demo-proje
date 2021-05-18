package com.OYazilim.demo.DataAccess;
import java.util.List;

import com.OYazilim.demo.Entities.User;


public interface IUserDal {
	List<User> getAll();
	void update(User user);
	void insert(User user);
	void delete(User user);
	User getById(int id);
	
}
