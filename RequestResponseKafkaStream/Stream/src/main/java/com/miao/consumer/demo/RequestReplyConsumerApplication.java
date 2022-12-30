package com.miao.consumer.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.miao.consumer.stream.StreamKafkaConsumer;

@ComponentScan(basePackages = {
        "com.miao.consumer.demo",
        "com.miao.consumer.stream",
        "com.miao.consumer.model"
    })

@SpringBootApplication
public class RequestReplyConsumerApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(RequestReplyConsumerApplication.class, args);
		StreamKafkaConsumer consumer = new StreamKafkaConsumer();
		consumer.stream();
	}
}
