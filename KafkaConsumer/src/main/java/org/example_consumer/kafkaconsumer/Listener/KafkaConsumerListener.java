package org.example_consumer.kafkaconsumer.Listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;


@Configuration
public class KafkaConsumerListener {

    private Logger LOGGUER = LoggerFactory.getLogger(KafkaConsumerListener.class);

    @KafkaListener(topics = {"def_kafka_topic_generate"}, groupId = "my-group-id")
    private void listener(String message) {
        LOGGUER.info("Mensaje recibido: el mensaje es {} ", message);
    }
}
