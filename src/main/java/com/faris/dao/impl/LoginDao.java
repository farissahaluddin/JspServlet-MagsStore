package com.faris.dao.impl;

import java.sql.*;

public class LoginDao {
    String sql = "SELECT * FROM tbl_user WHERE username=? AND password=?";

    private String url = "jdbc:mysql://localhost:3306/mgs_store";
    private String user = "root";
    private String pass = "super";

    public boolean check(String username, String password){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
