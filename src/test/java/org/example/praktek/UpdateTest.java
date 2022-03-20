package org.example.praktek;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.praktek.repository.MahasiswaRepository;
import org.praktek.repository.MahasiswaRepositoryImpl;

public class UpdateTest {
    private MahasiswaRepository mahasiswaRepository;

    @BeforeEach
    void setUp() {
        mahasiswaRepository = new MahasiswaRepositoryImpl();
    }

    @Test
    void updateTest() {
        mahasiswaRepository.update(4, 10, "isma", "banyuwangi");
    }
}
