package org.example.springkafka.controller;

import lombok.RequiredArgsConstructor;
import org.example.springkafka.kafka.KafkaProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaProducer producer;

    @GetMapping("/api/v1/produce")
    public void produce() {
        producer.produce();
    }
}
