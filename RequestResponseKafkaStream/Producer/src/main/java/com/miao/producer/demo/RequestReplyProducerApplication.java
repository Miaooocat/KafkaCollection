package com.miao.producer.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {
        "com.miao.producer.config",
        "com.miao.producer.controller",
        "com.miao.producer.demo",
        "com.miao.producer.model"
    })
@SpringBootApplication
public class RequestReplyProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RequestReplyProducerApplication.class, args);
	}
}
