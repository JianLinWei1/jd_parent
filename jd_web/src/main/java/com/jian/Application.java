package com.jian;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.jian.util.FaceUtil;

@SpringBootApplication(scanBasePackages = {"com.jian"} )
@MapperScan("com.jian.dao")
@EnableScheduling
public class Application {
	public static void main(String[] args) {
		FaceUtil.createHandle();
		SpringApplication.run(Application.class);
	}
}
