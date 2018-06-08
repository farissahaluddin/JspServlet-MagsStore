package com.faris;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    public static DbConnection instance;
    private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/mgs_store";
    private String username = "root";
    private String password = "super";

    private DbConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database Connection success");
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DbConnection getInstance() throws SQLException {
        if (instance == null)
        {
            instance = new DbConnection();
        }
        else if (instance.getConnection().isClosed())
        {
            instance = new DbConnection();
        }

        return instance;
    }
}
