package by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository;

import by.epamtc.vaskevichartsiom.finalproject.airline.dao.exception.DAOException;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Destination;

import java.util.List;
import java.util.Optional;

/**
 * The interface Destination repository.
 */
public interface DestinationRepository extends GenericDAO<Destination> {

    /**
     * Finds destination object by destination name and returns container of object if exist
     * or empty container if not.
     *
     * @param name a name value of object to search.
     * @return an optional container of destination object.
     * @throws DAOException if database errors occurs.
     */
    Optional<Destination> findDestinationByName(String name) throws DAOException;

    /**
     * Gets list of all available Destination objects.
     *
     * @return a list of all available Destination objects in database.
     * @throws DAOException if database errors occurs.
     */
    List<Destination> findAllDestinations() throws DAOException;
}
