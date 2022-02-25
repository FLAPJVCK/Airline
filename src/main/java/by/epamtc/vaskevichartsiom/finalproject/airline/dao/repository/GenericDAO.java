package by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository;

import by.epamtc.vaskevichartsiom.finalproject.airline.dao.connection.ConnectionPool;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Interface as a template for accessing to entity data in database.
 * Contains CRUD methods.
 *
 * @param <T> type of handling entities.
 */
public interface GenericDAO<T> {
    Logger LOGGER = LogManager.getLogger();
    ConnectionPool connectionPool = ConnectionPool.getConnectionPool();

    /**
     * Create an entity in the database.
     *
     * @param entity passed entity.
     * @throws DAOException if database errors occurs.
     */
    void create(T entity) throws DAOException;

    /**
     * Update an entity in the database.
     *
     * @param entity passed entity.
     * @throws DAOException if database errors occurs.
     */
    void update(T entity) throws DAOException;

    /**
     * Delete an entity in the database.
     *
     * @param id passed id of entity.
     * @throws DAOException if database errors occurs.
     */
    void delete(Long id) throws DAOException;

    /**
     * Get connection with database.
     *
     * @return connection with database.
     */
    default Connection getConnection() {
        return connectionPool.getConnection();
    }

    /**
     * Release connection with database.
     *
     * @param connection current connection with database.
     */
    default void releaseConnection(Connection connection) {
        connectionPool.releaseConnection(connection);
    }

    /**
     * Close resources in methods.
     *
     * @param connection current connection with database.
     * @param preparedStatement current prepared statement.
     */
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
    }
}
