package com.example.tp2_validation_m2i.dao;

import com.example.tp2_validation_m2i.entities.Recipe;
import com.example.tp2_validation_m2i.entities.User;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecipeDao implements IntRecipeDao{
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
    @Override
    public Recipe create(Recipe entity) {
        String query = "INSERT INTO recipe(title,rating,imgUrl,ingredients,createdAt,description) VALUES (?,?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS)){

            preparedStatement.setString(1, entity.getTitle());
            preparedStatement.setInt(2, entity.getRating());
            preparedStatement.setString(3, entity.getImgUrl());
            preparedStatement.setString(4, entity.getIngredients());

            preparedStatement.setDate(5, new java.sql.Date(System.currentTimeMillis()));
            preparedStatement.setString(6, entity.getDescription());
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected == 1){
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    entity.setId(generatedKeys.getInt(1));
                    return entity;
                }
            }else{
                System.out.println("recip not created");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Recipe> findAll() {
        List<Recipe> recipes = new ArrayList<>();
        String query ="SELECT * FROM recipe";
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Recipe recipe = mapToRecipe(resultSet);
                recipes.add(recipe);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return recipes;
    }

    @Override
    public Recipe findById(Integer integer) {
        Recipe recipe = null;
        String query ="SELECT * FROM recipe WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1,integer);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()){
               recipe= mapToRecipe(resultSet);
            }else{
                throw new RuntimeException("recipe with id: "+integer+" was not found !");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return recipe;
    }

    @Override
    public void update(Recipe entity) {
        String query = "UPDATE recipe SET title=?,rating=?,imgUrl=?,ingredients=?,createdAt=?,description=?) WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1, entity.getTitle());
            preparedStatement.setInt(2, entity.getRating());
            preparedStatement.setString(3, entity.getImgUrl());
            preparedStatement.setString(4, entity.getIngredients());
            preparedStatement.setDate(5, new java.sql.Date(System.currentTimeMillis()));
            preparedStatement.setString(6, entity.getDescription());
            preparedStatement.setInt(7, entity.getId());
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected == 0){
                throw new RuntimeException("recipe has not been updated !");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    @Override
    public void delete(Recipe entity) {
        String query = "DELETE FROM recipe WHERE id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, entity.getId());
            int row = preparedStatement.executeUpdate();
            if(row == 0){
                throw new RuntimeException("Post was not deleted");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
