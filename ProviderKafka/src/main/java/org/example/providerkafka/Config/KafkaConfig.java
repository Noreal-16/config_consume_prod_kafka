package org.example.providerkafka.Config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {
    @Bean
    public NewTopic generateTopic() {

        Map<String, String> configurations = new HashMap<>();
        configurations.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE); // delete (Borra el mensaje) compact (Manteiene el mensaje mas actual)
        configurations.put(TopicConfig.RETENTION_MS_CONFIG, "86400000"); //tiempo de retencion de un mensaje - defecto -1
        configurations.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824"); // Tamaño maximo del segmento - defecto 1G
        configurations.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "1000012"); // Tamaño maximo del mensaje - defecto 1MB

        return TopicBuilder.name("def_kafka_topic_generate")
                .partitions(2)
                .replicas(2)
                .configs(configurations)
                .build();
    }
}
