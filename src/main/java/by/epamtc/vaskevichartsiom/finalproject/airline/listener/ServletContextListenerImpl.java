package by.epamtc.vaskevichartsiom.finalproject.airline.listener;

import by.epamtc.vaskevichartsiom.finalproject.airline.dao.connection.ConnectionPool;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletContextListenerImpl implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ConnectionPool.getConnectionPool();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ConnectionPool.getConnectionPool().destroyConnectionPool();
    }
}
