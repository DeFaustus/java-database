package org.example.repository;

import org.example.ConnectionUtil;
import org.example.Entity.Siswa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SiswaRepositoryImpl implements SiswaRepository {
    @Override
    public void insert(Siswa siswa) {
        try {
            Connection connection = ConnectionUtil.getDataSource().getConnection();
            String sql = """
                    INSERT INTO siswa (nim,nama,alamat) VALUES (?,?,?)
                    """;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, siswa.getNim());
            preparedStatement.setString(2, siswa.getNama());
            preparedStatement.setString(3, siswa.getAlamat());
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public Siswa findById(Integer id) {
        try {
            Connection connection = ConnectionUtil.getDataSource().getConnection();
            String sql = """
                    SELECT *FROM siswa WHERE id=?
                    """;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Siswa(resultSet.getInt("id"),
                        resultSet.getInt("nim"),
                        resultSet.getString("nama"),
                        resultSet.getString("alamat"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Siswa> findAll() {
        try {
            Connection connection = ConnectionUtil.getDataSource().getConnection();
            String sql = """
                    SELECT *FROM siswa
                    """;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            List<Siswa> siswa = new ArrayList<>();
            while (resultSet.next()) {
                siswa.add(new Siswa(
                        resultSet.getInt("id"),
                        resultSet.getInt("nim"),
                        resultSet.getString("nama"),
                        resultSet.getString("alamat")
                ));
            }
            return siswa;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Siswa> findAllBynama(String nama) {
        try {
            Connection connection = ConnectionUtil.getDataSource().getConnection();
            String sql = """
                    SELECT *FROM siswa WHERE nama=?
                    """;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nama);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Siswa> siswa = new ArrayList<>();
            while (resultSet.next()) {
                siswa.add(new Siswa(resultSet.getInt("id"),
                        resultSet.getInt("nim"),
                        resultSet.getString("nama"),
                        resultSet.getString("alamat")));
            }
            return siswa;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
