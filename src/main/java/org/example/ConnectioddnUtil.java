package org.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectioddnUtil {
    private static HikariDataSource dataSource;

    static {
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
        dataSource = new HikariDataSource(config);
    }

    public static HikariDataSource getDataSource() {
        return dataSource;
    }

}
