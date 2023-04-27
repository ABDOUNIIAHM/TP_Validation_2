package com.example.tp2_validation_m2i.service;

import com.example.tp2_validation_m2i.dao.ConnectionManager;
import com.example.tp2_validation_m2i.dao.IntUserDao;
import com.example.tp2_validation_m2i.dao.UserDao;
import com.example.tp2_validation_m2i.entities.Recipe;
import com.example.tp2_validation_m2i.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserService {
    private IntUserDao userDao = new UserDao();
    Connection connection = ConnectionManager.getInstance();
    UserRecipeService userRecipeService = new UserRecipeService();
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

    public User create(User user){
        return userDao.create(user);
    }
    public void update(User user){
        userDao.update(user);
    }
    public User validAuthentification(String email, String password){
        User user = null;
        String query ="SELECT * FROM user WHERE email LIKE ? AND password LIKE ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1,email);
            ps.setString(2,password);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()){
                user= mapToUser(resultSet);
                System.out.println(user.getEmail()+"/"+user.getPassword());
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }
    public User findById(int id){
        return userDao.findById(id);
    }
    public User findByEmail(String email){
        User user = null;
        String query ="SELECT * FROM user WHERE email LIKE ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1,email);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()){
                user= mapToUser(resultSet);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }
}
