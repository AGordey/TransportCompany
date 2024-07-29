package by.gordey.transportCompany.dao;

import by.gordey.transportCompany.connections.MysqlConnection;
import by.gordey.transportCompany.entity.City;
import by.gordey.transportCompany.entity.Transport;
import by.gordey.transportCompany.entity.TypeTransport;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransportAndCityDBDAO implements GetDataDAO {

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

    @Override
    public void addNewTransport(Transport transport) {
        try (Connection connection = MysqlConnection.getConnection()) {
            String sql = "INSERT INTO transports_and_cities.transport (" +
                    "transport_name, " +
                    "speed," +
                    "capacity_of_people," +
                    "capacity_of_weight," +
                    "cost_of_kilometer," +
                    "type_transport) " +
                    "VALUES (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, transport.getTransport_name());
            preparedStatement.setInt(2, transport.getSpeed());
            preparedStatement.setInt(3, transport.getCapacityOfPeople());
            preparedStatement.setInt(4, transport.getCapacityOfWeigh());
            preparedStatement.setInt(5, transport.getCostOfKilometer());
            preparedStatement.setInt(6, transport.getTypeTransport().getId());
            preparedStatement.execute();
            System.out.println("Транспорт успешно добавлен\n");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addNewCity(City city) {
        try (Connection connection = MysqlConnection.getConnection()) {
            String sql = "INSERT INTO transports_and_cities.city (" +
                    "name, " +
                    "latitude," +
                    "longitude," +
                    "hasAirport," +
                    "hasSeaport)" +
                    "VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, city.getName());
            preparedStatement.setDouble(2, city.getLatitude());
            preparedStatement.setDouble(3, city.getLongitude());
            preparedStatement.setBoolean(4, city.isHasAirport());
            preparedStatement.setBoolean(5, city.isHasSeaport());
            preparedStatement.execute();
            System.out.println("Город успешно добавлен\n");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateTransport(Transport transport) {
        try (Connection connection = MysqlConnection.getConnection()) {
            String sql = "UPDATE transports_and_cities.transport SET " +
                    "transport_name = ?," +
                    "speed = ?," +
                    "capacity_of_people = ?, " +
                    "capacity_of_weight = ?," +
                    "cost_of_kilometer = ?," +
                    "type_transport = ? " +
                    "WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, transport.getTransport_name());
            preparedStatement.setInt(2, transport.getSpeed());
            preparedStatement.setInt(3, transport.getCapacityOfPeople());
            preparedStatement.setInt(4, transport.getCapacityOfWeigh());
            preparedStatement.setInt(5, transport.getCostOfKilometer());
            preparedStatement.setInt(6, transport.getTypeTransport().getId());
            preparedStatement.setInt(7, transport.getId());
            preparedStatement.execute();
            System.out.println("Транспорт успешно обновлен\n");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateCity(City city) {
        try (Connection connection = MysqlConnection.getConnection()) {
            String sql = "UPDATE transports_and_cities.city SET " +
                    "name = ?," +
                    "latitude = ?," +
                    "longitude = ?, " +
                    "hasAirport = ?," +
                    "hasSeaport = ? " +
                    "WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, city.getName());
            preparedStatement.setDouble(2, city.getLatitude());
            preparedStatement.setDouble(3, city.getLongitude());
            preparedStatement.setBoolean(4, city.isHasSeaport());
            preparedStatement.setBoolean(5, city.isHasSeaport());
            preparedStatement.setInt(6, city.getId());
            preparedStatement.execute();
            System.out.println("Город успешно обновлен\n");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteTransport(int idOfTransport) {
        try (Connection connection = MysqlConnection.getConnection()) {
            String sql = "DELETE FROM transports_and_cities.transport WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idOfTransport);
            preparedStatement.execute();
            System.out.println("Транспорт успешно удален\n");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteCity(int idOfCity) {
        try (Connection connection = MysqlConnection.getConnection()) {
            String sql = "DELETE FROM transports_and_cities.city WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idOfCity);
            preparedStatement.execute();
            System.out.println("Город успешно удален\n");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addOrder(String cityFrom,
                         String cityTo,
                         int numberOfPeople,
                         int cargoQuantity,
                         String speedestTransport,
                         int priceOfSpeedestTransport,
                         int timeOfSpeedestTransport,
                         String chiepestTransport,
                         int priceOfChiepestTransport,
                         int timeOfChiepestTransport) {
        try (Connection connection = MysqlConnection.getConnection()) {
            String sql = "INSERT INTO transports_and_cities.orders (" +
                    "cityFrom, " +
                    "cityTo," +
                    "numberOfPeople," +
                    "cargoQuantity," +
                    "speedestTransport," +
                    "priceOfSpeedestTransport," +
                    "timeOfSpeedestTransport," +
                    "chiepestTransport," +
                    "priceOfChiepestTransport," +
                    "timeOfChiepestTransport) " +
                    "VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cityFrom.toUpperCase());
            preparedStatement.setString(2, cityTo.toUpperCase());
            preparedStatement.setInt(3, numberOfPeople);
            preparedStatement.setInt(4, cargoQuantity);
            preparedStatement.setString(5, speedestTransport);
            preparedStatement.setInt(6, priceOfSpeedestTransport);
            preparedStatement.setInt(7, timeOfSpeedestTransport);
            preparedStatement.setString(8, chiepestTransport);
            preparedStatement.setInt(9, priceOfChiepestTransport);
            preparedStatement.setInt(10, timeOfChiepestTransport);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
