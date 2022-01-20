package by.epamtc.vaskevichartsiom.finalproject.airline.service;

import by.epamtc.vaskevichartsiom.finalproject.airline.service.impl.UserServiceImpl;

public class FactoryService {

    private static final FactoryService instance = new FactoryService();

    private UserService userServiceImpl = new UserServiceImpl();

    public FactoryService() {
    }

    public static FactoryService getInstance() {
        return instance;
    }

    public UserService getUserServiceImpl() {
        return userServiceImpl;
    }

    public void setUserServiceImpl(UserService userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }
}
