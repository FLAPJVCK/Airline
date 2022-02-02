package by.epamtc.vaskevichartsiom.finalproject.airline.service.impl;

import by.epamtc.vaskevichartsiom.finalproject.airline.dao.exception.DAOException;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.AirplaneRepository;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.DestinationRepository;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.FlightRepository;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.StatusRepository;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.impl.AirplaneRepositoryMySQL;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.impl.DestinationRepositoryMySQL;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.impl.FlightRepositoryMySQL;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.impl.StatusRepositoryMySQL;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.enums.FlightStatus;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Airplane;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Destination;
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
    private static final DestinationRepository destinationRepository = new DestinationRepositoryMySQL();
    private static final StatusRepository statusRepository = new StatusRepositoryMySQL();
    private static final AirplaneRepository airplaneRepository = new AirplaneRepositoryMySQL();
    private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);

    @Override
    public Optional<Flight> createFlight(Flight flight) throws ServiceException {
        try {
            flightRepository.create(flight);
            return Optional.of(flight);
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
            Optional<Flight> flight = flightRepository.findFlightById(id);
            return flight;
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

    @Override
    public List<Destination> findAllDestinations() throws ServiceException {
        return null;
    }

    @Override
    public List<FlightStatus> findAllFlightStatuses() throws ServiceException {
        try {
            return statusRepository.findAllFlightStatuses();
        } catch (DAOException e) {
            LOGGER.error("findAllFlightStatuses error", e);
            throw new ServiceException("findAllFlightStatuses error", e);
        }
    }

    @Override
    public List<Airplane> findAirplanes() throws ServiceException {
        return null;
    }
}
