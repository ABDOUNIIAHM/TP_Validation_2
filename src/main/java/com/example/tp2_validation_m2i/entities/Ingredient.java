package com.example.tp2_validation_m2i.entities;

import java.util.List;

public class Ingredient {
    private int id;
    private String detail;

    public Ingredient() {
    }

    public Ingredient(String detail) {
        this.detail = detail;
    }

    public Ingredient(int id, String detail) {
        this.id = id;
        this.detail = detail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}


