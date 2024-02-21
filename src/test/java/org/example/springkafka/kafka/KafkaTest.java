package org.example.springkafka.kafka;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;


@SpringBootTest
@EmbeddedKafka(
        topics = {"test-topic"}
)
class KafkaTest {

    @Autowired
    KafkaProducer producer;

    @Test
    void produce() throws InterruptedException {
        producer.produce();
        Thread.sleep(2000);
    }
}
