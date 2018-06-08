package com.faris.dao.impl;

import com.faris.DbConnection;
import com.faris.dao.UserDao;
import com.faris.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDaoImpl implements UserDao {

    @Override
    public User Save(User entity) {

        String sql = "INSERT INTO tbl_user VALUES(?, ?, ?)";

        try{
            PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, entity.getId_user());
            statement.setString(2, entity.getUsername());
            statement.setString(3, entity.getPassword());
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                entity.setId_user(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entity;
    }
}
