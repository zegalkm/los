package com.ncos.user.service;

import java.util.Collection;

import com.ncos.user.entity.User;

public interface IUserService {

	Collection<User> getList();
	boolean saveUser(User user);
}
