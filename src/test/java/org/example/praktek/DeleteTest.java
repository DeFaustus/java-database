package org.example.praktek;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.praktek.repository.MahasiswaRepository;
import org.praktek.repository.MahasiswaRepositoryImpl;

public class DeleteTest {
    private MahasiswaRepository mahasiswaRepository;

    @BeforeEach
    void setUp() {
        mahasiswaRepository = new MahasiswaRepositoryImpl();
    }

    @Test
    void deleteTest() {
        int id = 2;
        mahasiswaRepository.delete(id);
    }
}
