package by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.impl;

import by.epamtc.vaskevichartsiom.finalproject.airline.dao.exception.DAOException;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.FlightRepository;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.enums.FlightStatus;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.enums.UserRank;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FlightRepositoryMySQL implements FlightRepository {
    private final static String INSERT_FLIGHT = """
            INSERT into airline.flights 
            (flight_number,departure_date,departure_time,destinations_id,statuses_id, airplanes_id) 
            values (?,?,?,?,?,?)
            """;
    private final static String UPDATE_FLIGHT = """
            UPDATE airline.flights 
            SET flight_number = ?,departure_date = ?,departure_time = ?,destinations_id = ? 
            WHERE id = ?
            """;
    private final static String UPDATE_STATUS = """
            UPDATE airline.flights 
            SET statuses_id = ? 
            WHERE id = ?
            """;
    private final static String DELETE_FLIGHT = """
            DELETE FROM airline.flights 
            WHERE id = ?
            """;
    private static final String FIND_FLIGHT_BY_ID = """
            SELECT flights.id, flight_number, departure_date, 
            departure_time,destinations.id AS destination_id, destinations.airport AS airport_name, 
            statuses.status_name AS status_name, manufacturers.manufacturer_name AS manufacturer_name, 
            airplanes.id AS airplane_id, airplanes.model AS model_name 
            FROM airline.flights 
            JOIN airline.destinations ON airline.flights.destinations_id = airline.destinations.id 
            JOIN airline.statuses ON airline.flights.statuses_id = airline.statuses.id 
            JOIN airline.airplanes ON airline.flights.airplanes_id = airline.airplanes.id 
            JOIN airline.manufacturers ON airline.airplanes.manufacturers_id = airline.manufacturers.id 
            WHERE flights.id = ?
            """;
    private static final String FIND_All_FLIGHTS = """
            SELECT flights.id, flight_number, departure_date, departure_time, destinations.id AS destination_id, 
            destinations.airport AS airport_name,statuses.status_name AS status_name, 
            manufacturers.manufacturer_name AS manufacturer_name, airplanes.id AS airplane_id, 
            airplanes.model AS model_name 
            FROM airline.flights 
            JOIN airline.destinations ON airline.flights.destinations_id = airline.destinations.id 
            JOIN airline.statuses ON airline.flights.statuses_id = airline.statuses.id 
            JOIN airline.airplanes ON airline.flights.airplanes_id = airline.airplanes.id 
            JOIN airline.manufacturers ON airline.airplanes.manufacturers_id = airline.manufacturers.id 
            ORDER BY flights.id DESC
            """;
    private static final String FIND_All_CURRENT_FLIGHTS = """
            SELECT flights.id, flight_number, departure_date, departure_time, destinations.id AS destination_id, 
            destinations.airport AS airport_name,statuses.status_name AS status_name, 
            manufacturers.manufacturer_name AS manufacturer_name, airplanes.id AS airplane_id, 
            airplanes.model AS model_name 
            FROM airline.flights 
            JOIN airline.destinations ON airline.flights.destinations_id = airline.destinations.id 
            JOIN airline.statuses ON airline.flights.statuses_id = airline.statuses.id 
            JOIN airline.airplanes ON airline.flights.airplanes_id = airline.airplanes.id 
            JOIN airline.manufacturers ON airline.airplanes.manufacturers_id = airline.manufacturers.id 
            WHERE departure_date >= current_date() 
            ORDER BY departure_date, departure_time
            """;
    private static final String FIND_All_FLIGHTS_FOR_USER = """
            SELECT flights.id, flight_number, departure_date, departure_time, destinations.id AS destination_id, 
            destinations.airport AS airport_name,statuses.status_name AS status_name, 
            manufacturers.manufacturer_name AS manufacturer_name, airplanes.id AS airplane_id, 
            airplanes.model AS model_name 
            FROM airline.flights 
            JOIN airline.destinations ON airline.flights.destinations_id = airline.destinations.id 
            JOIN airline.statuses ON airline.flights.statuses_id = airline.statuses.id 
            JOIN airline.airplanes ON airline.flights.airplanes_id = airline.airplanes.id 
            JOIN airline.manufacturers ON airline.airplanes.manufacturers_id = airline.manufacturers.id 
            JOIN airline.brigades ON airline.flights.id = airline.brigades.flights_id 
            WHERE brigades.users_id = ?
            ORDER BY departure_date DESC, departure_time DESC
            """;
    private final static String INSERT_BRIGADE = """
            INSERT into airline.brigades 
            (flights_id, users_id) 
            values (?,?)
            """;
    private final static String FIND_BRIGADE = """
            SELECT name, surname, rank_name 
            FROM airline.brigades 
            JOIN airline.users ON users_id = users.id 
            JOIN airline.ranks ON rank_id = ranks.id 
            WHERE flights_id = ?
            """;

    @Override
    public void create(Flight entity) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(INSERT_FLIGHT);
            preparedStatement.setString(1, entity.getFlightNumber());
            preparedStatement.setDate(2, entity.getDepartureDate());
            preparedStatement.setTime(3, entity.getDepartureTime());
            preparedStatement.setLong(4, entity.getDestination().getId());
            if (entity.getFlightStatus() != null) {
                preparedStatement.setLong(5, entity.getFlightStatus().getId());
            } else {
                preparedStatement.setLong(5, 1);
            }
            preparedStatement.setLong(6, entity.getAirplane().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Create flight error", e);
            throw new DAOException("Create flight error", e);
        } finally {
            closeResources(connection, preparedStatement);
        }
    }

    @Override
    public void update(Flight entity) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_FLIGHT);
            preparedStatement.setString(1, entity.getFlightNumber());
            preparedStatement.setDate(2, entity.getDepartureDate());
            preparedStatement.setTime(3, entity.getDepartureTime());
            preparedStatement.setLong(4, entity.getDestination().getId());
            preparedStatement.setLong(5, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("update flight error", e);
            throw new DAOException("update flight error", e);
        } finally {
            closeResources(connection, preparedStatement);
        }
    }

    @Override
    public void updateStatus(Long id, FlightStatus status) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_STATUS);

            if (status == FlightStatus.NOT_READY) {
                preparedStatement.setLong(1, FlightStatus.READY.getId());
            } else if (status == FlightStatus.READY) {
                preparedStatement.setLong(1, FlightStatus.COMPLETED.getId());
            }
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("updateStatus error", e);
            throw new DAOException("updateStatus error", e);
        } finally {
            closeResources(connection, preparedStatement);
        }
    }

    @Override
    public void delete(Long id) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(DELETE_FLIGHT);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Delete flight error", e);
            throw new DAOException("Delete flight error", e);
        } finally {
            closeResources(connection, preparedStatement);
        }
    }

    @Override
    public Optional<Flight> findFlightById(Long id) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(FIND_FLIGHT_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Flight flight = readFlight(resultSet);
                return Optional.of(flight);
            }
        } catch (SQLException e) {
            LOGGER.error("Find flight by id error", e);
            throw new DAOException("Find flight by id error", e);
        } finally {
            closeResources(connection, preparedStatement);
        }
        return Optional.empty();
    }

    @Override
    public List<Flight> findAllFlights() throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Flight> flights = new ArrayList<>();
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(FIND_All_FLIGHTS);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Flight flight = readFlight(resultSet);
                    flights.add(flight);
                }
            } catch (SQLException e) {
                LOGGER.error("findAllFlights error", e);
                throw new DAOException("findAllFlights error", e);
            }
        } catch (SQLException e) {
            LOGGER.error("findAllFlights error", e);
            throw new DAOException("findAllFlights error", e);
        } finally {
            closeResources(connection, preparedStatement);
        }
        return flights;
    }

    @Override
    public List<Flight> findAllCurrentFlights() throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Flight> flights = new ArrayList<>();
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(FIND_All_CURRENT_FLIGHTS);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Flight flight = readFlight(resultSet);
                    flights.add(flight);
                }
            } catch (SQLException e) {
                LOGGER.error("findAllCurrentFlights error", e);
                throw new DAOException("findAllCurrentFlights error", e);
            }
        } catch (SQLException e) {
            LOGGER.error("findAllCurrentFlights error", e);
            throw new DAOException("findAllCurrentFlights error", e);
        } finally {
            closeResources(connection, preparedStatement);
        }
        return flights;
    }

    @Override
    public List<Flight> findAllFlightsForUser(Long id) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Flight> flights = new ArrayList<>();
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(FIND_All_FLIGHTS_FOR_USER);
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Flight flight = readFlight(resultSet);
                    flights.add(flight);
                }
            } catch (SQLException e) {
                LOGGER.error("findAllFlightsForUser error", e);
                throw new DAOException("findAllFlightsForUser error", e);
            }
        } catch (SQLException e) {
            LOGGER.error("findAllFlightsForUser error", e);
            throw new DAOException("findAllFlightsForUser error", e);
        } finally {
            closeResources(connection, preparedStatement);
        }
        return flights;
    }

    @Override
    public void createBrigade(Long flightId, Long userId) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(INSERT_BRIGADE);
            preparedStatement.setLong(1, flightId);
            preparedStatement.setLong(2, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Create brigade error", e);
            throw new DAOException("Create brigade error", e);
        } finally {
            closeResources(connection, preparedStatement);
        }
    }

    @Override
    public List<User> findBrigade(Long id) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<User> users = new ArrayList<>();
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(FIND_BRIGADE);
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    User user = readBrigade(resultSet);
                    users.add(user);
                }
            } catch (SQLException e) {
                LOGGER.error("findBrigade error", e);
                throw new DAOException("findBrigade error", e);
            }
        } catch (SQLException e) {
            LOGGER.error("findBrigade error", e);
            throw new DAOException("findBrigade error", e);
        } finally {
            closeResources(connection, preparedStatement);
        }
        return users;
    }

    private Flight readFlight(ResultSet resultSet) throws SQLException {
        Flight currentFlight = new Flight();
        Destination currentDestination = new Destination();
        Airplane currentAirplane = new Airplane();
        Manufacture currenManufacture = new Manufacture();
        currentFlight.setId(resultSet.getLong(1));
        currentFlight.setFlightNumber(resultSet.getString(2));
        currentFlight.setDepartureDate(resultSet.getDate(3));
        currentFlight.setDepartureTime(resultSet.getTime(4));
        currentDestination.setId(resultSet.getLong(5));
        currentDestination.setAirport(resultSet.getString(6));
        currentFlight.setFlightStatus(FlightStatus.valueOf(resultSet.getString(7).toUpperCase()));
        currenManufacture.setManufacturerName(resultSet.getString(8));
        currentAirplane.setId(resultSet.getLong(9));
        currentAirplane.setModel(resultSet.getString(10));
        currentAirplane.setManufacturer(currenManufacture);
        currentFlight.setDestination(currentDestination);
        currentFlight.setAirplane(currentAirplane);
        return currentFlight;
    }

    private User readBrigade(ResultSet resultSet) throws SQLException {
        User currentUser = new User();
        currentUser.setName(resultSet.getString(1));
        currentUser.setSurname(resultSet.getString(2));
        currentUser.setUserRank(UserRank.valueOf(resultSet.getString(3).toUpperCase()));
        return currentUser;
    }
}
