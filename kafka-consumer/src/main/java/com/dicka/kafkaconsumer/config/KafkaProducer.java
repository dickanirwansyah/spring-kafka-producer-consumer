package com.dicka.kafkaconsumer.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);
    private static final String TOPIC = "category";

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(String message){
        log.info(String.format("PRODUCING CATEGORY MESSAGE -> %s", message));
        this.kafkaTemplate.send(TOPIC, message);
    }
}
