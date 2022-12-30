package com.miao.consumer.stream;

import java.util.Properties;

import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class StreamKafkaConsumer {
//	  @Value("${kafka.topic.request-topic}")
//	  private String requestTopic;
//	  
//	  @Value("${kafka.topic.requestreply-topic}")
//	  private String requestReplyTopic;
	  
	  // Ref: https://www.youtube.com/watch?v=y9a3fldlvnI
	  public void stream() throws InterruptedException {
	       Properties props = new Properties();
	       props.put(StreamsConfig.APPLICATION_ID_CONFIG, "ConsumerTest1");
	       props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//	       props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
//	       props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
	       StreamsBuilder builder = new StreamsBuilder();
	       builder.stream("request-topic").to("requestreply-topic");
	       KafkaStreams streams = new KafkaStreams(builder.build(), props);
	       streams.start();
	  }
}
