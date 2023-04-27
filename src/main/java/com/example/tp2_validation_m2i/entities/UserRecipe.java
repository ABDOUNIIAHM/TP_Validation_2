package com.example.tp2_validation_m2i.entities;

public class UserRecipe {
    private int idUser;
    private int idRecipe;

    public UserRecipe(int idUser, int idRecipe) {
        this.idUser = idUser;
        this.idRecipe = idRecipe;
    }

    public UserRecipe() {
    }

    public UserRecipe(int idRecipe) {
        this.idRecipe = idRecipe;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdRecipe() {
        return idRecipe;
    }

    public void setIdRecipe(int idRecipe) {
        this.idRecipe = idRecipe;
    }
}
