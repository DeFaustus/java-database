package org.example;


import org.example.Entity.Siswa;
import org.example.repository.SiswaRepository;
import org.example.repository.SiswaRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RepositoryTest {
    private SiswaRepository siswaRepository;

    @BeforeEach
    void setUp() {
        siswaRepository = new SiswaRepositoryImpl();
    }

    @Test
    void testInsert() {
        Siswa siswa = new Siswa(23423, "sugih", "kaliputih");
        siswaRepository.insert(siswa);
    }
}
