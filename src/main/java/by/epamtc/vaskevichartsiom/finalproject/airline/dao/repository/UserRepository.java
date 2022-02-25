package by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository;

import by.epamtc.vaskevichartsiom.finalproject.airline.dao.exception.DAOException;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.User;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

/**
 * The interface User repository.
 */
public interface UserRepository extends GenericDAO<User> {

    /**
     * Finds user object by user id and returns container of object if exist
     * or empty container if not.
     *
     * @param id an id value of object to search.
     * @return an optional container of user object.
     * @throws DAOException if database errors occurs.
     */
    Optional<User> findUserById(Long id) throws DAOException;

    /**
     * Finds user object by user email and returns container of object if exist
     * or empty container if not.
     *
     * @param email an email value of object to search.
     * @return an optional container of user object.
     * @throws DAOException if database errors occurs.
     */
    Optional<User> findUserByEmail(String email) throws DAOException;

    /**
     * Gets list of all available user objects.
     *
     * @return a list of all available user objects in database.
     * @throws DAOException if database errors occurs.
     */
    List<User> findAllUsers() throws DAOException;

    /**
     * Gets list of all available user objects.
     *
     * @param id a user id value of object to search.
     * @param date a departure date value.
     * @return a list of all available user objects in database.
     * @throws DAOException if database errors occurs.
     */
    List<User> findAllUsersByRank(Long id, Date date) throws DAOException;
}
