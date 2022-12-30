package com.miao.stream.config;


import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.apache.kafka.streams.StreamsConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
import org.springframework.kafka.config.KafkaStreamsConfiguration;


@Configuration
@EnableKafka
@EnableKafkaStreams
public class KafkaConfig {

	@Value("${kafka.bootstrap-servers}")
	private String bootstrapServers;

	@Value("${kafka.topic.requestreply-topic}")
	private String requestReplyTopic;

	@Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
	public KafkaStreamsConfiguration kStreamsConfig() {
		Map<String,Object> props = new HashMap<>();
		// list of host:port pairs used for establishing the initial connections to the Kakfa cluster
		props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG,
				bootstrapServers);
		props.put(StreamsConfig.APPLICATION_ID_CONFIG, "ConsumerTest1");
		props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		return new KafkaStreamsConfiguration(props);
	}
}

