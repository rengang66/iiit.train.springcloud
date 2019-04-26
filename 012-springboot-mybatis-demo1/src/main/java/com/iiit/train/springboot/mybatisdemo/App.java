package com.iiit.train.springboot.mybatisdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * application 
 *
 * author:lsd
 */
@SpringBootApplication
@EnableScheduling
@MapperScan("com.iiit.train.springboot.mybatisdemo.dao")
public class App 
{
	
	
    public static void main( String[] args )
    {
       SpringApplication.run(App.class, args);
    }
}
