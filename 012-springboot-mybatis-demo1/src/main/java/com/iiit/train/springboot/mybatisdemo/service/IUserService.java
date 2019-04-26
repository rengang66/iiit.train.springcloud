package com.iiit.train.springboot.mybatisdemo.service;

import java.util.List;

import com.iiit.train.springboot.mybatisdemo.vo.User;


public interface IUserService {

	/**
	 * 新增用户
	 * @param user
	 */
	public void createUser(User user);
	/**
	 * 查询用户列表
	 * @return
	 */
	public List<User> findAllUser();
}
