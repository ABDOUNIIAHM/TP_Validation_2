package com.example.tp2_validation_m2i.service;

import com.example.tp2_validation_m2i.dao.ConnectionManager;
import com.example.tp2_validation_m2i.dao.IntRecipeDao;
import com.example.tp2_validation_m2i.dao.RecipeDao;
import com.example.tp2_validation_m2i.entities.Recipe;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RecipeService {
    private IntRecipeDao recipeDao = new RecipeDao();
    Connection connection = ConnectionManager.getInstance();
    private Recipe mapToRecipe(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String title = resultSet.getString("title");
        int rating = resultSet.getInt("rating");
        String imgUrl = resultSet.getString("imgUrl");
        //
        String ingredients = resultSet.getString("ingredients");
        //
        Timestamp createdAtTimestamp = resultSet.getTimestamp("createdAt");
        String description = resultSet.getString("description");
        LocalDateTime createdAt = createdAtTimestamp != null ? createdAtTimestamp.toLocalDateTime() : null;
        Recipe recipe = new Recipe(id,title,rating,imgUrl,ingredients,createdAt,description);
        return recipe;
    }

    public Recipe create(Recipe recipe){
        return recipeDao.create(recipe);
    }
    public List<Recipe> findAllRecipes(){
        return recipeDao.findAll();
    }
    public Recipe findById(Integer id){
        return recipeDao.findById(id);
    }
    public void insertIngredients(int id, String ingredients){
        Recipe recipe = recipeDao.findById(id);
        String query = "INSERT INTO recipe (ingredients) VALUES (?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1,ingredients);
            preparedStatement.executeUpdate();
            System.out.println("ingredients inserted sucees");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Recipe> findByTitle(String title){
        List<Recipe> recipes = new ArrayList<>();
        String query = "SELECT * FROM recipe WHERE title LIKE ?";

        try (PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1,"%"+title+"%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Recipe recipe = mapToRecipe(rs);
                recipes.add(recipe);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return recipes;
    }
    public List<Recipe> findByIngredients(String ingredients){
        List<Recipe> recipes = new ArrayList<>();
        String query = "SELECT * FROM recipe WHERE ingredients LIKE ?";
        try (PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1,"%"+ingredients+"%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Recipe recipe = mapToRecipe(rs);
                recipes.add(recipe);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return recipes;
    }

}
