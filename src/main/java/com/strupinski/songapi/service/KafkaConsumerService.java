package com.strupinski.songapi.service;

import org.springframework.kafka.annotation.KafkaListener;

public interface KafkaConsumerService {

    @KafkaListener(id = "song-api-group", topics = "song-api-topic")
    void listenFromReceivingTopic(String message);
}
