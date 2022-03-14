package org.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class CpTest {
    @Test
    void testHikariCp() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/java");
        config.setUsername("root");
        config.setPassword("");

        //konfogurasi pool
        config.setMaximumPoolSize(10);
        config.setMaximumPoolSize(5);
        config.setIdleTimeout(60_000);
        config.setMaxLifetime(10 * 60_000);

        HikariDataSource dataSource = new HikariDataSource(config);
        try {
            Connection connection = dataSource.getConnection();
            connection.close();
            dataSource.close();
        } catch (SQLException e) {
            Assertions.fail(e);
        }
    }

    @Test
    void testUtilConnection() throws SQLException {
        Connection connection = ConnectioddnUtil.getDataSource().getConnection();
    }
}

