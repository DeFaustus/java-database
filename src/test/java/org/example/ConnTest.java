package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnTest {
    @BeforeAll
    static void beforeAll() {
        try {
            Driver myslDriver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(myslDriver);
        } catch (SQLException e) {
            Assertions.fail(e);
        }
    }

    @Test
    void testConnectionDatabase() {
        String JDBCURL = "jdbc:mysql://localhost:3306/java";
        String USERNAME = "root";
        String PASSWORD = "";
        try {
            Connection connection = DriverManager.getConnection(JDBCURL, USERNAME, PASSWORD);
            System.out.println("suksess");
            
        } catch (SQLException e) {
            Assertions.fail(e);
        }
    }
}
