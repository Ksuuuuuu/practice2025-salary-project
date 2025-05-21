package ru.vsu.amm.practice.UI;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.vsu.amm.practice.DepartmentHandler;
import ru.vsu.amm.practice.repository.ReaderInteger;

import java.io.IOException;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MenuHandlerTest {

    @Mock
    private DepartmentHandler mockHandler;

    @InjectMocks
    private MenuHandler menuHandler;


    @Test
    void start_shouldPrintStatementWhenOption1Selected() throws IOException {
        try (MockedStatic<ReaderInteger> mockedReader = mockStatic(ReaderInteger.class)) {
            // Arrange
            mockedReader.when(() -> ReaderInteger.nextInt()).thenReturn(1).thenReturn(0);

            // Act
            menuHandler.start();

            // Assert
            verify(mockHandler).getStatement();
        }
    }

    @Test
    void start_shouldPrintDepartmentsWithHighAvgWhenOption2Selected() throws IOException {
        try (MockedStatic<ReaderInteger> mockedReader = mockStatic(ReaderInteger.class)) {
            // Arrange
            mockedReader.when(() -> ReaderInteger.nextInt()).thenReturn(2).thenReturn(0);

            // Act
            menuHandler.start();

            // Assert
            verify(mockHandler).getDepartmentsWithHighAvg();
        }
    }

    @Test
    void start_shouldPrintDepartmentsWithHighSumWhenOption3Selected() throws IOException {
        try (MockedStatic<ReaderInteger> mockedReader = mockStatic(ReaderInteger.class)) {
            // Arrange
            mockedReader.when(() -> ReaderInteger.nextInt()).thenReturn(3).thenReturn(0);

            // Act
            menuHandler.start();

            // Assert
            verify(mockHandler).getDepartmentsWithHighSum();
        }
    }

    @Test
    void start_shouldPrintPercentEmployeesWhenOption4Selected() throws IOException {
        // Arrange
        try (MockedStatic<ReaderInteger> mockedReader = mockStatic(ReaderInteger.class)) {
            mockedReader.when(() -> ReaderInteger.nextInt()).thenReturn(4).thenReturn(0);

            // Act
            menuHandler.start();

            // Assert
            verify(mockHandler).getPercentCountEmployeesByDepartents();
        }
    }

    @Test
    void start_shouldExitWhenOption0Selected() throws IOException {
        // Arrange
        try (MockedStatic<ReaderInteger> mockedReader = mockStatic(ReaderInteger.class)) {
            mockedReader.when(() -> ReaderInteger.nextInt()).thenReturn(0);

            // Act
            menuHandler.start();

            // Assert
            verify(mockHandler, never()).getStatement();
        }
    }

    @Test
    void start_shouldHandleInvalidInput() throws IOException {
        // Arrange
       try (MockedStatic<ReaderInteger> mockedReader = mockStatic(ReaderInteger.class)) {
            mockedReader.when(() -> ReaderInteger.nextInt()).thenReturn(5).thenReturn(0);

            // Act
            menuHandler.start();

            // Assert
            verify(mockHandler, never()).getStatement();
       }
    }

}

