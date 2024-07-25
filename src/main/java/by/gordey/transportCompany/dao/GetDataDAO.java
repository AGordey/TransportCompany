package by.gordey.transportCompany.dao;

import by.gordey.transportCompany.entity.City;
import by.gordey.transportCompany.entity.Transport;

import java.util.List;

public interface GetDataDAO {
    List<Transport> getTransports();

    List<City> getCities();

    void addNewTransport(Transport transport);

    void addNewCity(City city);

    void updateTransport(Transport transport);

    void updateCity(City city);

    void deleteTransport(int idOfTransport);

    void deleteCity(int idOfCity);


}
