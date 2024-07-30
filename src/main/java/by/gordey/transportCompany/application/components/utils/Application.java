package by.gordey.transportCompany.application.components.utils;

import by.gordey.transportCompany.application.components.Button;
import by.gordey.transportCompany.exceptions.NotExistUserExeption;
import by.gordey.transportCompany.exceptions.StopApplicationException;

import java.util.Map;

import static by.gordey.transportCompany.application.components.utils.Authorization.getRole;

public class Application {

    public void start() {
        System.out.println("Приложение запущено");
        run();
        System.out.println("Приложение завершено");
    }

    public static String auth() {
        String login = Input.getString("Введите ваш login ");
        String password = Input.getString("Введите ваш password ");
        String AuthResult = getRole(login, password);
        System.out.println("Пришла роль " + AuthResult);
        try {
            if (AuthResult.equals("NotExist")) {
                System.out.println("Такого пользователя нету в БД. Зарегистрируйся и перезапусти программу");
                throw new NotExistUserExeption();
            }
        } catch (NotExistUserExeption e) {
            new NotExistUserExeption().closeApp();  //TODO Cделать корректное завершение программы
        }
        return AuthResult;
    }

    private void showMenu() {
        System.out.println("Функциональное меню. Выбери действие");
        for (Map.Entry<Integer, Button> button : ConfigButtons.BUTTONS.entrySet()) {
            System.out.println(button.getKey() + " " + button.getValue().getName());

        }}

        private void run(){
            while (true) {
                Button button = selectButton();
                try {
                    button.click();
                } catch (StopApplicationException e) {
                    break;
                }
            }
        }

        private Button selectButton(){
            showMenu();
            int key = Input.getInt();
            if (ConfigButtons.BUTTONS.containsKey(key)) { // Проверка что такой ключ есть среди кнопок
                return ConfigButtons.BUTTONS.get(key);
            }

            System.out.println("Нет такого действия!!! Повторите ввод\n");
            return selectButton();
        }

    }
