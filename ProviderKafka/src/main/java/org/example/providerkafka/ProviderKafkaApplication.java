package org.example.providerkafka;

import org.apache.kafka.clients.KafkaClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class ProviderKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderKafkaApplication.class, args);
    }

    // Metodo para enviar mensajes cuando se levanta la APP
    @Bean
    CommandLineRunner init(KafkaTemplate<String, String> kafkaTemplate) {
        return args -> {
            kafkaTemplate.send("def_kafka_topic_generate", "Hello World v1 ");
        };
    }

}
