package by.epamtc.vaskevichartsiom.finalproject.airline.service;

import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.AirplaneHasRank;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;

import java.util.List;

/**
 * The interface Airplane has ranks service.
 */
public interface AirplaneHasRanksService {

    /**
     * Gets list of all available AirplaneHasRank objects by airplane id.
     *
     * @param id an id value of object to search.
     * @return a list of all available AirplaneHasRank objects in database.
     * @throws ServiceException a wrapper for lower errors.
     */
    List<AirplaneHasRank> findAllAirplaneHasRanksByAirplaneId(Long id) throws ServiceException;
}
