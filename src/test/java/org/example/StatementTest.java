package org.example;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementTest {
    @Test
    void testCreateStatement() throws SQLException {
        Connection connection = ConnectioddnUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();
        String sql = """
                INSERT INTO siswa (nim,nama,alamat) VALUES (5344,'bintara','gendoh');
                """;
        statement.executeUpdate(sql);
        statement.close();
        connection.close();
    }

    @Test
    void testExecuteQuery() throws SQLException {
        Connection connection = ConnectioddnUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();
        String sql = """
                SELECT *FROM siswa
                """;
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("id"));
        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}
