package by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository;

import by.epamtc.vaskevichartsiom.finalproject.airline.dao.exception.DAOException;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.AirplaneHasRank;

import java.util.List;

public interface AirplaneHasRankRepository extends GenericDAO<AirplaneHasRank>{
    List<AirplaneHasRank> findAllAirplaneHasRanksByAirplaneId(Long id) throws DAOException;
}
