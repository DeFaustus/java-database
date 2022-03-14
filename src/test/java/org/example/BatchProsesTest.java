package org.example;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchProsesTest {
    @Test
    void testBatch() throws SQLException {
        Connection connection = ConnectioddnUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();
        String sql = "INSERT INTO siswa (nim,nama,alamat) VALUES(4324,'bejo','kkkkkkk')";
        for (int i = 0; i < 1000; i++) {
            statement.addBatch(sql);
        }
        statement.executeBatch();
        statement.close();
        connection.close();
    }

    @Test
    void testBatchPreparedStatement() throws SQLException {
        Connection connection = ConnectioddnUtil.getDataSource().getConnection();
        String sql = "INSERT INTO siswa (nim,nama,alamat) VALUES(?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < 1000; i++) {
            preparedStatement.clearParameters();
            preparedStatement.setInt(1, i);
            preparedStatement.setString(2, "apapun itu");
            preparedStatement.setString(3, "iyo");
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();

        connection.close();
    }
}
