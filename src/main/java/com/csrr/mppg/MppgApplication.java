package com.csrr.mppg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = {"com.csrr.mppg"})
@MapperScan(basePackages = "com.csrr.mppg.repository.mapper")
@EnableDiscoveryClient
public class MppgApplication {

	public static void main(String[] args) {
		SpringApplication.run(MppgApplication.class, args);
	}

}
