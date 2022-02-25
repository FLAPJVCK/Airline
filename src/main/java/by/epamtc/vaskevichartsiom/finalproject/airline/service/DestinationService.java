package by.epamtc.vaskevichartsiom.finalproject.airline.service;

import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Destination;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;

import java.util.List;

/**
 * The interface Destination service.
 */
public interface DestinationService {

    /**
     * Gets list of all available Destination objects.
     *
     * @return a list of all available Destination objects in database.
     * @throws ServiceException a wrapper for lower errors.
     */
    List<Destination> findAllDestinations() throws ServiceException;
}
