package com.ncos.user.dao;

import java.util.Collection;

import com.ncos.user.entity.User;

public interface UserDao {

	Collection<User> getList();
	boolean saveUser(User user);
}
