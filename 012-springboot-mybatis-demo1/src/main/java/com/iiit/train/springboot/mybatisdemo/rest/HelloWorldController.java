package com.iiit.train.springboot.mybatisdemo.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/greeting")
public class HelloWorldController {

	@RequestMapping("/sayHello")
	public String hello(){
		return "Hello,world!";
	}
	
}
