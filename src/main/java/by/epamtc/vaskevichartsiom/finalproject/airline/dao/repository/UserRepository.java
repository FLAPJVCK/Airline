package by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository;

import by.epamtc.vaskevichartsiom.finalproject.airline.dao.model.User;

public interface UserRepository {
    boolean register(User user) throws ClassNotFoundException;
    boolean login();
}
