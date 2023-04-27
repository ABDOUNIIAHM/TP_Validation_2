package com.example.tp2_validation_m2i.service;

import com.example.tp2_validation_m2i.dao.ConnectionManager;
import com.example.tp2_validation_m2i.dao.IntRecipeDao;
import com.example.tp2_validation_m2i.dao.RecipeDao;
import com.example.tp2_validation_m2i.dao.UserRecipeDao;
import com.example.tp2_validation_m2i.entities.Recipe;
import com.example.tp2_validation_m2i.entities.UserRecipe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRecipeService {
    private static UserRecipeDao userRecipeDao = new UserRecipeDao();
    Connection connection = ConnectionManager.getInstance();
    IntRecipeDao recipeDao = new RecipeDao();

    public List<Recipe> findAllRecipesByUserId(int id){
        List<Recipe> recipes = new ArrayList<>();
        String query = "SELECT idRecipe FROM user_recipes WHERE idUser = ?";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Recipe recipe = recipeDao.findById(rs.getInt("idRecipe"));
                recipes.add(recipe);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return recipes;
    }
    public UserRecipe create(UserRecipe userRecipe){
        return userRecipeDao.create(userRecipe);
    }
}
