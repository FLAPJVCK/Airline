package by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository;

import by.epamtc.vaskevichartsiom.finalproject.airline.dao.exception.DAOException;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.enums.FlightStatus;

import java.util.List;
import java.util.Optional;

/**
 * The interface Status repository.
 */
public interface StatusRepository extends GenericDAO<FlightStatus> {

    /**
     * Finds flight status object by status name and returns container of object if exist
     * or empty container if not.
     *
     * @param name a name value of object to search.
     * @return an optional container of flight status object.
     * @throws DAOException if database errors occurs.
     */
    Optional<FlightStatus> findStatusByName(String name) throws DAOException;

    /**
     * Gets list of all available flight status objects.
     *
     * @return a list of all available flight status objects in database.
     * @throws DAOException if database errors occurs.
     */
    List<FlightStatus> findAllFlightStatuses() throws DAOException;
}
