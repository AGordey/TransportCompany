package by.gordey.transportCompany.dao;

import by.gordey.transportCompany.entity.City;
import by.gordey.transportCompany.entity.Transport;

import java.util.List;

public interface getDataDAO {
    List<Transport> getTransports();
    List<City> getCities();

}
