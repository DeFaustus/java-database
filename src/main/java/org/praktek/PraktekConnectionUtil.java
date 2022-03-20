package org.praktek;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class PraktekConnectionUtil {
    private static HikariDataSource hikariDataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/java");
        config.setMaximumPoolSize(10);
        config.setUsername("root");
        config.setPassword("");
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setMaxLifetime(10 * 60_000);
        config.setIdleTimeout(60_000);
        hikariDataSource = new HikariDataSource(config);
    }

    public static Connection connection() throws SQLException {
        return hikariDataSource.getConnection();
    }
}
