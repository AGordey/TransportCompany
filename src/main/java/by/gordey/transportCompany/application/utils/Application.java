package by.gordey.transportCompany.application.utils;

import by.gordey.transportCompany.dao.TransportAndCityDBDAO;
import by.gordey.transportCompany.entity.City;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public void start() {
        System.out.println("Логистическое приложение запущено");
        run();
        System.out.println("Логистическое приложение завершено");
    }


    private void run() {
//        String cityFrom = Input.getString("Введите город отправки");
//        String cityTo = Input.getString("Введите город получения");
        String cityFrom = "MOScOW";
        String cityTo = "Cair";
        System.out.printf("Расстояние между городами "+calculateDistance(getCoordinates(cityFrom, cityTo)),2);
//        int quantityOfPeople = Input.getInt("Количество человек");
//        int quantityOfWeight = Input.getInt("Масса груза");
        int quantityOfPeople = 15;
        int quantityOfWeight = 25;

    }

    //Получаем координаты по городам из списка
    private List<Double> getCoordinates(String cityFrom, String cityTo) {
        TransportAndCityDBDAO tb = new TransportAndCityDBDAO();
        List<City> cities = tb.getCities();
        List<Double> coordinates = new ArrayList<>(3);
        for (City city : cities) {
            if (city.getName().equalsIgnoreCase(cityFrom)) {
                coordinates.add(city.getLatitude());
                coordinates.add(city.getLongitude());
            }
            if (city.getName().equalsIgnoreCase(cityTo)) {
                coordinates.add(city.getLatitude());
                coordinates.add(city.getLongitude());
            }
        }
        return coordinates;
    }

    //Cчитаем расстояние по полученным координатам
    private double calculateDistance(List<Double> coordinates) {
        double lat1Rad = Math.toRadians(coordinates.get(0));
        double lon1Rad = Math.toRadians(coordinates.get(1));
        double lat2Rad = Math.toRadians(coordinates.get(2));
        double lon2Rad = Math.toRadians(coordinates.get(3));

        double result = Math.acos(Math.sin(lat1Rad) * Math.sin(lat2Rad) + Math.cos(lat1Rad) * Math.cos(lat2Rad) * Math.cos(lon2Rad - lon1Rad)) * 6371;
        return result;
    }


}
