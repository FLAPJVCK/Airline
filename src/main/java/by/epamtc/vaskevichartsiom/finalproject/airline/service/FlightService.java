package by.epamtc.vaskevichartsiom.finalproject.airline.service;

import by.epamtc.vaskevichartsiom.finalproject.airline.domain.enums.FlightStatus;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Airplane;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Destination;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Flight;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface FlightService {
    Optional<Flight> findById(Long id) throws ServiceException;

    List<Flight> findAllFlights() throws ServiceException;

    List<Destination> findAllDestinations() throws ServiceException;

    List<FlightStatus> findAllRoles() throws ServiceException;

    List<Airplane> findAirplanes() throws ServiceException;
}
