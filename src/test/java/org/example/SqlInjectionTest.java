package org.example;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlInjectionTest {
    @Test
    void testSqlInjection() {

    }

    @Test
    @Disabled
    void testInsertData() throws SQLException {
        Connection connection = ConnectioddnUtil.getDataSource().getConnection();
        String sql = "INSERT INTO siswa (nim,nama,alamat) VALUES (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        for (int i = 1; i < 1000000; i++) {
            int a = 34 + i;
            String nama = String.format("danang%d", i);
            String ala = String.format("bwi%d", i);
            statement.setInt(1, i);
            statement.setString(2, nama);
            statement.setString(3, nama);
            statement.executeUpdate();
        }
        statement.close();
        connection.close();

    }

    @Test
    void testShowData() throws SQLException {
        Connection connection = ConnectioddnUtil.getDataSource().getConnection();
        String sql = "SELECT *FROM siswa";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("nama"));
        }
        connection.close();
    }
}
