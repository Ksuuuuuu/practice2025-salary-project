package ru.vsu.amm.practice.repository;

import ru.vsu.amm.practice.DepartmentEmployees;
import ru.vsu.amm.practice.Employee;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class ReaderFile {

    private static String[] splitLine(String line) {
        return line.split(";");
    }

    public static Map<Integer, DepartmentEmployees> readFile(InputStream inputStream) throws IOException {
        Map<Integer, DepartmentEmployees> departments = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {

            String line = reader.readLine();
            while (line != null) {
                String[] lineParts = splitLine(line);
                int numberDep = Integer.parseInt(lineParts[0]);

                Employee e = new Employee(lineParts[1], Integer.parseInt(lineParts[2]));
                if (departments.containsKey(numberDep)) {
                    departments.get(numberDep).addEmployee(e);
                } else {
                    DepartmentEmployees depEmp = new DepartmentEmployees();
                    depEmp.addEmployee(e);
                    departments.put(numberDep, depEmp);
                }

                line = reader.readLine();

            }
        } 

        return departments;

    }

}
