package by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository;

import by.epamtc.vaskevichartsiom.finalproject.airline.dao.exception.DAOException;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.enums.FlightStatus;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Flight;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface FlightRepository extends GenericDAO<Flight> {
    void updateStatus(Long id, FlightStatus status) throws DAOException;

    Optional<Flight> findFlightById(Long id) throws DAOException;

    List<Flight> findAllFlights() throws DAOException;

    List<Flight> findAllCurrentFlights() throws DAOException;

    List<Flight> findAllFlightsForUser(Long id) throws DAOException;

    void createBrigade(Long flightId, Long userId) throws DAOException;

    List<User> findBrigade(Long id) throws DAOException;
}
