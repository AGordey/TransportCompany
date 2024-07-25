package by.gordey.transportCompany;

import by.gordey.transportCompany.application.utils.Application;
import by.gordey.transportCompany.dao.TransportAndCityDBDAO;
import by.gordey.transportCompany.entity.City;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        new Application().start();
    }

}
