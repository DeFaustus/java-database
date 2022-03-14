package org.example;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionTest {
    @Test
    void testTransactions() throws SQLException {
        Connection connection = ConnectioddnUtil.getDataSource().getConnection();
        connection.setAutoCommit(false);
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
        preparedStatement.close();
        connection.commit();
        connection.close();
    }

    @Test
    void testMetadata() throws SQLException {
        Connection connection = ConnectioddnUtil.getDataSource().getConnection();
        DatabaseMetaData databaseMetaData = connection.getMetaData();
        System.out.println(databaseMetaData.getDatabaseProductName());
        System.out.println(databaseMetaData.getDatabaseProductVersion());
    }
}
