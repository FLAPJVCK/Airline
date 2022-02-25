package by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository;

import by.epamtc.vaskevichartsiom.finalproject.airline.dao.exception.DAOException;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.enums.UserRole;

import java.util.List;
import java.util.Optional;

/**
 * The interface Role repository.
 */
public interface RoleRepository extends GenericDAO<UserRole> {

    /**
     * Finds user role object by role name and returns container of object if exist
     * or empty container if not.
     *
     * @param name a name value of object to search.
     * @return an optional container of user role object.
     * @throws DAOException if database errors occurs.
     */
    Optional<UserRole> findRoleByName(String name) throws DAOException;

    /**
     * Gets list of all available user role objects.
     *
     * @return a list of all available user role objects in database.
     * @throws DAOException if database errors occurs.
     */
    List<UserRole> findAllRoles() throws DAOException;
}
