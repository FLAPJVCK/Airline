package by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository;


import by.epamtc.vaskevichartsiom.finalproject.airline.dao.exception.DAOException;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Airplane;

import java.util.List;

public interface AirplaneRepository extends GenericDAO<Airplane> {
    List<Airplane> findAllAirplanes() throws DAOException;
}