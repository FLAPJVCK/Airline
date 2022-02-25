package by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository;


import by.epamtc.vaskevichartsiom.finalproject.airline.dao.exception.DAOException;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Airplane;

import java.util.List;

/**
 * The interface Airplane repository.
 */
public interface AirplaneRepository extends GenericDAO<Airplane> {

    /**
     * Gets list of all available Airplane objects.
     *
     * @return a list of all available Airplane objects in database.
     * @throws DAOException if database errors occurs.
     */
    List<Airplane> findAllAirplanes() throws DAOException;
}