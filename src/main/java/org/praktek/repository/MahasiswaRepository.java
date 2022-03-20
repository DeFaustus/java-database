package org.praktek.repository;

import org.praktek.entity.Mahasiswa;

import java.util.List;

public interface MahasiswaRepository {
    List<Mahasiswa> findAll();

    List<Mahasiswa> findByName(String nama);

    void insert(Mahasiswa mahasiswa);

    void delete(int id);

    void update(int id, int nim, String nama, String alamat);
}
