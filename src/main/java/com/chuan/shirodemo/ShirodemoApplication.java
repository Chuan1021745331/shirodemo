package com.chuan.shirodemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.chuan.shirodemo.dao")
public class ShirodemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShirodemoApplication.class, args);
	}
}
