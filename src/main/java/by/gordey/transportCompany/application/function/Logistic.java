package by.gordey.transportCompany.application.function;


import by.gordey.transportCompany.application.components.utils.Input;
import by.gordey.transportCompany.dao.TransportAndCityDBDAO;
import by.gordey.transportCompany.entity.City;
import by.gordey.transportCompany.entity.Transport;
import by.gordey.transportCompany.exceptions.OverloadTransportException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class Logistic {
    public static TransportAndCityDBDAO dbdao = new TransportAndCityDBDAO();
    static List<City> cities = dbdao.getCities(); // Получаем весь список городов из БД
    static List<Transport> transports = dbdao.getTransports(); // Получаем весь список транспорта из БД
    static List<String> citiesInDB = new ArrayList<>();

    //Список названий городов из БД, который далее используется при вводе городов от пользователя
    static {
        for (City city : cities) {
            citiesInDB.add(city.getName().toUpperCase());
        }
    }

    public void logistic() {
        String nameThread = Thread.currentThread().getName();
        System.out.println("Текущий поток " +nameThread);
        String cityFrom = getCity("Введите город ОТПРАВКИ");
        String cityTo = getCity("Введите город ПОЛУЧЕНИЯ");
        int quantityOfPeople = Input.getInt("Количество человек");
        int cargoQuantity = Input.getInt("Масса груза");
        try {
            chooseTransport(quantityOfPeople, cargoQuantity, typeOfTransport(cityFrom, cityTo));
            Transport theSpeedestTransport = theSpeedestTransport(chooseTransport(quantityOfPeople, cargoQuantity, typeOfTransport(cityFrom, cityTo)));
            Transport theCheapestTransport = theCheapestTransport(chooseTransport(quantityOfPeople, cargoQuantity, typeOfTransport(cityFrom, cityTo)));
            double distance = calculateDistance(getCoordinates(cityFrom, cityTo));
            int timeOfSpeedestTransport = (int) distance / theSpeedestTransport.getSpeed();
            int priceOfSpeedestTransport = (int) distance * theSpeedestTransport.getCostOfKilometer();
            int timeOfChiepestTransport = (int) distance / theCheapestTransport.getSpeed();
            int priceOfChiepestTransport = (int) distance * theCheapestTransport.getCostOfKilometer();
            //Запись информации в БД о заказе
            dbdao.addOrder(cityFrom, cityTo,
                    quantityOfPeople, cargoQuantity,
                    theSpeedestTransport.getTransport_name(), priceOfSpeedestTransport, timeOfSpeedestTransport,
                    theCheapestTransport.getTransport_name(), priceOfChiepestTransport, timeOfChiepestTransport);

            //Вывод информации самом быстром и дешевом транспорте
            System.out.printf("\nСамый быстрый транспорт для доставки %s человек и %s груза" +
                            " из %s в %s - это %s. Времяв пути %s час(а). Стоимость %s$ \n",
                    quantityOfPeople, cargoQuantity,
                    cityFrom.toUpperCase(), cityTo.toUpperCase(), theSpeedestTransport.getTransport_name(),
                    timeOfSpeedestTransport,
                    priceOfSpeedestTransport);
            System.out.printf("\nСамый дешевый транспорт для доставки %s человек и %s груза" +
                            " из %s в %s - это %s. Времяв пути %s час(а). Стоимость %s$ \n\n ",
                    quantityOfPeople, cargoQuantity,
                    cityFrom.toUpperCase(), cityTo.toUpperCase(), theCheapestTransport.getTransport_name(),
                    timeOfChiepestTransport,
                    priceOfChiepestTransport);
        } catch (OverloadTransportException e) {
            System.out.println("Нету подходящего транспорта который вместит всех за 1 раз. \n" +
                    "Раздели грузы/людей на несколько рейсов исходя из вместимости транспорта\n");
        }
    }

    private String getCity(String message) {
        System.out.println(citiesInDB);
        String city = Input.getString(message);
        if (citiesInDB.contains(city.toUpperCase())) {
            return city;
        }
        return getCity();
    }

    private String getCity() {
        System.out.println(citiesInDB);
        String city = Input.getString("Города нету в БД. Введите правильное название города");
        if (citiesInDB.contains(city.toUpperCase())) {
            return city;
        }
        return getCity("Города нету в БД. Введите правильное название города");
    }

    // Определяю самый быстрый транспорт из подходящего
    private Transport theSpeedestTransport(List<Transport> transports) {
//        transports.sort(new Comparator<Transport>() {
//            @Override
//            public int compare(Transport o1, Transport o2) {
//                return (o2.getSpeed()) - o1.getSpeed();
//            }
//        });
//        Transport transport = transports.get(0);
        Transport theSpeedestTransport = transports.stream()
                .max(Comparator.comparingInt(Transport::getSpeed)).stream().findFirst().get();
        return theSpeedestTransport ;
    }

    // Определяю самый дешевый транспорт из подходящего
    private Transport theCheapestTransport(List<Transport> transports) {
//        transports.sort(new Comparator<Transport>() {
//            @Override
//            public int compare(Transport o1, Transport o2) {
//                return (o1.getCostOfKilometer()) - o2.getCostOfKilometer();
//            }
//        });
//        Transport transport = transports.get(0);
Transport theCheapestTransport = (Transport) transports.stream().min(Comparator.comparing(Transport::getCostOfKilometer)).stream().findFirst().get();
        return theCheapestTransport;
    }


    //Составление списка по виду транспорта, который подходит под эти города
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

    //Отсеивание транспорта по виду и вместительности, который подходит под эти города
    private static List<Transport> chooseTransport(int quantityOfPeople, int quantityOfWeight, List<String> typeOfTransport) {
        List<Transport> goodTransports = new ArrayList<>();
        for (Transport transport : transports) {
            if (transport.getCapacityOfPeople() >= quantityOfPeople &&  //отсеивание по людям
                    transport.getCapacityOfWeigh() >= quantityOfWeight && //отсеивание по грузу
                    typeOfTransport.contains(transport.getTypeTransport().getType())) {     //отсеивание по виду транспорта                                      //отсеивание по виду транспорта
                goodTransports.add(transport);
            }
        }
        if (goodTransports.isEmpty()) {
//            System.out.println("Транспорта под такое количество человек/груза за 1 раз нету.");
            throw new OverloadTransportException();
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
