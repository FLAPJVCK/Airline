package by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.impl;

import by.epamtc.vaskevichartsiom.finalproject.airline.dao.exception.DAOException;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.FlightRepository;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.enums.FlightStatus;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Flight;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FlightRepositoryMySQL implements FlightRepository{
    private final static String INSERT_FLIGHT = "INSERT into airline.flights(flight_number,departure_date," +
            "departure_time,destinations_id,statuses_id, airplanes_id) values (?,?,?,?,?,?)";
    private final static String UPDATE_FLIGHT = "UPDATE airline.flights SET flight_number = ?,departure_date = ?," +
            "departure_time = ?,destinations_id = ?,statuses_id = ?,airplanes_id = ? WHERE id = ?";
    private final static String DELETE_FLIGHT = "DELETE FROM airline.flights WHERE id = ?";
    private static final String FIND_FLIGHT_BY_ID = "SELECT flights.id, flight_number, departure_date, departure_time, " +
            "destinations.airport AS airport_name, statuses.status_name AS status_name, airplanes.model AS model_name " +
            "FROM airline.flights JOIN airline.destinations ON airline.flights.destinations_id = " +
            "airline.destinations.id JOIN airline.statuses ON airline.flights.statuses_id = airline.statuses.id JOIN " +
            "airline.airplanes ON airline.flights.airplanes_id = airline.airplanes.id  WHERE flights.id = ?";
    private static final String FIND_All_FLIGHTS = "SELECT flights.id, flight_number, departure_date, departure_time, " +
            "destinations_id, statuses.status_name AS status_name, airplanes_id FROM airline.flights JOIN airline.statuses ON airline.flights.statuses_id = airline.statuses.id";
//    private static final String FIND_All_FLIGHTS = "SELECT flights.id, flight_number, departure_date, departure_time, " +
//            "destinations.airport AS airport_name, statuses.status_name AS status_name, airplanes.model AS model_name " +
//            "FROM airline.flights JOIN airline.destinations ON airline.flights.destinations_id = " +
//            "airline.destinations.id JOIN airline.statuses ON airline.flights.statuses_id = airline.statuses.id JOIN " +
//            "airline.airplanes ON airline.flights.airplanes_id = airline.airplanes.id ORDER BY flights.id DESC";

    @Override
    public Optional<Flight> findFlightById(Long id) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try  {
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
    public void create(Flight entity) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(INSERT_FLIGHT);
            preparedStatement.setString(1, entity.getFlightNumber());
            preparedStatement.setDate(2, entity.getDepartureDate());
            preparedStatement.setTime(3, entity.getDepartureTime());
            preparedStatement.setLong(4, entity.getDestinationId());
            if (entity.getFlightStatus() != null) {
                preparedStatement.setLong(5, entity.getFlightStatus().getId());
            } else {
                preparedStatement.setLong(5, 1);
            }
            preparedStatement.setLong(6, entity.getAirplaneId());
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
            preparedStatement.setLong(4, entity.getDestinationId());
            if (entity.getFlightStatus() != null) {
                preparedStatement.setLong(5, entity.getFlightStatus().getId());
            } else {
                preparedStatement.setLong(5, 1);
            }
            preparedStatement.setLong(6, entity.getAirplaneId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Update flight error", e);
            throw new DAOException("Update flight error", e);
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

    private Flight readFlight(ResultSet resultSet) throws SQLException {
        Flight currentFlight = new Flight();
        currentFlight.setId(resultSet.getLong(1));
        currentFlight.setFlightNumber(resultSet.getString(2));
        currentFlight.setDepartureDate(resultSet.getDate(3));
        currentFlight.setDepartureTime(resultSet.getTime(4));
        currentFlight.setDestinationId(resultSet.getLong(5));
        currentFlight.setFlightStatus(FlightStatus.valueOf(resultSet.getString(6).toUpperCase()));
        currentFlight.setAirplaneId(resultSet.getLong(7));
        return currentFlight;
    }
}
