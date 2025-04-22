package repository;

import models.DepartmentEmployees;
import models.Employee;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ReaderFile {
    private static final String path = "src/main/resources/info.txt";

    private static String[] splitLine(String line) {
        return line.split(";");
    }

    public static Map<Integer, DepartmentEmployees> readFile() {

        Map<Integer, DepartmentEmployees> departments = new HashMap<>();
        File file = new File(path);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

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
        } catch (IOException e) {
            System.out.println("Ошибка работы с файлом " + e.getMessage());
        }

        return departments;

    }

}
