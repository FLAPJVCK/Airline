package by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository;

import by.epamtc.vaskevichartsiom.finalproject.airline.dao.exception.DAOException;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.enums.UserRank;

import java.util.List;
import java.util.Optional;

/**
 * The interface Rank repository.
 */
public interface RankRepository extends GenericDAO<UserRank> {

    /**
     * Finds user rank object by rank name and returns container of object if exist
     * or empty container if not.
     *
     * @param name a name value of object to search.
     * @return an optional container of user rank object.
     * @throws DAOException if database errors occurs.
     */
    Optional<UserRank> findRankByName(String name) throws DAOException;

    /**
     * Gets list of all available user rank objects.
     *
     * @return a list of all available user rank objects in database.
     * @throws DAOException if database errors occurs.
     */
    List<UserRank> findAllRanks() throws DAOException;
}
