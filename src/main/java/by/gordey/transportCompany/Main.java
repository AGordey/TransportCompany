package by.gordey.transportCompany;

import by.gordey.transportCompany.application.utils.Application;
import by.gordey.transportCompany.connections.MysqlConnection;
import by.gordey.transportCompany.dao.TransportAndCityDBDAO;
import by.gordey.transportCompany.entity.City;
import by.gordey.transportCompany.entity.Transport;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static by.gordey.transportCompany.connections.MysqlConnection.getConnection;

public class Main {
    public static void main(String[] args) throws SQLException {
//        TransportAndCityDBDAO tb = new TransportAndCityDBDAO();
//        List<City> t = tb.getCities();
//        for (City city: t) {
//            System.out.println(city);
//        }
        new Application().start();
    }

}