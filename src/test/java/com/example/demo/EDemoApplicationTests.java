package com.example.demo;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
 

@SpringBootTest
//指定创建容器时使用的配置文件
@ContextConfiguration("classpath:com/qlq/XMLaspect/applicationContext.xml")
class EDemoApplicationTests {


    
	@Test
	void contextLoads() {
		System.out.println("测试");
		try {
		
		}catch (Exception e) {
			// TODO: handle exception
		}
	   
		
		//SpringApplication.run(SpringXMLAopTest.class);
	}

}
