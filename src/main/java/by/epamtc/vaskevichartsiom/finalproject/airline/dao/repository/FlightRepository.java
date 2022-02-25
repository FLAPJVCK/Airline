package by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository;

import by.epamtc.vaskevichartsiom.finalproject.airline.dao.exception.DAOException;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.enums.FlightStatus;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Flight;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.User;

import java.util.List;
import java.util.Optional;

/**
 * The interface Flight repository.
 */
public interface FlightRepository extends GenericDAO<Flight> {

    /**
     * Update flight status in the database.
     *
     * @param id an id value of flight to search.
     * @param status current flight status.
     * @throws DAOException if database errors occurs.
     */
    void updateStatus(Long id, FlightStatus status) throws DAOException;

    /**
     * Finds flight object by flight id and returns container of object if exist
     * or empty container if not.
     *
     * @param id an id value of object to search.
     * @return an optional container of flight object.
     * @throws DAOException if database errors occurs.
     */
    Optional<Flight> findFlightById(Long id) throws DAOException;

    /**
     * Gets list of all available flight objects.
     *
     * @return a list of all available flight objects in database.
     * @throws DAOException if database errors occurs.
     */
    List<Flight> findAllFlights() throws DAOException;

    /**
     * Gets list of all available flight objects since the current date.
     *
     * @return a list of all available flight objects in database.
     * @throws DAOException if database errors occurs.
     */
    List<Flight> findAllCurrentFlights() throws DAOException;

    /**
     * Gets list of all available flight objects for user.
     *
     * @param id a user id value for flights search.
     * @return a list of all available flight objects in database.
     * @throws DAOException if database errors occurs.
     */
    List<Flight> findAllFlightsForUser(Long id) throws DAOException;

    /**
     * Create flight brigade in the database.
     *
     * @param flightId an id value of flight.
     * @param userId an id value of user.
     * @throws DAOException if database errors occurs.
     */
    void createBrigade(Long flightId, Long userId) throws DAOException;

    /**
     * Gets list of all available user objects of brigade in database.
     *
     * @param id an id value of brigade to search.
     * @return a list of all available user objects of brigade in database.
     * @throws DAOException if database errors occurs.
     */
    List<User> findBrigade(Long id) throws DAOException;
}
