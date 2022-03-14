package org.example.repository;

import org.example.Entity.Siswa;

import java.util.List;

public interface SiswaRepository {
    void insert(Siswa siswa);

    Siswa findById(Integer id);

    List<Siswa> findAll();

    List<Siswa> findAllBynama(String nama);
}
