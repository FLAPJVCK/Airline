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
    public Optional<Flight> findById(Long id) throws ServiceException {
        return Optional.empty();
    }

    @Override
    public List<Flight> findAllFlights() throws ServiceException {
        try {
            final List<Flight> flights = flightRepository.findAllFlights();
            return flights;
        } catch (DAOException e) {
            LOGGER.error("findAllFlights error", e);
            throw new ServiceException("findAllFlights error", e);
        }
    }

    @Override
    public List<Destination> findAllDestinations() throws ServiceException {
        return null;
    }

    @Override
    public List<FlightStatus> findAllRoles() throws ServiceException {
        return null;
    }

    @Override
    public List<Airplane> findAirplanes() throws ServiceException {
        return null;
    }
}
