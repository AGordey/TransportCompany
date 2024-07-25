package by.gordey.transportCompany.application.components.actions;

import by.gordey.transportCompany.application.utils.Input;
import by.gordey.transportCompany.controller.LogisticController;
import by.gordey.transportCompany.controller.LogisticControllerImpl;
import by.gordey.transportCompany.entity.City;
import by.gordey.transportCompany.entity.Transport;
import by.gordey.transportCompany.entity.TypeTransport;

public abstract class BaseAction {
    protected LogisticController controller = new LogisticControllerImpl(); // Выносим сюда что бы наследники
    // использовали, т.к. применяется более 1 раза

    protected Transport createNewTransport() {
        int id = Input.getInt("Введите id");
        String transport_name = Input.getString("Введите название");
        int speed = Input.getInt("Введите скорость");
        int capacityOfPeople = Input.getInt("Введите количество человек");
        int capacityOfWeigh = Input.getInt("Введите грузовместительность");
        int costOfKilometer = Input.getInt("Введите стоимость за километр");
        int typeOfTransport = Input.getInt("Введите тип транспорта 1 - наземный, 2- воздушный, 3 - морской");
        while (typeOfTransport < 1 || typeOfTransport > 3) {
            typeOfTransport = Input.getInt("Введите КОРРЕКТНОЕ число для типа транспорта  1 - наземный, 2- воздушный, 3 - морской");
        }
        return new Transport(id, transport_name, speed, capacityOfPeople, capacityOfWeigh, costOfKilometer, new TypeTransport(typeOfTransport));
    }

    protected City createNewCity() {
        int id = Input.getInt("Введите id");
        String city_name = Input.getString("Введите название");
        double latitude = Input.getDouble("Введите координату широты города");
        double longitude = Input.getDouble("Введите координату долготы города");
        boolean hasAirport = Input.getBoolean("Есть ли аэропорт? true/false");
        boolean hasSeaport = Input.getBoolean("Есть ли морской порт? true/false");
        return new City(id, city_name, latitude, longitude, hasAirport, hasSeaport);
    }

}
