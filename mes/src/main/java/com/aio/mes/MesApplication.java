package com.aio.mes;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.aio.mes.**.mapper")
public class MesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MesApplication.class, args);
		
	
	}

}
