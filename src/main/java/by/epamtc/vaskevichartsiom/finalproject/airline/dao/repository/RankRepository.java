package by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository;

import by.epamtc.vaskevichartsiom.finalproject.airline.dao.exception.DAOException;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.enums.UserRank;

import java.util.List;
import java.util.Optional;

public interface RankRepository extends GenericDAO<UserRank>{
    Optional<UserRank> findRankByName(String name) throws DAOException;
    List<UserRank> findAllRanks() throws DAOException;
}
