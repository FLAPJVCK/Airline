package by.epamtc.vaskevichartsiom.finalproject.airline.service.impl;

import by.epamtc.vaskevichartsiom.finalproject.airline.dao.exception.DAOException;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.DestinationRepository;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.impl.DestinationRepositoryMySQL;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Destination;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.DestinationService;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class DestinationServiceImpl implements DestinationService {

    private static final DestinationRepository destinationRepository = new DestinationRepositoryMySQL();
    private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);

    @Override
    public List<Destination> findAllDestinations() throws ServiceException {
        try {
            return destinationRepository.findAllDestinations();
        } catch (DAOException e) {
            LOGGER.error("findAllDestinations error", e);
            throw new ServiceException("findAllDestinations error", e);
        }
    }
}
