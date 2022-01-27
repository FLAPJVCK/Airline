package by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository;

import by.epamtc.vaskevichartsiom.finalproject.airline.dao.exception.DAOException;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends GenericDAO<User>{
    Optional<User> findUserByEmail(String email) throws DAOException;
    List<User> getAllUsers() throws DAOException;
}
