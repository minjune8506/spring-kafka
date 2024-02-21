package org.example.springkafka.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaConsumer implements AcknowledgingMessageListener<String, Object> {


    @Override
    @KafkaListener(
            id = "consumer",
            topics = "test-topic",
            groupId = "test-group"
    )
    public void onMessage(ConsumerRecord<String, Object> data, Acknowledgment acknowledgment) {
        try {
            log.info(data.toString());
            acknowledgment.acknowledge();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
