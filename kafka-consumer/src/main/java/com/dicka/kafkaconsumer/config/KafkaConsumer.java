package com.dicka.kafkaconsumer.config;

import com.dicka.kafkaconsumer.model.Category;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class KafkaConsumer {

    private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);
    private static final String CONSUME_TOPIC = "consume-category";
    private List<Category> categoryList = new ArrayList<>();

    @KafkaListener(topics = CONSUME_TOPIC, groupId = "group_id")
    public void consume(String message) throws IOException {
        log.info(String.format("CONSUMING MESSAGE -> %s", message));
        //consume category list
        parsingCategorys(message);
    }

    private List<Category> parsingCategorys(String json){
        try{
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("categoryList");
            int countData = jsonArray.length();
            for (int i=0; i < countData; i++){
                JSONObject jsonObjectCategory = jsonArray.getJSONObject(i);
                Category category = new Category();
                category.setId(jsonObjectCategory.getLong("id"));
                category.setCode(jsonObjectCategory.getString("code"));
                category.setNama(jsonObjectCategory.getString("nama"));
                categoryList.add(category);
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
        return categoryList;
    }

    public List<Category> getCategoryList(){
        return categoryList;
    }
}
