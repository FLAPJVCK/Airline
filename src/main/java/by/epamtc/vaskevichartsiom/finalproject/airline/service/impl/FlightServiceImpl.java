package by.epamtc.vaskevichartsiom.finalproject.airline.service.impl;

import by.epamtc.vaskevichartsiom.finalproject.airline.dao.exception.DAOException;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.FlightRepository;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.impl.FlightRepositoryMySQL;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.enums.FlightStatus;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Flight;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.User;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.FlightService;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class FlightServiceImpl implements FlightService {

    private static final FlightRepository flightRepository = new FlightRepositoryMySQL();
    private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);

    @Override
    public void createFlight(Flight flight) throws ServiceException {
        try {
            flightRepository.create(flight);
        } catch (DAOException e) {
            LOGGER.error("createFlight error", e);
            throw new ServiceException("createFlight error", e);
        }
    }

    @Override
    public void updateFlight(Flight flight) throws ServiceException {
        try {
            flightRepository.update(flight);
        } catch (DAOException e) {
            LOGGER.error("update flight error", e);
            throw new ServiceException("update flight error", e);
        }
    }

    @Override
    public void updateStatus(Long id, FlightStatus status) throws ServiceException {
        try {
            flightRepository.updateStatus(id, status);
        } catch (DAOException e) {
            LOGGER.error("update status error", e);
            throw new ServiceException("update status error", e);
        }
    }

    @Override
    public void deleteFlight(Long id) throws ServiceException {
        try {
            flightRepository.delete(id);
        } catch (DAOException e) {
            LOGGER.error("delete flight error", e);
            throw new ServiceException("delete flight error", e);
        }
    }

    @Override
    public Optional<Flight> findById(Long id) throws ServiceException {
        try {
            return flightRepository.findFlightById(id);
        } catch (DAOException e) {
            LOGGER.error("Find flight by id error", e);
            throw new ServiceException("Find flight by id error", e);
        }
    }

    @Override
    public List<Flight> findAllFlights() throws ServiceException {
        try {
            return flightRepository.findAllFlights();
        } catch (DAOException e) {
            LOGGER.error("findAllFlights error", e);
            throw new ServiceException("findAllFlights error", e);
        }
    }

    @Override
    public List<Flight> findAllCurrentFlights() throws ServiceException {
        try {
            return flightRepository.findAllCurrentFlights();
        } catch (DAOException e) {
            LOGGER.error("findAllCurrentFlights error", e);
            throw new ServiceException("findAllCurrentFlights error", e);
        }
    }

    @Override
    public List<Flight> findAllFlightsForUser(Long id) throws ServiceException {
        try {
            return flightRepository.findAllFlightsForUser(id);
        } catch (DAOException e) {
            LOGGER.error("findAllFlightsForUser error", e);
            throw new ServiceException("findAllFlightsForUser error", e);
        }
    }

    @Override
    public void createBrigade(Long flightId, Long userId) throws ServiceException {
        try {
            flightRepository.createBrigade(flightId, userId);
        } catch (DAOException e) {
            LOGGER.error("createFlight error", e);
            throw new ServiceException("createFlight error", e);
        }
    }

    @Override
    public List<User> findBrigade(Long id) throws ServiceException {
        try {
            return flightRepository.findBrigade(id);
        } catch (DAOException e) {
            LOGGER.error("findBrigade by flight id error", e);
            throw new ServiceException("findBrigade by flight id error", e);
        }
    }
}
