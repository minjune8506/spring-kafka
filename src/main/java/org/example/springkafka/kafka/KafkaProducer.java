package org.example.springkafka.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void produce() {
        var future = kafkaTemplate.send("test-topic", "hello world!");

        future.whenComplete((result, throwable) -> {
            if (throwable != null) {
                log.error(throwable.getMessage());
                return;
            }

            var producerRecord = result.getProducerRecord();

            log.info("topic: {}", producerRecord.topic());
            log.info("partition: {}", producerRecord.partition());
            log.info("header: {}", producerRecord.headers());
            log.info("key: {}", producerRecord.key());
            log.info("value: {}", producerRecord.value());
        });
    }
}
