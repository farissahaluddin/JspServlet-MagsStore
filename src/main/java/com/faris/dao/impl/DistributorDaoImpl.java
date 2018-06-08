package com.faris.dao.impl;

import com.faris.DbConnection;
import com.faris.dao.DistributorDao;
import com.faris.entity.Distributor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DistributorDaoImpl implements DistributorDao {
    @Override
    public Distributor Save(Distributor entity) {
        String sql = "INSERT INTO tbl_distributor VALUES(?, ?, ?, ?, ?)";

        try{
            PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, entity.getId_distributor());
            statement.setString(2, entity.getNama_distributor());
            statement.setString(3, entity.getAlamat_distributor());
            statement.setString(4, entity.getEmail());
            statement.setString(5, entity.getTelepon());

            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                entity.setId_distributor(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entity;
    }

    @Override
    public Distributor update(Distributor entity) {
        String sql = "UPDATE tbl_distributor SET" +
                    "nama_distributor = ?" +
                    "alamat_distributor = ?" +
                    "email = ?" +
                    "telepon = ?" +
                    "WHERE id_distributor = ?";
                ;

        try{
            PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, entity.getNama_distributor());
            statement.setString(2, entity.getAlamat_distributor());
            statement.setString(3, entity.getEmail());
            statement.setString(4, entity.getTelepon());
            statement.setInt(5, entity.getId_distributor());

            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                entity.setId_distributor(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entity;
    }

    @Override
    public List<Distributor> find() {

        List<Distributor> distributors = new ArrayList<>();
        String sql = "SELECT * FROM tbl_distributor";

        try{
            PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Distributor distributor = new Distributor();

                distributor.setId_distributor(rs.getInt("id_distributor"));
                distributor.setNama_distributor(rs.getString("nama_distributor"));
                distributor.setAlamat_distributor(rs.getString("alamat_distributor"));
                distributor.setEmail(rs.getString("email"));
                distributor.setTelepon(rs.getString("telepon"));
                distributors.add(distributor);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return distributors;
    }

    @Override
    public Distributor findByName(String nama_distributor) {

        Distributor distributor = new Distributor();

        String sql = "SELECT * FROM tbl_distributor WHERE nama_distributor=?";

        try{
            PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql);
            statement.setString(1, nama_distributor);
            statement.executeQuery();

            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                distributor.setId_distributor(rs.getInt("id_distributor"));
                distributor.setNama_distributor(rs.getString("nama_distributor"));
                distributor.setAlamat_distributor(rs.getString("alamat_distributor"));
                distributor.setEmail(rs.getString("email"));
                distributor.setTelepon(rs.getString("telepon"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return distributor;
    }

    @Override
    public String delete(int id_distributor) {
        String sql = "DELETE FROM tbl_distributor WHERE id_distributor=?";
        String message;
        try {
            PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement(sql);
            statement.setInt(1, id_distributor);

            int status = statement.executeUpdate();
            if(status == 0){
                message = "Record Terhapus!";
            }else
                message = "record terhapus";
        } catch (SQLException e) {
            e.printStackTrace();
            message = "Delete Gagal!";
        }

        return message;
    }
}
