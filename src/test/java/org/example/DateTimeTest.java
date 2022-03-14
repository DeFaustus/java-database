package org.example;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class DateTimeTest {
    @Test
    void testDateTimeQuery() throws SQLException {
        Connection connection = ConnectioddnUtil.getDataSource().getConnection();
        String sql = """
                INSERT INTO sample_time(date,time,timestamp) VALUES (?,?,?)
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setDate(1, new Date(System.currentTimeMillis()));
        preparedStatement.setTime(2, new Time(System.currentTimeMillis()));
        preparedStatement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }
}
