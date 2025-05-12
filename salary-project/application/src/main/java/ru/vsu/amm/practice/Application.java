package ru.vsu.amm.practice;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.vsu.amm.practice.UI.Menu;

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
            System.out.println("Начало работы");
            logger.info("Начало работы");

            Menu.mainMenu();
        } catch (IOException e) {
            System.out.println("Ошибка работы с файлом");
        }
        System.out.println("Завершение работы");

    }


}
