package by.epamtc.vaskevichartsiom.finalproject.airline.service;

import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Airplane;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;

import java.util.List;

/**
 * The interface Airplane service.
 */
public interface AirplaneService {

    /**
     * Gets list of all available Airplane objects.
     *
     * @return a list of all available Airplane objects in database.
     * @throws ServiceException a wrapper for lower errors.
     */
    List<Airplane> findAllAirplanes() throws ServiceException;
}
