package by.epamtc.vaskevichartsiom.finalproject.airline.service;

import by.epamtc.vaskevichartsiom.finalproject.airline.domain.enums.UserRank;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.enums.UserRole;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.User;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> logIn(String email, String password) throws ServiceException;

    Optional<User> register(User user) throws ServiceException;

    void updateUser(User user) throws ServiceException;

    void deleteUser(Long id) throws ServiceException;

    Optional<User> findById(Long id) throws ServiceException;

    List<User> findAllUsers() throws ServiceException;

    List<User> findAllUsersByRank(Long id, Date date) throws ServiceException;

    List<UserRank> findAllRanks() throws ServiceException;

    List<UserRole> findAllRoles() throws ServiceException;
}
