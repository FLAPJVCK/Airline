package by.epamtc.vaskevichartsiom.finalproject.airline.dao.connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);
    private static ConnectionPool INSTANCE;

    private static final String DB_FILE_NAME = "db";
    private static final String DB_DRIVER_NAME = "db.driver";
    private static final String DB_URL = "db.url";
    private static final String DB_USERNAME = "db.username";
    private static final String DB_PASSWORD = "db.password";
    private static final String DB_CONNECTION_NUMBER = "db.maxActive";
    private static final int DEFAULT_CONNECTION_NUMBER = 8;
    private static final AtomicBoolean isInitialized = new AtomicBoolean(false);

    private final BlockingQueue<Connection> freeConnections;
    private final BlockingQueue<Connection> busyConnections;

    public ConnectionPool() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(DB_FILE_NAME);
        String dbUrl = resourceBundle.getString(DB_URL);
        String dbUsername = resourceBundle.getString(DB_USERNAME);
        String dbPassword = resourceBundle.getString(DB_PASSWORD);
        String dbDriverName = resourceBundle.getString(DB_DRIVER_NAME);
        int maxActiveConnections;

        try {
            maxActiveConnections = Integer.parseInt(resourceBundle.getString(DB_CONNECTION_NUMBER));
        } catch (NumberFormatException e) {
            maxActiveConnections = DEFAULT_CONNECTION_NUMBER;
            LOGGER.error("Can not parse connection number, set default", e);
        }
        freeConnections = new LinkedBlockingQueue<>(maxActiveConnections);
        busyConnections = new LinkedBlockingQueue<>(maxActiveConnections);
        try {
            Class.forName(dbDriverName);
            for (int i = 0; i < maxActiveConnections; i++) {
                try {
                    Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
                    freeConnections.add(connection);
                } catch (SQLException e) {
                    LOGGER.error("Can not create connection", e);
                }
            }
        } catch (ClassNotFoundException e) {
            LOGGER.error("Can not find and load database driver", e);
        }
    }

    public static ConnectionPool getConnectionPool() {
        while (INSTANCE == null) {
            if (isInitialized.compareAndSet(false, true)) {
                INSTANCE = new ConnectionPool();
            }
        }
        return INSTANCE;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = freeConnections.take();
            busyConnections.add(connection);
        } catch (InterruptedException e) {
            LOGGER.error("Can not get connection", e);
        }
        return connection;
    }

    public void releaseConnection(Connection connection) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        try {
            busyConnections.remove(connection);
        } finally {
            lock.unlock();
        }
        freeConnections.add(connection);
    }

    public void destroyConnectionPool() {
        int countOfBusyConnections = busyConnections.size();
        for (int i = 0; i < countOfBusyConnections; i++) {
            try {
                Connection connection = busyConnections.take();
                freeConnections.put(connection);
            } catch (InterruptedException e) {
                LOGGER.error("Cannot take connection", e);
                Thread.currentThread().interrupt();
            }
        }
        int countOfFreeConnections = freeConnections.size();
        for (int i = 0; i < countOfFreeConnections; i++) {
            try {
                freeConnections.take().close();
            } catch (InterruptedException | SQLException e) {
                LOGGER.error("Cannot take or close connection", e);
                Thread.currentThread().interrupt();
            }
        }
    }
}
