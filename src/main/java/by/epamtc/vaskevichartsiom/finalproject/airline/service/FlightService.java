package by.epamtc.vaskevichartsiom.finalproject.airline.service;

import by.epamtc.vaskevichartsiom.finalproject.airline.domain.enums.FlightStatus;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Flight;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.User;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;

/**
 * The interface Flight service.
 */
public interface FlightService {

    /**
     * Create flight entity in the database.
     *
     * @param flight passed entity.
     * @throws ServiceException a wrapper for lower errors.
     */
    void createFlight(Flight flight) throws ServiceException;

    /**
     * Update flight entity in the database.
     *
     * @param flight passed entity.
     * @throws ServiceException a wrapper for lower errors.
     */
    void updateFlight(Flight flight) throws ServiceException;

    /**
     * Update flight status in the database.
     *
     * @param id an id value of flight to search.
     * @param status current flight status.
     * @throws ServiceException a wrapper for lower errors.
     */
    void updateStatus(Long id, FlightStatus status) throws ServiceException;

    /**
     * Delete flight entity in the database.
     *
     * @param id passed id of entity.
     * @throws ServiceException a wrapper for lower errors.
     */
    void deleteFlight(Long id) throws ServiceException;

    /**
     * Finds flight object by flight id and returns container of object if exist
     * or empty container if not.
     *
     * @param id an id value of object to search.
     * @return an optional container of flight object.
     * @throws ServiceException a wrapper for lower errors.
     */
    Optional<Flight> findById(Long id) throws ServiceException;

    /**
     * Gets list of all available flight objects.
     *
     * @return a list of all available flight objects in database.
     * @throws ServiceException a wrapper for lower errors.
     */
    List<Flight> findAllFlights() throws ServiceException;

    /**
     * Gets list of all available flight objects since the current date.
     *
     * @return a list of all available flight objects in database.
     * @throws ServiceException a wrapper for lower errors.
     */
    List<Flight> findAllCurrentFlights() throws ServiceException;

    /**
     * Gets list of all available flight objects for user.
     *
     * @param id a user id value for flights search.
     * @return a list of all available flight objects in database.
     * @throws ServiceException a wrapper for lower errors.
     */
    List<Flight> findAllFlightsForUser(Long id) throws ServiceException;

    /**
     * Create flight brigade in the database.
     *
     * @param flightId an id value of flight.
     * @param userId an id value of user.
     * @throws ServiceException a wrapper for lower errors.
     */
    void createBrigade(Long flightId, Long userId) throws ServiceException;

    /**
     * Gets list of all available user objects of brigade in database.
     *
     * @param id an id value of brigade to search.
     * @return a list of all available user objects of brigade in database.
     * @throws ServiceException a wrapper for lower errors.
     */
    List<User> findBrigade(Long id) throws ServiceException;
}
