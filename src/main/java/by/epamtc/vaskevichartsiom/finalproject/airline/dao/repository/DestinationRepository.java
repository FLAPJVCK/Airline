package by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository;

import by.epamtc.vaskevichartsiom.finalproject.airline.dao.exception.DAOException;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Destination;

import java.util.List;
import java.util.Optional;

public interface DestinationRepository extends GenericDAO<Destination>{
    Optional<Destination> findDestinationByName(String name) throws DAOException;
    List<Destination> findAllDestinations() throws DAOException;
}
