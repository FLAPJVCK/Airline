package by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository;

import by.epamtc.vaskevichartsiom.finalproject.airline.dao.exception.DAOException;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Manufacture;

import java.util.Optional;

/**
 * The interface Manufacture repository.
 */
public interface ManufactureRepository extends GenericDAO<Manufacture> {

    /**
     * Finds manufacture object by manufacture name and returns container of object if exist
     * or empty container if not.
     *
     * @param name a name value of object to search.
     * @return an optional container of manufacture object.
     * @throws DAOException if database errors occurs.
     */
    Optional<Manufacture> findManufactureByName(String name) throws DAOException;
}
