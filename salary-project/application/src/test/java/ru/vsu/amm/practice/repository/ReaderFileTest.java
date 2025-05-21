package ru.vsu.amm.practice.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import ru.vsu.amm.practice.DepartmentEmployees;

@ExtendWith(MockitoExtension.class)
class ReaderFileTest {

    @Test
    void testReadFile_Success() throws IOException {
        // given
        String testData = "1;Иванов Иван;50000\n2;Петров Петр;60000\n1;Сидоров Сидор;55000";
        InputStream inputStream = new ByteArrayInputStream(testData.getBytes(StandardCharsets.UTF_8));

        // when
        Map<Integer, DepartmentEmployees> result = ReaderFile.readFile(inputStream);

        // then
        assertNotNull(result);
        assertEquals(2, result.size());
        
        DepartmentEmployees dep1 = result.get(1);
        assertNotNull(dep1);
        assertEquals(2, dep1.getEmployeesCount());
        
        DepartmentEmployees dep2 = result.get(2);
        assertNotNull(dep2);
        assertEquals(1, dep2.getEmployeesCount());
    }

        @Test
    void testReadFile_EmptyFile() throws IOException {
        // given
        String testData = "";
        InputStream inputStream = new ByteArrayInputStream(testData.getBytes(StandardCharsets.UTF_8));

        // when
        Map<Integer, DepartmentEmployees> result = ReaderFile.readFile(inputStream);

        // then
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }
   
}
