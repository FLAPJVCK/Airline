package by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.impl;

import by.epamtc.vaskevichartsiom.finalproject.airline.dao.exception.DAOException;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.DestinationRepository;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Destination;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DestinationRepositoryMySQL implements DestinationRepository {
    private final static String INSERT_DESTINATION = "INSERT into airline.destinations(airport) values (?)";
    private final static String UPDATE_DESTINATION = "UPDATE airline.destinations SET airport = ? WHERE id = ?";
    private final static String DELETE_DESTINATION = "DELETE FROM airline.destinations WHERE id = ?";
    private static final String FIND_DESTINATION_BY_NAME = "SELECT * FROM airline.destinations WHERE airport = ?";
    private static final String FIND_All_DESTINATIONS = "SELECT * FROM airline.destinations";

    @Override
    public void create(Destination entity) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(INSERT_DESTINATION);
            preparedStatement.setString(1, entity.getAirport());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Create destination error", e);
            throw new DAOException("Create destination error", e);
        } finally {
            closeResources(connection, preparedStatement);
        }
    }

    @Override
    public void update(Destination entity) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_DESTINATION);
            preparedStatement.setString(1, entity.getAirport());
            preparedStatement.setLong(2, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Update destination error", e);
            throw new DAOException("Update destination error", e);
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
            preparedStatement = connection.prepareStatement(DELETE_DESTINATION);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Delete destination error", e);
            throw new DAOException("Delete destination error", e);
        } finally {
            closeResources(connection, preparedStatement);
        }
    }

    @Override
    public Optional<Destination> findDestinationByName(String name) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try  {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(FIND_DESTINATION_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Destination destination = readDestination(resultSet);
                return Optional.of(destination);
            }
        } catch (SQLException e) {
            LOGGER.error("Find destination by name error", e);
            throw new DAOException("Find destination by name error", e);
        } finally {
            closeResources(connection, preparedStatement);
        }
        return Optional.empty();
    }

    @Override
    public List<Destination> findAllDestinations() throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Destination> destinations = new ArrayList<>();
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(FIND_All_DESTINATIONS);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Destination destination = readDestination(resultSet);
                    destinations.add(destination);
                }
            } catch (SQLException e) {
                LOGGER.error("findAllDestinations error", e);
                throw new DAOException("findAllDestinations error", e);
            }
        } catch (SQLException e) {
            LOGGER.error("findAllDestinations error", e);
            throw new DAOException("findAllDestinations error", e);
        } finally {
            closeResources(connection, preparedStatement);
        }
        return destinations;
    }

    private Destination readDestination(ResultSet resultSet) throws SQLException {
        Destination currentDestination = new Destination();
        currentDestination.setId(resultSet.getLong(1));
        currentDestination.setAirport(resultSet.getString(2));
        return currentDestination;
    }
}
