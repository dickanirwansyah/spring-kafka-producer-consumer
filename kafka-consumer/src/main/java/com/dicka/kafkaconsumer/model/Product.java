package com.dicka.kafkaconsumer.model;

import java.io.Serializable;


public class Product implements Serializable {

    private Long id;
    private String name;
    private String codeCategory;

    public Product(){}

    public Product(Long id, String name, String codeCategory) {
        this.id = id;
        this.name = name;
        this.codeCategory = codeCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCodeCategory() {
        return codeCategory;
    }

    public void setCodeCategory(String codeCategory) {
        this.codeCategory = codeCategory;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", codeCategory='" + codeCategory + '\'' +
                '}';
    }
}
