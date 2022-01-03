package by.epamtc.vaskevichartsiom.finalproject.airline.dao;

import by.epamtc.vaskevichartsiom.finalproject.airline.dao.impl.UserDaoImpl;

public class FactoryDao {
    private static final FactoryDao instance = new FactoryDao();

    private UserDao UserDaoImpl = new UserDaoImpl();

    public FactoryDao() {
    }

    public static FactoryDao getInstance() {
        return instance;
    }

    public UserDao getUserDaoImpl() {
        return UserDaoImpl;
    }

    public void setUserDaoImpl(UserDao userDaoImpl) {
        UserDaoImpl = userDaoImpl;
    }
}
