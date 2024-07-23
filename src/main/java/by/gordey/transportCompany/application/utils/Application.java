package by.gordey.transportCompany.application.utils;

import by.gordey.transportCompany.dao.TransportAndCityDBDAO;
import by.gordey.transportCompany.entity.City;
import by.gordey.transportCompany.entity.Transport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static TransportAndCityDBDAO dbdao = new TransportAndCityDBDAO();
    List<City> cities = dbdao.getCities(); // Получаем весь список городов из БД
    List<Transport> transports = dbdao.getTransports(); // Получаем весь список транспорта из БД

    public void start() {
        System.out.println("Логистическое приложение запущено");
        run();
        System.out.println("Логистическое приложение завершено");
    }


    private void run() {
//        String cityFrom = Input.getString("Введите город отправки");
//        String cityTo = Input.getString("Введите город получения");
        String cityFrom = "rim";
        String cityTo = "tokio";
        System.out.println("Расстояние между городами " + calculateDistance(getCoordinates(cityFrom, cityTo)));
//        int quantityOfPeople = Input.getInt("Количество человек");
//        int quantityOfWeight = Input.getInt("Масса груза");
        int quantityOfPeople = 199;
        int quantityOfWeight = 1;
        System.out.println("Тип транспорта который подходит" + typeOfTransport(cityFrom, cityTo));
        System.out.println( chooseTransport(quantityOfPeople, quantityOfWeight, typeOfTransport(cityFrom, cityTo)));

    }

    private List<String> typeOfTransport(String cityFrom, String cityTo) {
        List<String> typeOfTransportForCity = new ArrayList<>(List.of("ground"));
        City city1 = new City();
        City city2 = new City();
        for (City city : cities) {
            if (city.getName().equalsIgnoreCase(cityFrom)) {
                city1 = city;
            }
            if (city.getName().equalsIgnoreCase(cityTo)) {
                city2 = city;
            }
        }
        if (city1.isHasAirport() && city2.isHasAirport()) typeOfTransportForCity.add("air");
        if (city1.isHasSeaport() && city2.isHasSeaport()) typeOfTransportForCity.add("sea");
        return typeOfTransportForCity;
    }

    private List<Transport> chooseTransport(int quantityOfPeople, int quantityOfWeight, List<String> typeOfTransport) {
        List<Transport> goodTransports = new ArrayList<>();
        for (Transport transport : transports) {
            if (transport.getCapacityOfPeople() >= quantityOfPeople &&  //отсеивание по людям
                    transport.getCapacityOfWeigh() >= quantityOfWeight && //отсеивание по грузу
                    typeOfTransport.contains(transport.getTypeTransport().getType())) {     //отсеивание по виду транспорта                                      //отсеивание по виду транспорта
                goodTransports.add(transport);
            }
        }
        return goodTransports;

    }


    //Получаем координаты по городам из списка
    private List<Double> getCoordinates(String cityFrom, String cityTo) {
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

        double result = Math.acos(Math.sin(lat1Rad) * Math.sin(lat2Rad) +
                Math.cos(lat1Rad) * Math.cos(lat2Rad) * Math.cos(lon2Rad - lon1Rad)) * 6371;
        return result;
    }


}
