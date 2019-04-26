package com.iiit.train.springboot.mybatisdemo.dao;

import java.util.List;

import com.iiit.train.springboot.mybatisdemo.vo.User;


/**
 *  
 * @author Administrator
 *
 */
public interface UserDao {

	/**
	 * 新增用户
	 * @param user
	 */
	void createUser(User user);
	/**
	 * 查询用户列表
	 * @return
	 */
	List<User> findAllUser();
}
