package by.epamtc.vaskevichartsiom.finalproject.airline.service;

import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.User;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;

import java.util.Optional;

public interface UserService {
    Optional<User> logIn(String email, String password) throws ServiceException;

    Optional<User> register(User user) throws ServiceException;

    Optional<User> updateUser(User user) throws ServiceException;

    Optional<User> deleteUser(Long id) throws ServiceException;

    Optional<User> findById(Long id) throws ServiceException;
}
