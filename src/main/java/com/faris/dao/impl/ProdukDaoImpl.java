package com.faris.dao.impl;

import com.faris.DbConnection;
import com.faris.dao.ProdukDao;
import com.faris.entity.Produk;

import javax.servlet.http.Part;
import java.io.File;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProdukDaoImpl implements ProdukDao {

    @Override
    public Produk Save(Produk entity) {

        String sql = "INSERT INTO tbl_produk VALUES(?, ?, ?)";

        try{
            PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, entity.getId_produk());
            statement.setString(2, entity.getNama_produk());
            statement.setString(3, entity.getPath_produk());
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                entity.setId_produk(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entity;
    }

}
