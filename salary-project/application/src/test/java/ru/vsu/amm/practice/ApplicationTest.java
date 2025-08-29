package ru.vsu.amm.practice;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.vsu.amm.practice.repository.ReaderFile;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.io.InputStream;


@ExtendWith(MockitoExtension.class)
class ApplicationTest {

    @Test
    void loadStreamFromResources_shouldReturnStream() {
        // given
        String testFileName = "info.txt";
        
        // when
        InputStream result = Application.loadStreamFromResources(ReaderFile.class, testFileName);
        
        // then
        assertNotNull(result);
    }

        @Test
    void loadStreamFromResources_shouldReturnNull() {
        // given
        String testFileName = "test.txt";
        
        // when
        InputStream result = Application.loadStreamFromResources(ReaderFile.class, testFileName);
        
        // then
        assertNull(result);
    }
}
