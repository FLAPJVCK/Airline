package by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository;

import by.epamtc.vaskevichartsiom.finalproject.airline.dao.connection.ConnectionPool;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.exception.DAOException;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.impl.UserRepositoryMySQL;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

public interface GenericDAO<T> {
    Logger LOGGER = LogManager.getLogger();
    ConnectionPool connectionPool = ConnectionPool.getConnectionPool();

    void create(T entity) throws DAOException;

    void update(T entity) throws DAOException;

    void delete(Long id) throws DAOException;

    default Connection getConnection() {
        return connectionPool.getConnection();
    }

    default void releaseConnection(Connection connection) {
        connectionPool.releaseConnection(connection);
    }

    default void closeResources(Connection connection, PreparedStatement preparedStatement) {
        if (connection != null) {
            releaseConnection(connection);
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                LOGGER.error("PreparedStatement close error", e);
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.error("Connection close error", e);
            }
        }
    }
}
