package com.miao.stream.sum;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.ForeachAction;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.miao.common.model.Model;
import com.miao.common.model.ModelSerdes;


@Component
public class SumCalculationStream {


	@Value("${kafka.topic.request-topic}")
	String requestTopic;

	@Value("${kafka.topic.requestreply-topic}")
	String requestReplyTopic;


	private static final Serde<String> STRING_SERDE = Serdes.String();

	@Autowired
	public void stream(StreamsBuilder streamsBuilder) throws InterruptedException {
		KStream<String, Model> messageStream = streamsBuilder
				.stream(requestTopic, Consumed.with(STRING_SERDE, ModelSerdes.modelGenerate()));
		messageStream.foreach(new ForeachAction<String, Model>() {
			public void apply(String key, Model value) {
				value.setAdditionalProperty("sum", value.getFirstNumber()+value.getSecondNumber());
			}
		});

		messageStream.to("requestreply-topic");
	}
}
