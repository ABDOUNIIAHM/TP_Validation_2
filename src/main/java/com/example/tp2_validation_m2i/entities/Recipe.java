package com.example.tp2_validation_m2i.entities;

import java.time.LocalDateTime;
import java.util.List;

public class Recipe {
    private int id;
    private String title;
    private int rating;
    private String imgUrl;
    private String ingredients;
    private LocalDateTime createdAt;
    private String description;

    public Recipe() {
    }

    public Recipe(int id, String title, int rating, String imgUrl, String ingredients, LocalDateTime createdAt,String description) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.imgUrl = imgUrl;
        this.ingredients = ingredients;
        this.createdAt = createdAt;
        this.description=description;
    }

    public Recipe(String title, int rating, String imgUrl, String ingredients, LocalDateTime createdAt,String description) {
        this.title = title;
        this.rating = rating;
        this.imgUrl = imgUrl;
        this.ingredients = ingredients;
        this.createdAt = createdAt;
        this.description=description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
