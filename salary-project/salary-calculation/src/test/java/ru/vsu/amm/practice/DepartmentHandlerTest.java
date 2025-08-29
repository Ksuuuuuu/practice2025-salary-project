package ru.vsu.amm.practice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DepartmentHandlerTest {

    @Mock
    private static DepartmentEmployees dept1;

    @Mock
    private static DepartmentEmployees dept2;

    private Map<Integer, DepartmentEmployees> departments;
    private Map<Integer, DepartmentEmployees> emptyDepartments;
    private DepartmentHandler handler;

    @BeforeEach
    void setUp() {
        emptyDepartments = new HashMap<>();
        departments = new HashMap<>();
        departments.put(1, dept1);
        departments.put(2, dept2);
        
        handler = new DepartmentHandler(departments);
    }
        
    
    @Test
    void getStatement_ShouldReturnFormattedString() {
        // given
        when(dept1.getInfo()).thenReturn("Info1");
        when(dept2.getInfo()).thenReturn("Info2");

        // when
        String result = handler.getStatement();

        // then
        assertNotNull(result);
        assertTrue(result.contains("Отдел 1\nInfo1"));
        assertTrue(result.contains("Отдел 2\nInfo2"));
    }

    @Test
    void getDepartmentsWithHighSum_ShouldReturnDepartmentWithHighestSum() {
        // given

        when(dept1.getSumSalary()).thenReturn(1000.0);
        when(dept2.getSumSalary()).thenReturn(2000.0);

        // when
        Set<Integer> result = handler.getDepartmentsWithHighSum();

        // then
        assertEquals(1, result.size());
        assertTrue(result.contains(2));
        assertFalse(result.contains(1));
    }

    @Test
    void getDepartmentsWithHighSum_ShouldReturnEmptyDepartments() {
        // given

        DepartmentHandler handlerForEmptyDepartments = new DepartmentHandler(emptyDepartments);
        // when
        Set<Integer> result = handlerForEmptyDepartments.getDepartmentsWithHighSum();

        // then
        assertTrue(result.isEmpty());
    }

    @Test
    void getDepartmentsWithHighAvg_ShouldReturnDepartmentWithHighestAvg() {
        // given
        when(dept1.getAvgSalary()).thenReturn(500.0);
        when(dept2.getAvgSalary()).thenReturn(750.0);

        // when
        Set<Integer> result = handler.getDepartmentsWithHighAvg();

        // then
        assertEquals(1, result.size());
        assertTrue(result.contains(2));
        assertFalse(result.contains(1));
    }

    @Test
    void getPercentCountEmployeesByDepartents_ShouldReturnCorrectPercentages() {
        // given
        when(dept1.getEmployeesCount()).thenReturn(30);
        when(dept2.getEmployeesCount()).thenReturn(70);

        // when
        Map<Integer, Double> result = handler.getPercentCountEmployeesByDepartents();

        // then
        assertEquals(2, result.size());
        assertEquals(30.0, result.get(1), 0.001);
        assertEquals(70.0, result.get(2), 0.001);
    }

    @Test
    void getPercentCountEmployeesByDepartents_WithZeroTotalEmployees_ShouldReturnEmptyMap() {
        // given
        when(dept1.getEmployeesCount()).thenReturn(0);
        when(dept2.getEmployeesCount()).thenReturn(0);

        // when
        Map<Integer, Double> result = handler.getPercentCountEmployeesByDepartents();

        // then
        assertTrue(result.isEmpty());
    }
}
