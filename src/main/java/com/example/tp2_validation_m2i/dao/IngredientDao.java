package com.example.tp2_validation_m2i.dao;

import com.example.tp2_validation_m2i.entities.Ingredient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IngredientDao implements IntIngredientDao{

    Connection connection = ConnectionManager.getInstance();
    private Ingredient mapToIngredient(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String detail = resultSet.getString("detail");
        return new Ingredient(id,detail);
    }
    @Override
    public Ingredient create(Ingredient entity) {
        String query = "INSERT INTO ingredients detail VALUES (?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1, entity.getDetail());
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected == 1){
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    entity.setId(generatedKeys.getInt(1));
                    return entity;
                }
            }else{
                throw new RuntimeException("ingredient was not created!");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Ingredient> findAll() {
        List<Ingredient> ingredients = new ArrayList<>();
        String query = "SELECT * FROM ingredients";
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Ingredient ingredient = mapToIngredient(resultSet);
                ingredients.add(ingredient);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return ingredients;
    }

    @Override
    public Ingredient findById(Integer integer) {

        Ingredient ingredient = null;
        String query = "SELECT * FROM ingredients WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1,integer);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()){
                ingredient = mapToIngredient(resultSet);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return ingredient;
    }

    @Override
    public void update(Ingredient entity) {
        String query = "UPDATE ingredients SET detail = ? WHERE id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1, entity.getDetail());
            preparedStatement.setInt(2, entity.getId());
            int row = preparedStatement.executeUpdate();
            if (row == 0){
                throw new RuntimeException("ingredient was not updated !!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Ingredient entity) {
        String query = "DELETE FROM ingredients WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
