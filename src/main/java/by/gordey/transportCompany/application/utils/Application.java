package by.gordey.transportCompany.application.utils;

import by.gordey.transportCompany.application.components.Button;
import by.gordey.transportCompany.dao.TransportAndCityDBDAO;
import by.gordey.transportCompany.entity.City;
import by.gordey.transportCompany.entity.Transport;
import by.gordey.transportCompany.exceptions.StopApplicationException;

import java.util.List;
import java.util.Map;

public class Application {

    public void start() {
        System.out.println("Приложение запущено");
        run();
        System.out.println("Приложение завершено");
    }

    private void showMenu() {
        System.out.println("Функциональное меню. Выбери действие");
        for (Map.Entry<Integer, Button> button : ConfigButtons.BUTTONS.entrySet()) {
            System.out.println(button.getKey() + " " + button.getValue().getName());
        }

    }

    private void run() {
        while (true) {
            Button button = selectButton();
            try {
                button.click();
            } catch (StopApplicationException e) {
                break;
            }
        }
    }

    private Button selectButton() {
        showMenu();
        int key = Input.getInt();
        if (ConfigButtons.BUTTONS.containsKey(key)) { // Проверка что такой ключ есть среди кнопок
            return ConfigButtons.BUTTONS.get(key);
        }

        System.out.println("Нет такого действия!!! Повторите ввод\n");
        return selectButton();
    }

}
