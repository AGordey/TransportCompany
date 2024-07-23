package by.gordey.transportCompany.dao;

import by.gordey.transportCompany.connections.MysqlConnection;
import by.gordey.transportCompany.entity.City;
import by.gordey.transportCompany.entity.Transport;
import by.gordey.transportCompany.entity.TypeTransport;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TransportAndCityDBDAO implements getDataDAO {

    @Override
    public List<Transport> getTransports() {
        List<Transport> transports = new ArrayList<>();
        try (Connection connection = MysqlConnection.getConnection()) {
            Statement statement = connection.createStatement();
            String sql = "SELECT t.*, tt.name_type_of_transport FROM transports_and_cities.transport t " +
                    "LEFT JOIN type_of_transport tt on t.type_transport = tt.id;";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                transports.add(new Transport(
                        resultSet.getInt("id"),
                        resultSet.getString("transport_name"),
                        resultSet.getInt("speed"),
                        resultSet.getInt("capacity_of_people"),
                        resultSet.getInt("capacity_of_weight"),
                        resultSet.getInt("cost_of_kilometer"),
                        new TypeTransport(
                                resultSet.getInt("type_transport"),
                                resultSet.getString("name_type_of_transport"))
                        ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return transports;
    }

    @Override
    public List<City> getCities() {
        List<City> cities = new ArrayList<>();
        try (Connection connection = MysqlConnection.getConnection()) {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM transports_and_cities.city";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                cities.add(new City(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("latitude"),
                        resultSet.getDouble("longitude"),
                        resultSet.getBoolean("hasAirport"),
                        resultSet.getBoolean("hasSeaport")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cities;
    }

}
