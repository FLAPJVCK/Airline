package by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository;

import by.epamtc.vaskevichartsiom.finalproject.airline.dao.exception.DAOException;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Status;

import java.util.Optional;

public interface StatusRepository extends GenericDAO<Status>{
    Optional<Status> findStatusByName(String name) throws DAOException;
}
