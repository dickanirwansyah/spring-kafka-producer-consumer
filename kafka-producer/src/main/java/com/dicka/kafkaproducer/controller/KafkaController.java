package com.dicka.kafkaproducer.controller;

import com.dicka.kafkaproducer.config.KafkaConsumer;
import com.dicka.kafkaproducer.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    @Autowired
    private KafkaConsumer kafkaConsumer;

    @GetMapping(value = "/send-message-to-kafka")
    public void sendMessageToKafka(@RequestParam(value = "message")String message){
        kafkaConsumer.sendMessage(message);
    }

    @GetMapping(value = "/list-category")
    public List<Category> listCategory(){
        return null;
    }
}
