package com.bin.shop.manage.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@MapperScan(basePackages="com.bin.shop.manage.service.mapper")
public class ShopManageServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopManageServiceApplication.class, args);
	}

}
