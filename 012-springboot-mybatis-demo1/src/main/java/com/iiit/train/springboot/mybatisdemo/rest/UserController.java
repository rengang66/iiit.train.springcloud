package com.iiit.train.springboot.mybatisdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiit.train.springboot.mybatisdemo.service.IUserService;
import com.iiit.train.springboot.mybatisdemo.vo.User;


@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService service;
	@RequestMapping("/userList")
	public List<User> getUserList(){
		
		return service.findAllUser();
	}
	@RequestMapping("/add")
	public String addUser(@RequestBody User user){
		if(user!=null){
			service.createUser(user);
			return "success";
		}else{
			return "error";
		}
	}
	
	
}
