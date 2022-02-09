package by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository;

import by.epamtc.vaskevichartsiom.finalproject.airline.dao.exception.DAOException;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Manufacture;

import java.util.Optional;

public interface ManufactureRepository extends GenericDAO<Manufacture> {
    Optional<Manufacture> findManufactureByName(String name) throws DAOException;
}
