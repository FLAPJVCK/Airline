package by.epamtc.vaskevichartsiom.finalproject.airline.service.impl;

import by.epamtc.vaskevichartsiom.finalproject.airline.dao.exception.DAOException;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.AirplaneRepository;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.impl.AirplaneRepositoryMySQL;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Airplane;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.AirplaneService;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class AirplaneServiceImpl implements AirplaneService {

    private static final AirplaneRepository airplaneRepository = new AirplaneRepositoryMySQL();
    private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);

    @Override
    public List<Airplane> findAllAirplanes() throws ServiceException {
        try {
            return airplaneRepository.findAllAirplanes();
        } catch (DAOException e) {
            LOGGER.error("findAllAirplanes error", e);
            throw new ServiceException("findAllAirplanes error", e);
        }
    }
}
