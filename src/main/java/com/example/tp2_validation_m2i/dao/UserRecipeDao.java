package com.example.tp2_validation_m2i.dao;

import com.example.tp2_validation_m2i.entities.User;
import com.example.tp2_validation_m2i.entities.UserRecipe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserRecipeDao implements IntUserRecipeDao{
    Connection connection = ConnectionManager.getInstance();
    private UserRecipe mapToUserRecipe(ResultSet resultSet) throws SQLException {

        int idUser = resultSet.getInt("idUser");
        int idRecipe = resultSet.getInt("idRecipe");
        UserRecipe userRecipe = new UserRecipe(idUser,idRecipe);
        return userRecipe;
    }
    @Override
    public UserRecipe create(UserRecipe entity) {

        try(PreparedStatement prepareStatement = connection.prepareStatement("INSERT INTO user_recipes (idUser, idRecipe) VALUES(?,?)")){
            prepareStatement.setInt(1, entity.getIdUser());
            prepareStatement.setInt(2, entity.getIdRecipe());
            int rowsAffected = prepareStatement.executeUpdate();
            if(rowsAffected == 0){
                throw new RuntimeException("User-recipe has not been created !");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entity;
    }

    @Override
    public List<UserRecipe> findAll() {
        return null;
    }

    @Override
    public UserRecipe findById(Integer integer) {
        return null;
    }

    @Override
    public void update(UserRecipe entity) {

    }

    @Override
    public void delete(UserRecipe entity) {

    }
}
