package org.example;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementTEst {
    @Test
    void preparedStatementTest() throws SQLException {
        Connection connection = ConnectioddnUtil.getDataSource().getConnection();
        //fungsi prepared statemetn untuk mengatasi sql injection
        String sql = "SELECT *FROM siswa WHERE nama = ? AND alamat=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "bintara");
        preparedStatement.setString(2, "gendoh");
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            while (resultSet.next()) {
                System.out.println(resultSet.getString("nama") + " , " + resultSet.getString("alamat"));
            }
        } else {
            System.out.println("Data Kosong");
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
