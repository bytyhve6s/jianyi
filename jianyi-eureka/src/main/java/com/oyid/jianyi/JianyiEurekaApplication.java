package com.oyid.jianyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class JianyiEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JianyiEurekaApplication.class, args);
	}
}
