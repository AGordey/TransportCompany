package by.gordey.transportCompany.controller;

import by.gordey.transportCompany.entity.City;
import by.gordey.transportCompany.entity.Order;
import by.gordey.transportCompany.entity.Transport;
import by.gordey.transportCompany.exceptions.DuplicateProductException;

import java.util.List;

public interface LogisticController {

    List<Transport> getTransports();

    List<City> getCities();

    List<Order> getOrders();

    void addNewTransport(Transport transport) throws DuplicateProductException;

    void addNewCity(City city) throws DuplicateProductException;

    void updateTransport(Transport transport);

    void updateCity(City city);

    void deleteTransport(int idOfTransport);

    void deleteCity(int idOfCity);

}
