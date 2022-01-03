package by.epamtc.vaskevichartsiom.finalproject.airline.dao;

import by.epamtc.vaskevichartsiom.finalproject.airline.model.User;

public interface UserDao {
    boolean saveUser(User user) throws ClassNotFoundException;
    boolean readUser();
}
