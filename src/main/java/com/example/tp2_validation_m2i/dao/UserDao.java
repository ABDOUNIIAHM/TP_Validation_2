package com.example.tp2_validation_m2i.dao;

import com.example.tp2_validation_m2i.entities.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDao implements IntUserDao{
    Connection conn = ConnectionManager.getInstance();
    // use try with ressources for statement/preparedstatement

    private User mapToUser(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("id");
        String email = resultSet.getString("email");
        String password = resultSet.getString("password");
        return null;
    }

    @Override
    public User create(User entity) {



        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(Integer integer) {
        return null;
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(User entity) {

    }
}
