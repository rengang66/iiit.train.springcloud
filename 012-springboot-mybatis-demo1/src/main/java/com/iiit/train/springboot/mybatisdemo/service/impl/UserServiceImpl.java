package com.iiit.train.springboot.mybatisdemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiit.train.springboot.mybatisdemo.dao.UserDao;
import com.iiit.train.springboot.mybatisdemo.service.IUserService;
import com.iiit.train.springboot.mybatisdemo.vo.User;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	public UserDao userDao;
	
	@Override
	public void createUser(User user) {
		userDao.createUser(user);
	}

	@Override
	public List<User> findAllUser() {
		return userDao.findAllUser();
	}

}
