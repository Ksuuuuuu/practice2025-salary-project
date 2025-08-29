package ru.vsu.amm.practice;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.vsu.amm.practice.UI.MenuHandler;
import ru.vsu.amm.practice.repository.ReaderFile;

/*
Дан файл, содержащий сведения о заработной плате сотрудников предприятия в формате:
Номер отдела;ФИО;Сумма
Необходимо написать программу, которая позволит:
1. Распечатать ведомости по отделам
2. Найти отдел с самой высокой средней заработной платой
3. Найти отдел с самой большой общей суммой выплаты
 */

public class Application {

    private static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {

        try {
            String fileName = "info.txt";
            System.out.println("Начало работы");
            logger.info("Начало работы");
            InputStream streamFromResources = loadStreamFromResources(ReaderFile.class, fileName);

            if (streamFromResources == null) {
                throw new IOException("Файл ресурсов " + fileName + "не найден");
            }

            Map<Integer, DepartmentEmployees> departments = ReaderFile.readFile(streamFromResources);
            DepartmentHandler handler = new DepartmentHandler(departments);
            MenuHandler menu = new MenuHandler(handler);
            menu.start();
        } catch (IOException e) {
            System.out.println("Ошибка работы с файлом " + e.getMessage());
        }
        System.out.println("Завершение работы");

    }

    public static InputStream loadStreamFromResources(Class<?> clazz, String fileName) {
        return clazz.getClassLoader().getResourceAsStream(fileName);
    }


}
