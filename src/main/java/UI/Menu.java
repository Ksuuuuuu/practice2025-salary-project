package UI;

import models.DepartmentEmployees;
import repository.ReaderFile;
import repository.ReaderInteger;
import service.DepartmentHandler;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class Menu {
    private static void printMenu() {
        System.out.println("""
                Вывод:
                1. Распечатать ведомости по отделам
                2. Найти отдел с самой высокой средней заработной платой
                3. Найти отдел с самой большой общей суммой выплаты
                0. Выход""");
    }

    private static void printStatement(String statement) {
        System.out.println(statement);
    }

    private static void printDeps(Set<Integer> deps) {
        System.out.println(deps);
    }

    public static void mainMenu() throws IOException {
        Map<Integer, DepartmentEmployees> departments = ReaderFile.readFile();
        DepartmentHandler handler = new DepartmentHandler(departments);
        printMenu();
        int item = ReaderInteger.nextInt();

        switch (item) {

            case 1 -> printStatement(handler.getStatement());
            case 2 -> printDeps(handler.getDepartmentsWithHighAvg());
            case 3 -> printDeps(handler.getDepartmentsWithHighSum());
            case 0 -> {
                System.out.println("Завершение...");
                return;
            }
            default -> {
                System.out.println("Ошибка ввода");
                mainMenu();
            }
        }
        mainMenu();
    }


}
