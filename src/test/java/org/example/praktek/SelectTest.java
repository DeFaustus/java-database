package org.example.praktek;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.praktek.entity.Mahasiswa;
import org.praktek.repository.MahasiswaRepository;
import org.praktek.repository.MahasiswaRepositoryImpl;

import java.util.List;

public class SelectTest {
    private MahasiswaRepository mahasiswaRepository;

    @BeforeEach
    void setUp() {
        mahasiswaRepository = new MahasiswaRepositoryImpl();
    }

    @Test
    void selectAllTest() {
        List<Mahasiswa> mahasiswa = mahasiswaRepository.findAll();
        for (var mhs : mahasiswa) {
            System.out.println(mhs.getId() + " | " + mhs.getNim() + " " + mhs.getNama() + " " + mhs.getAlamat());
        }
    }

    @Test
    void findByNameTest() {
        String nama = "bintara";
        List<Mahasiswa> mahasiswa = mahasiswaRepository.findByName(nama);
        for (var mhs : mahasiswa) {
            System.out.println(mhs.getId() + " | " + mhs.getNim() + " " + mhs.getNama() + " " + mhs.getAlamat());
        }
    }
}
