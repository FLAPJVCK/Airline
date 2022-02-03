package by.epamtc.vaskevichartsiom.finalproject.airline.service;

import by.epamtc.vaskevichartsiom.finalproject.airline.domain.enums.FlightStatus;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Airplane;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Destination;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Flight;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.User;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface FlightService {
    Optional<Flight> createFlight(Flight flight) throws ServiceException;

    void updateFlight(Flight flight) throws ServiceException;

    void updateStatus(Long id, FlightStatus status) throws ServiceException;

    void deleteFlight(Long id) throws ServiceException;

    Optional<Flight> findById(Long id) throws ServiceException;

    List<Flight> findAllFlights() throws ServiceException;

    List<Flight> findAllCurrentFlights() throws ServiceException;

    List<Flight> findAllFlightsForUser(Long id) throws ServiceException;

    void createBrigade(Long flightId, Long userId) throws ServiceException;

    List<User> findBrigade(Long id) throws ServiceException;

    List<Destination> findAllDestinations() throws ServiceException;

    List<FlightStatus> findAllFlightStatuses() throws ServiceException;

    List<Airplane> findAirplanes() throws ServiceException;
}
