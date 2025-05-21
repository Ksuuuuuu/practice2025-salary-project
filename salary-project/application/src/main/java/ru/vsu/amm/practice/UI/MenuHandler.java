package ru.vsu.amm.practice.UI;
import ru.vsu.amm.practice.repository.ReaderInteger;
import ru.vsu.amm.practice.DepartmentHandler;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class MenuHandler {

    private DepartmentHandler handler;

    public MenuHandler(DepartmentHandler handler) {
        this.handler = handler;
    }


    private static void printMenu() {
        System.out.println("Вывод:\n" +
                "1. Распечатать ведомости по отделам\n" +
                "2. Найти отдел с самой высокой средней заработной платой\n" +
                "3. Найти отдел с самой большой общей суммой выплаты\n" +
                "4. Распечатать информацию о количестве сотрудников в каждом отделе в процентном соотношении\n" +
                "0. Выход");
    }

    private static void printStatement(String statement) {
        System.out.println(statement);
    }

    private static void printDeps(Set<Integer> deps) {
        System.out.println(deps);
    }

    private static void printPercentEmployees(Map<Integer, Double> percentByDepartments) {
        StringBuilder stringBuilder = new StringBuilder();
        String dep = "Отдел ";
        percentByDepartments.entrySet().forEach(entry -> stringBuilder.append(dep)
                                                                      .append(entry.getKey())
                                                                      .append(" - ")
                                                                      .append(entry.getValue())
                                                                      .append(" %\n"));
        System.out.println(stringBuilder.toString());
    }

    public void start() throws IOException {

        while (true) {
            printMenu();
            int item = ReaderInteger.nextInt();

            switch (item) {

                case 1: 
                    printStatement(handler.getStatement());
                    break;
                case 2:
                    printDeps(handler.getDepartmentsWithHighAvg());
                    break;
                case 3:
                    printDeps(handler.getDepartmentsWithHighSum());
                    break;
                case 4: 
                    printPercentEmployees(handler.getPercentCountEmployeesByDepartents());
                    break;
                case 0: {
                    System.out.println("Завершение...");
                    return;
                }
                default: {
                    System.out.println("Ошибка ввода");
                }
        }
        }

    }


}
