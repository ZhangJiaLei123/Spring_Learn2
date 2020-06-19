package com.example.demo;

import javax.annotation.Resource;
import com.example.demo.service.*;
  

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EDemoApplication {

	@Resource(name="userService")
	static private UserService us;
  
    
	public static void main(String[] args) {
		System.out.println("测试程序开始");
		SpringApplication.run(EDemoApplication.class, args);
		
		try {
			 us.save("111");
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		  
		System.out.println("测试启动完成");
	}


    
}
