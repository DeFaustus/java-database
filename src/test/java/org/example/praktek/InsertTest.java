package org.example.praktek;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.praktek.entity.Mahasiswa;
import org.praktek.repository.MahasiswaRepository;
import org.praktek.repository.MahasiswaRepositoryImpl;

public class InsertTest {
    private MahasiswaRepository mahasiswaRepository;

    @BeforeEach
    void setUp() {
        mahasiswaRepository = new MahasiswaRepositoryImpl();
    }

    @Test
    void insertTest() {
        Mahasiswa mahasiswa = new Mahasiswa(50, "sugeng", "sempu");
        mahasiswaRepository.insert(mahasiswa);
    }
}
