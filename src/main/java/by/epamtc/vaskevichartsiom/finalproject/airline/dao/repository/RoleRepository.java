package by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository;

import by.epamtc.vaskevichartsiom.finalproject.airline.dao.exception.DAOException;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Role;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.User;

import java.util.Optional;

public interface RoleRepository extends GenericDAO<Role>{
    Optional<Role> findRoleByName(String name) throws DAOException;
}
