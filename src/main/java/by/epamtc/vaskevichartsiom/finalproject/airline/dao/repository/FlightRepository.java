package by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository;

import by.epamtc.vaskevichartsiom.finalproject.airline.dao.exception.DAOException;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Flight;

import java.util.List;
import java.util.Optional;

public interface FlightRepository extends GenericDAO<Flight> {
    Optional<Flight> findFlightById(Long id) throws DAOException;
    List<Flight> findAllFlights() throws DAOException;
}
