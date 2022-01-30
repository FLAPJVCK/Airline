package by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository;

import by.epamtc.vaskevichartsiom.finalproject.airline.dao.exception.DAOException;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.enums.FlightStatus;

import java.util.List;
import java.util.Optional;

public interface StatusRepository extends GenericDAO<FlightStatus>{
    Optional<FlightStatus> findStatusByName(String name) throws DAOException;
    List<FlightStatus> findAllFlightStatuses() throws DAOException;
}
