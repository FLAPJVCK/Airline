package by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.impl;

import by.epamtc.vaskevichartsiom.finalproject.airline.dao.exception.DAOException;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.StatusRepository;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Role;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class StatusRepositoryMySQL implements StatusRepository {
    private final static String INSERT_STATUS = "INSERT into airline.statuses(status_name) values (?)";
    private final static String UPDATE_STATUS = "UPDATE airline.statuses SET status_name = ? WHERE id = ?";
    private final static String DELETE_STATUS = "DELETE FROM airline.statuses WHERE id = ?";
    private static final String FIND_STATUS_BY_NAME = "SELECT * FROM airline.statuses WHERE status_name = ?";

    @Override
    public void create(Status entity) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(INSERT_STATUS);
            preparedStatement.setString(1, entity.getStatusName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Create status error", e);
            throw new DAOException("Create status error", e);
        } finally {
            closeResources(connection, preparedStatement);
        }
    }

    @Override
    public void update(Status entity) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_STATUS);
            preparedStatement.setString(1, entity.getStatusName());
            preparedStatement.setLong(2, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Update status error", e);
            throw new DAOException("Update status error", e);
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
            preparedStatement = connection.prepareStatement(DELETE_STATUS);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Delete status error", e);
            throw new DAOException("Delete status error", e);
        } finally {
            closeResources(connection, preparedStatement);
        }
    }

    @Override
    public Optional<Status> findStatusByName(String name) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try  {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(FIND_STATUS_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Status status = readStatus(resultSet);
                return Optional.of(status);
            }
        } catch (SQLException e) {
            LOGGER.error("Find status by name error", e);
            throw new DAOException("Find status by name error", e);
        } finally {
            closeResources(connection, preparedStatement);
        }
        return Optional.empty();
    }

    private Status readStatus(ResultSet resultSet) throws SQLException {
        Status currentStatus = new Status();
        currentStatus.setId(resultSet.getLong(1));
        currentStatus.setStatusName(resultSet.getString(2));
        return currentStatus;
    }
}
