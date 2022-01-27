package by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository;

import by.epamtc.vaskevichartsiom.finalproject.airline.dao.exception.DAOException;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Rank;

import java.util.Optional;

public interface RankRepository extends GenericDAO<Rank>{
    Optional<Rank> findRankByName(String name) throws DAOException;
}
