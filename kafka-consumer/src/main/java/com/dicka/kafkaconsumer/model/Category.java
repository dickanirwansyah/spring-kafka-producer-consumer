package com.dicka.kafkaconsumer.model;

import java.io.Serializable;

public class Category implements Serializable {

    private Long id;
    private String nama;
    private String code;

    public Category(){}

    public Category(Long id, String nama, String code) {
        this.id = id;
        this.nama = nama;
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", nama='" + nama + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
