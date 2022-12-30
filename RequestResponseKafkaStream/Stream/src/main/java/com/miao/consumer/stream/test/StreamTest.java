package com.miao.consumer.stream.test;

import org.apache.kafka.streams.StreamsBuilder;

public class StreamTest {
	
	public static void main(String args) {
		 StreamsBuilder builder = new StreamsBuilder();
		 builder.stream("request-topic").to("requestreply-topic");
	}
}
