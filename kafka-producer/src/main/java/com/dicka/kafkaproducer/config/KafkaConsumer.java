package com.dicka.kafkaproducer.config;

import com.dicka.kafkaproducer.model.Category;
import com.dicka.kafkaproducer.model.CategoryList;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class KafkaConsumer  {

    private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);
    private static final String TOPIC = "consume-category";

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(String message){
        log.info(String.format("PRODUCING MESSAGE -> %s", message));
        this.kafkaTemplate.send(TOPIC, message);
    }


    @KafkaListener(topics = "category", groupId = "group_id")
    public void consume(String message) throws IOException {
        log.info(String.format("CONSUMING CATEGORY MESSAGE -> %s", message));
        getCategorys();
    }

    private List<Category> getCategorys(){
        Category category1 = new Category(1l, "celana", "c001");
        Category category2 = new Category(2l, "baju", "c002");
        Category category3 = new Category(3l, "topi", "c003");
        List<Category> categories = new ArrayList<>();
        categories.add(category1);
        categories.add(category2);
        categories.add(category3);
        CategoryList categoryList = new CategoryList();
        categoryList.setCategoryList(categories);
        Gson gson = new Gson();
        sendMessage(gson.toJson(categoryList).toString());
        return categories;
    }
}
