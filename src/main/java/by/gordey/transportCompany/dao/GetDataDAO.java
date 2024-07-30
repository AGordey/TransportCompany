package by.gordey.transportCompany.dao;

import by.gordey.transportCompany.entity.City;
import by.gordey.transportCompany.entity.Order;
import by.gordey.transportCompany.entity.User;
import by.gordey.transportCompany.entity.Transport;

import java.util.List;

public interface GetDataDAO {
    List<Transport> getTransports();

    List<City> getCities();

    List<Order> getOrders();
    List<User> getUsers();

    void addNewTransport(Transport transport);

    void addNewCity(City city);

    void updateTransport(Transport transport);

    void updateCity(City city);

    void deleteTransport(int idOfTransport);

    void deleteCity(int idOfCity);

    void addOrder(String cityFrom,
                  String cityTo,
                  int numberOfPeople,
                  int cargoQuantity,
                  String speedestTransport,
                  int priceOfSpeedestTransport,
                  int timeOfSpeedestTransport,
                  String chiepestTransport,
                  int priceOfChiepestTransport,
                  int timeOfChiepestTransport);


}
