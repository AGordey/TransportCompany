package by.gordey.transportCompany.application.components.utils;

import by.gordey.transportCompany.application.components.Button;
import by.gordey.transportCompany.application.components.actions.*;

import java.util.HashMap;
import java.util.Map;

import static by.gordey.transportCompany.application.components.utils.Application.auth;

public class ConfigButtons {
    public static final Map<Integer, Button> BUTTONS = new HashMap<>();

    static {
        BUTTONS.put(0, new Button("Рассчитать логистику из города в город", new LogisticModulAction()));
        BUTTONS.put(1, new Button("Вывести весь список городов", new ShowCitiesFromDBAction()));
        BUTTONS.put(2, new Button("Вывести весь список транспорта", new ShowTransportFromDBAction()));
        BUTTONS.put(9, new Button("Выйти из приложения", new StopApplicationAction()));


        Boolean isAdmin = auth().equalsIgnoreCase("admin");
    if(isAdmin){
        BUTTONS.put(3, new Button("Добавить город", new AddCityAction()));
        BUTTONS.put(4, new Button("Добавить транспорт", new AddTransportAction()));
        BUTTONS.put(5, new Button("Редактировать город", new UpdateCityAction()));
        BUTTONS.put(6, new Button("Редактировать транспорт", new UpdateTransportAction()));
        BUTTONS.put(7, new Button("Удалить город", new DeleteCityAction()));
        BUTTONS.put(8, new Button("Удалить транспорт", new DeleteTransportAction()));
        BUTTONS.put(10, new Button("Экспорт заявок в XML", new ExportOrdersInXMLAction()));
    }
}}
