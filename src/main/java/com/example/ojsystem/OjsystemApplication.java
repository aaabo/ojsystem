package com.example.ojsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.ojsystem.dao")
public class OjsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OjsystemApplication.class, args);
	}

}
