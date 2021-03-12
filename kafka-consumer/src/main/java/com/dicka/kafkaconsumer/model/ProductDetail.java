package com.dicka.kafkaconsumer.model;

public class ProductDetail {

    private Product product;
    private String categoryName;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "ProductDetail{" +
                "product=" + product +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
