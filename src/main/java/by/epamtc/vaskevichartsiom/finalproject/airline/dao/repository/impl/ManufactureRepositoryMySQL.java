package by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.impl;

import by.epamtc.vaskevichartsiom.finalproject.airline.dao.exception.DAOException;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.ManufactureRepository;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Manufacture;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class ManufactureRepositoryMySQL implements ManufactureRepository {
    private final static String INSERT_MANUFACTURER = """
            INSERT into airline.manufacturers 
            (manufacturer_name) 
            values (?)
            """;
    private final static String UPDATE_MANUFACTURER = """
            UPDATE airline.manufacturers 
            SET manufacturer_name = ? 
            WHERE id = ?
            """;
    private final static String DELETE_MANUFACTURER = """
            DELETE FROM airline.manufacturers 
            WHERE id = ?
            """;
    private static final String FIND_MANUFACTURER_BY_NAME = """
            SELECT * FROM airline.manufacturers 
            WHERE manufacturer_name = ?
            """;

    @Override
    public void create(Manufacture entity) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(INSERT_MANUFACTURER);
            preparedStatement.setString(1, entity.getManufacturerName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Create manufacture error", e);
            throw new DAOException("Create manufacture error", e);
        } finally {
            closeResources(connection, preparedStatement);
        }
    }

    @Override
    public void update(Manufacture entity) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_MANUFACTURER);
            preparedStatement.setString(1, entity.getManufacturerName());
            preparedStatement.setLong(2, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Update manufacture error", e);
            throw new DAOException("Update manufacture error", e);
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
            preparedStatement = connection.prepareStatement(DELETE_MANUFACTURER);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Delete manufacture error", e);
            throw new DAOException("Delete manufacture error", e);
        } finally {
            closeResources(connection, preparedStatement);
        }
    }

    @Override
    public Optional<Manufacture> findManufactureByName(String name) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(FIND_MANUFACTURER_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Manufacture manufacture = readManufacture(resultSet);
                return Optional.of(manufacture);
            }
        } catch (SQLException e) {
            LOGGER.error("Find manufacturer by name error", e);
            throw new DAOException("Find manufacturer by name error", e);
        } finally {
            closeResources(connection, preparedStatement);
        }
        return Optional.empty();
    }

    private Manufacture readManufacture(ResultSet resultSet) throws SQLException {
        Manufacture currentManufacture = new Manufacture();
        currentManufacture.setId(resultSet.getLong(1));
        currentManufacture.setManufacturerName(resultSet.getString(2));
        return currentManufacture;
    }
}
