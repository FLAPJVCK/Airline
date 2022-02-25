package by.epamtc.vaskevichartsiom.finalproject.airline.service;

import by.epamtc.vaskevichartsiom.finalproject.airline.domain.enums.UserRank;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.enums.UserRole;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.User;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

/**
 * The interface User service.
 */
public interface UserService {

    /**
     * Finds user object by user email and password and returns container of object if exist
     * or empty container if not.
     *
     * @param email an email value of object to search.
     * @param password a password value of object to search.
     * @return an optional container of user object.
     * @throws ServiceException a wrapper for lower errors.
     */
    Optional<User> logIn(String email, String password) throws ServiceException;

    /**
     * Create user entity in the database.
     *
     * @param user passed entity.
     * @throws ServiceException a wrapper for lower errors.
     */
    void register(User user) throws ServiceException;

    /**
     * Update user entity in the database.
     *
     * @param user passed entity.
     * @throws ServiceException a wrapper for lower errors.
     */
    void updateUser(User user) throws ServiceException;

    /**
     * Delete user entity in the database.
     *
     * @param id passed id of user entity.
     * @throws ServiceException a wrapper for lower errors.
     */
    void deleteUser(Long id) throws ServiceException;

    /**
     * Finds user object by user id and returns container of object if exist
     * or empty container if not.
     *
     * @param id an id value of object to search.
     * @return an optional container of user object.
     * @throws ServiceException a wrapper for lower errors.
     */
    Optional<User> findById(Long id) throws ServiceException;

    /**
     * Gets list of all available user objects.
     *
     * @return a list of all available user objects in database.
     * @throws ServiceException a wrapper for lower errors.
     */
    List<User> findAllUsers() throws ServiceException;

    /**
     * Gets list of all available user objects.
     *
     * @param id a user id value of object to search.
     * @param date a departure date value.
     * @return a list of all available user objects in database.
     * @throws ServiceException a wrapper for lower errors.
     */
    List<User> findAllUsersByRank(Long id, Date date) throws ServiceException;

    /**
     * Gets list of all available user rank objects.
     *
     * @return a list of all available user rank objects in database.
     * @throws ServiceException a wrapper for lower errors.
     */
    List<UserRank> findAllRanks() throws ServiceException;

    /**
     * Gets list of all available user role objects.
     *
     * @return a list of all available user role objects in database.
     * @throws ServiceException a wrapper for lower errors.
     */
    List<UserRole> findAllRoles() throws ServiceException;
}
