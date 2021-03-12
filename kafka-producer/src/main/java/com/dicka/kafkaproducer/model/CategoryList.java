package com.dicka.kafkaproducer.model;

import java.util.List;

public class CategoryList {

    private List<Category> categoryList;

    public CategoryList(){}

    public CategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    @Override
    public String toString() {
        return "CategoryList{" +
                "categoryList=" + categoryList +
                '}';
    }
}
