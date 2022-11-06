package dev.hyein.jpamultidatasource.repository.book;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("multi")
@SpringBootTest
class ScienceRepositoryTest {
    @Autowired
    ScienceRepository scienceRepository;

    @Test
    @DisplayName("book db 연동 테스트")
    void count() {
        Assertions.assertNotEquals(0, scienceRepository.count());
    }
}