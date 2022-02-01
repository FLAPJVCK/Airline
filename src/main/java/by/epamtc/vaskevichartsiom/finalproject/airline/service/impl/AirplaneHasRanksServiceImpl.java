package by.epamtc.vaskevichartsiom.finalproject.airline.service.impl;

import by.epamtc.vaskevichartsiom.finalproject.airline.dao.exception.DAOException;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.AirplaneHasRankRepository;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.impl.AirplaneHasRankRepositoryMySQL;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.AirplaneHasRank;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.AirplaneHasRanksService;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class AirplaneHasRanksServiceImpl implements AirplaneHasRanksService {
    private static final AirplaneHasRankRepository airplaneHasRankRepository = new AirplaneHasRankRepositoryMySQL();
    private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);

    @Override
    public List<AirplaneHasRank> findAllAirplaneHasRanksByAirplaneId(Long id) throws ServiceException {
        try {
            return airplaneHasRankRepository.findAllAirplaneHasRanksByAirplaneId(id);
        } catch (DAOException e) {
            LOGGER.error("findAllAirplaneHasRanksByAirplaneId error", e);
            throw new ServiceException("findAllAirplaneHasRanksByAirplaneId error", e);
        }
    }
}
