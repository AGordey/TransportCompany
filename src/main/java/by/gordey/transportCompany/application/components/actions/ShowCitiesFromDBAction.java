package by.gordey.transportCompany.application.components.actions;

import javax.swing.*;

public class ShowCitiesFromDBAction extends BaseAction implements Action {
    @Override
    public void apply() {
        System.out.println("Список городов из БД");
        controller.getCities().forEach(System.out::println);
        System.out.println();//Посмотреть что выведет
    }
}
