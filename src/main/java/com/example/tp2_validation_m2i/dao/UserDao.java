package com.example.tp2_validation_m2i.dao;

import com.example.tp2_validation_m2i.entities.Recipe;
import com.example.tp2_validation_m2i.entities.User;
import com.example.tp2_validation_m2i.service.UserRecipeService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements IntUserDao{
    Connection connection = ConnectionManager.getInstance();
    IntRecipeDao recipeDao = new RecipeDao();
    IntUserRecipeDao userRecipeDao = new UserRecipeDao();
    UserRecipeService userRecipeService = new UserRecipeService();
    // use try with ressources for statement/preparedstatement

    private User mapToUser(ResultSet resultSet) throws SQLException {

        int id = resultSet.getInt("id");
        String firstName = resultSet.getString("firstName");
        String lastName = resultSet.getString("lastName");
        String email = resultSet.getString("email");
        String password = resultSet.getString("password");
        String imgUrl = resultSet.getString("imgUrl");
        //retrieve the recipe with findbyid
        List<Recipe> recipes = userRecipeService.findAllRecipesByUserId(id);
        User user = new User(id,firstName,lastName,email,password,imgUrl,recipes);
        return user;
    }

    @Override
    public User create(User entity) {
        String query = "INSERT INTO user(firstName,lastName,email, password, imgUrl) VALUES(?,?,?,?,?)";
        try{
            PreparedStatement prepareStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            prepareStatement.setString(1, entity.getFirstName());
            prepareStatement.setString(2, entity.getLastName());
            prepareStatement.setString(3, entity.getEmail());
            prepareStatement.setString(4, entity.getPassword());
            prepareStatement.setString(5, entity.getImgUrl());

            int rowsAffected = prepareStatement.executeUpdate();
            if(rowsAffected == 1){
                ResultSet generatedKeys = prepareStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    entity.setId(generatedKeys.getInt(1));
                    return entity;
                }else{
                    throw new RuntimeException("User has not been created !");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(Integer integer) {

        User user = null;
        String query ="SELECT * FROM user WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1,integer);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()){
                user= mapToUser(resultSet);
            }else{
                throw new RuntimeException("recipe with id: "+integer+" was not found !");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void update(User entity) {
        String query = "UPDATE user SET firstName=?,lastName=?,email=?, password=?, imgUrl=?) WHERE id=?";
        try(PreparedStatement prepareStatement = connection.prepareStatement(query)){

            prepareStatement.setString(1, entity.getFirstName());
            prepareStatement.setString(2, entity.getLastName());
            prepareStatement.setString(3, entity.getEmail());
            prepareStatement.setString(4, entity.getPassword());
            prepareStatement.setString(5, entity.getImgUrl());
            prepareStatement.setInt(6, entity.getId());

            int rowsAffected = prepareStatement.executeUpdate();
            if(rowsAffected == 0){
                throw new RuntimeException("User has not been created !");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(User entity) {

    }
}
