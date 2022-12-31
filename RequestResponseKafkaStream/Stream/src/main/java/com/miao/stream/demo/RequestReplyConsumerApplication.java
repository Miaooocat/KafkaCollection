package com.miao.stream.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.miao.stream.sum.SumCalculationStream;

@ComponentScan(basePackages = {
        "com.miao.stream.config",
        "com.miao.stream.demo",
        "com.miao.stream.sum",
        "com.miao.common.model"
    })

@SpringBootApplication
public class RequestReplyConsumerApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(RequestReplyConsumerApplication.class, args);
		//StreamKafkaStream consumer = new StreamKafkaStream();
		//consumer.stream();
	}
}
