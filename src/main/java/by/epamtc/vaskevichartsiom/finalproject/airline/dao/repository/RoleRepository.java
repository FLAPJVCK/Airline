package by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository;

import by.epamtc.vaskevichartsiom.finalproject.airline.dao.exception.DAOException;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.enums.UserRole;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends GenericDAO<UserRole> {
    Optional<UserRole> findRoleByName(String name) throws DAOException;

    List<UserRole> findAllRoles() throws DAOException;
}
