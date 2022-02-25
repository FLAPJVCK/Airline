package by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository;

import by.epamtc.vaskevichartsiom.finalproject.airline.dao.exception.DAOException;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.AirplaneHasRank;

import java.util.List;

/**
 * The interface Airplane has rank repository.
 */
public interface AirplaneHasRankRepository extends GenericDAO<AirplaneHasRank> {

    /**
     * Gets list of all available AirplaneHasRank objects by airplane id.
     *
     * @param id an id value of object to search.
     * @return a list of all available AirplaneHasRank objects in database.
     * @throws DAOException if database errors occurs.
     */
    List<AirplaneHasRank> findAllAirplaneHasRanksByAirplaneId(Long id) throws DAOException;
}
