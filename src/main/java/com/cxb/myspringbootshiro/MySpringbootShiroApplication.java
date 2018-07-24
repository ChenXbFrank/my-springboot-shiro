package com.cxb.myspringbootshiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cxb.myspringbootshiro.dao")
public class MySpringbootShiroApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringbootShiroApplication.class, args);
	}
}
