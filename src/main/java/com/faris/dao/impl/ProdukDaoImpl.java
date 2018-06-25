package com.faris.dao.impl;

import com.faris.DbConnection;
import com.faris.dao.ProdukDao;
import com.faris.entity.Produk;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Produk> find() {

        List<Produk> produks = new ArrayList<>();
        String sql = "SELECT * FROM tbl_produk";

        try {
            PreparedStatement preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                Produk produk = new Produk();

                produk.setId_produk(resultSet.getInt("id_produk"));
                produk.setNama_produk(resultSet.getString("nama_produk"));
                produk.setPath_produk(resultSet.getString("path_produk"));
                produks.add(produk);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return produks;
    }

    @Override
    public String delete(int id_produk) {

        String sql = "DELETE FROM tbl_distributor WHERE id_produk=?";
        String message;

        try {
            PreparedStatement preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id_produk);

            int status = preparedStatement.executeUpdate();
            if(status == 0){
                message = "record terhapus";

            }else {
                message = "recor hapus";
            }
        }catch (SQLException e){
            e.printStackTrace();
            message = "delete gagal";
        }

        return message;
    }


}
