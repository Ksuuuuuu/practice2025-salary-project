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
        // Arrange
        String testFileName = "info.txt";
        
        // Act
        InputStream result = Application.loadStreamFromResources(ReaderFile.class, testFileName);
        
        // Assert
        assertNotNull(result);
    }

        @Test
    void loadStreamFromResources_shouldReturnNull() {
        // Arrange
        String testFileName = "test.txt";
        
        // Act
        InputStream result = Application.loadStreamFromResources(ReaderFile.class, testFileName);
        
        // Assert
        assertNull(result);
    }
}
