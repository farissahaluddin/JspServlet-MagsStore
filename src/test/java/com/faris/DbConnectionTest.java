package com.faris;

import org.junit.Test;


public class DbConnectionTest {
    @Test
    public void getConnection() throws Exception {
        System.out.println(DbConnection.getInstance().getConnection());
    }
}