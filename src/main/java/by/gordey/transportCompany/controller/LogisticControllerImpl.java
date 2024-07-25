package by.gordey.transportCompany.controller;

import by.gordey.transportCompany.dao.GetDataDAO;
import by.gordey.transportCompany.dao.TransportAndCityDBDAO;
import by.gordey.transportCompany.entity.City;
import by.gordey.transportCompany.entity.Transport;
import by.gordey.transportCompany.exceptions.DuplicateProductException;

import java.util.List;

public class LogisticControllerImpl implements LogisticController {
    private GetDataDAO getDataDAO = new TransportAndCityDBDAO();

    @Override
    public List<Transport> getTransports() {
        return getDataDAO.getTransports();
    }

    @Override
    public List<City> getCities() {
        return getDataDAO.getCities();
    }

    @Override
    public void addNewTransport(Transport transport) throws DuplicateProductException {
        getDataDAO.addNewTransport(transport);
    }

    @Override
    public void addNewCity(City city) throws DuplicateProductException {
        getDataDAO.addNewCity(city);
    }

    @Override
    public void updateTransport(Transport transport) {
        getDataDAO.updateTransport(transport);
    }

    @Override
    public void updateCity(City city) {
        getDataDAO.updateCity(city);
    }

    @Override
    public void deleteTransport(int idOfTransport) {
        getDataDAO.deleteTransport(idOfTransport);
    }

    @Override
    public void deleteCity(int idOfCity) {
        getDataDAO.deleteCity(idOfCity);
    }
}
