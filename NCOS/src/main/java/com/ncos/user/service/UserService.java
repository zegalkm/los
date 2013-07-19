package com.ncos.user.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncos.user.dao.UserDao;
import com.ncos.user.entity.User;
@Service("userService")
public class UserService implements IUserService{

	@Autowired
	UserDao userDao;
	
	public Collection<User> getList() {
		return userDao.getList();
	}


	public boolean saveUser(User user) {
		return userDao.saveUser(user);
	}

}
