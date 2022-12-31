package com.miao.common.model;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

public class ModelSerdes {
	
	public static Serde<Model> modelGenerate() {
		JsonSerializer<Model> serializer = new JsonSerializer<>();
		JsonDeserializer<Model> deserializer = new JsonDeserializer<>(Model.class);
		return Serdes.serdeFrom(serializer, deserializer);
	}

}
