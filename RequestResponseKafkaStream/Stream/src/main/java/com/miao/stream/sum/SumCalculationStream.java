package com.miao.stream.sum;

import java.util.Properties;

import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SumCalculationStream {

	@Autowired
	public void stream(StreamsBuilder streamBuilder) throws InterruptedException {
		streamBuilder.stream("request-topic").to("requestreply-topic");
	}
}
