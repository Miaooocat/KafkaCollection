# Request Response StreamAPI Implementation

> [!METADATA]-
> Created:: 2022-12-30
> ID:: 20221230161404
> Type:: #How-to   
> Category: #ComputerScience

This project demonstrates a sample implementation of Request-Reply Semantics with Stream API. The project idea is borrowed from [1] and [2] with modifications in consumer code. While the original code uses Kafka Consumer API, this project proves the feasibility of using Kafka Stream API in the context of request-reply semantics.
![Request Response StreamAPI Implementation Flow.png]()
![alt text](Request Response StreamAPI Implementation Flow.png)

The setting in the Producer side could refer to [2]. The following section will highlight the difference between the implementation of Kafka Consumer API and the implementation of Stream API.

### Step 1. Upgrade Spring Boot Version
Update the spring boot version to 2.3.12.RELEASE. This replaces the boilerplate code by simple annotations such as @@EnableKafka and @EnableKafkaStreams.

### Step 2. Add Customized Serdes Class
Customized Serdes Class is to specify the serialization and deserialization rule for the passing streaming data. It should be noted that the transfer object in both producer and stream consumer should share with same package and class name.

```java
public static Serde<Model> modelGenerate() {
	JsonSerializer<Model> serializer = new JsonSerializer<>();
	JsonDeserializer<Model> deserializer = new JsonDeserializer<>(Model.class);
	return Serdes._serdeFrom_(serializer, deserializer);
}
```

### Step 3.  Add Stream 

With new annotation enabled, the application can connect to the Kafka with streamBuilder.stream() function. Here, we need to pass the customized Serdes class for object mapping.
```java
KStream<String, Model> messageStream = streamsBuilder
						.stream(requestTopic, Consumed.with(STRING_SERDE, 
						ModelSerdes.modelGenerate()));
```

We can then use apply() method to modify the value in the stream.
```java
messageStream.foreach(new ForeachAction<String, Model>() {
				public void apply(String key, Model value) {
value.setAdditionalProperty("sum",value.getFirstNumber()+value.getSecondNumber());
}

```

Finally, we can specify the destination for our stream. This will send the response back to the producer.

```java
messageStream.to("requestreply-topic");
```


## Reference
[1]  https://dzone.com/articles/synchronous-kafka-using-spring-request-reply-1
[2] https://github.com/x14gauravg/RequestReplyKafka