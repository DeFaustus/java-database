package org.praktek.repository;

import org.praktek.PraktekConnectionUtil;
import org.praktek.entity.Mahasiswa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MahasiswaRepositoryImpl implements MahasiswaRepository {
    @Override
    public List<Mahasiswa> findAll() {
        List<Mahasiswa> mahasiswas = new ArrayList<>();
        try {
            String sql = """
                    SELECT *FROM mahasiswa
                    """;
            Connection connection = PraktekConnectionUtil.connection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                mahasiswas.add(new Mahasiswa(resultSet.getInt("id"), resultSet.getInt("nim"), resultSet.getString("nama"), resultSet.getString("alamat")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mahasiswas;
    }

    @Override
    public List<Mahasiswa> findByName(String name) {
        List<Mahasiswa> mahasiswas = new ArrayList<>();
        try {
            String sql = "SELECT *FROM mahasiswa WHERE nama LIKE ?";
            Connection connection = PraktekConnectionUtil.connection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                mahasiswas.add(new Mahasiswa(resultSet.getInt("id"), resultSet.getInt("nim"), resultSet.getString("nama"), resultSet.getString("alamat")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mahasiswas;
    }

    @Override
    public void insert(Mahasiswa mahasiswa) {
        String sql = """
                INSERT INTO mahasiswa (nim,nama,alamat) VALUES (?,?,?)
                """;
        try {
            Connection connection = PraktekConnectionUtil.connection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, mahasiswa.getNim());
            preparedStatement.setString(2, mahasiswa.getNama());
            preparedStatement.setString(3, mahasiswa.getAlamat());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {
        try {
            Connection connection = PraktekConnectionUtil.connection();
            String sql = """
                    DELETE FROM mahasiswa WHERE id = ? 
                    """;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int status = preparedStatement.executeUpdate();
            if (status > 0) {
                System.out.println("sukses");
            } else {
                System.out.println("gagal");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, int nim, String nama, String alamat) {
        try {
            Connection connection = PraktekConnectionUtil.connection();
            String sql = """
                    UPDATE mahasiswa SET nim = ? ,nama = ?, alamat = ? WHERE id = ?
                    """;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, nim);
            preparedStatement.setString(2, nama);
            preparedStatement.setString(3, alamat);
            preparedStatement.setInt(4, id);
            int status = preparedStatement.executeUpdate();
            if (status > 0) {
                System.out.println("Sukses");
            } else {
                System.out.println("gagal");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
