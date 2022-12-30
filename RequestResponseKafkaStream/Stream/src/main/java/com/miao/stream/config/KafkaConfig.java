package com.miao.stream.config;


import java.util.Properties;
import org.apache.kafka.streams.StreamsConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class KafkaConfig {

	@Value("${kafka.bootstrap-servers}")
	private String bootstrapServers;

	@Value("${kafka.topic.requestreply-topic}")
	private String requestReplyTopic;

	@Bean
	public Properties streamProperties() {
		final Properties props = new Properties();
		// list of host:port pairs used for establishing the initial connections to the Kakfa cluster
		props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG,
				bootstrapServers);
		props.put(StreamsConfig.APPLICATION_ID_CONFIG, "ConsumerTest1");
		props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		return props;
	}
}

