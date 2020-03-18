package com.example.web;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = "com.example")
@MapperScan("com.example.dao")
@Slf4j
@EnableTransactionManagement
public class App {

	public static void main(String[] args) {
		System.setProperty("druid.logType","slf4j");
		SpringApplication.run(App.class, args);
		log.info("============================App启动完成============================");
	}

}
