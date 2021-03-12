package com.dicka.kafkaconsumer.service;

import com.dicka.kafkaconsumer.config.KafkaConsumer;
import com.dicka.kafkaconsumer.config.KafkaProducer;
import com.dicka.kafkaconsumer.model.Category;
import com.dicka.kafkaconsumer.model.Product;
import com.dicka.kafkaconsumer.model.ProductDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private KafkaConsumer kafkaConsumer;

    @Autowired
    private KafkaProducer kafkaProducer;

    @PostConstruct
    public void getCategory(){
        kafkaProducer.sendMessage("get-service-category");
    }

    public List<ProductDetail> listProducts(){
        List<ProductDetail> productDetails = new ArrayList<>();
        Product product1 = new Product(1l, "celana dalem", "c001");
        Product product2 = new Product(2l, "celana cingkrang", "c001");
        Product product3 = new Product(3l, "baju dalem", "c002");
        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        List<Category> categories = kafkaConsumer.getCategoryList();


        for (int i=0; i < categories.size(); i++){
            for (int ii=0; ii < products.size(); ii++){
                if (products.get(ii).getCodeCategory().equals(categories.get(i).getCode())){
                    ProductDetail productDetail = new ProductDetail();
                    Product product = new Product();
                    product.setName(products.get(ii).getName());
                    product.setId(products.get(ii).getId());
                    product.setCodeCategory(products.get(ii).getCodeCategory());
                    productDetail.setProduct(product);
                    productDetail.setCategoryName(categories.get(i).getNama());
                    productDetails.add(productDetail);
                }
            }
        }
        return productDetails;
    }
}
