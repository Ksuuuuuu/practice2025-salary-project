import UI.Menu;
import java.io.IOException;

/*
Дан файл, содержащий сведения о заработной плате сотрудников предприятия в формате:
Номер отдела;ФИО;Сумма
Необходимо написать программу, которая позволит:
1. Распечатать ведомости по отделам
2. Найти отдел с самой высокой средней заработной платой
3. Найти отдел с самой большой общей суммой выплаты
 */

public class Application {

    public static void main(String[] args) {

        try {
            System.out.println("Начало работы");

            Menu.mainMenu();
        } catch (IOException e) {
            System.out.println("Ошибка работы с файлом");
        }
        System.out.println("Завершение работы");

    }


}
