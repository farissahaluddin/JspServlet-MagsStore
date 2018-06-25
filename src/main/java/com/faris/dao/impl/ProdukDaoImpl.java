package com.faris.dao.impl;

import com.faris.DbConnection;
import com.faris.dao.ProdukDao;
import com.faris.entity.Produk;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProdukDaoImpl implements ProdukDao {

    @Override
    public Produk Save(Produk entity) {

        String sql = "INSERT INTO tbl_produk VALUES (?,?,?)";

        try{
            PreparedStatement preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, entity.getId_produk());
            preparedStatement.setString(2, entity.getNama_produk());
            preparedStatement.setString(3, entity.getPath_produk());

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                entity.setId_produk(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entity;
    }

}
