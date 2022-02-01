package by.epamtc.vaskevichartsiom.finalproject.airline.service;

import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.AirplaneHasRank;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;

import java.util.List;

public interface AirplaneHasRanksService {
    List<AirplaneHasRank> findAllAirplaneHasRanksByAirplaneId(Long id) throws ServiceException;
}
