package by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.impl;

import by.epamtc.vaskevichartsiom.finalproject.airline.dao.exception.DAOException;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.AirplaneRepository;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Airplane;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Manufacture;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirplaneRepositoryMySQL implements AirplaneRepository {
    private static final String FIND_All_AIRPLANES = "SELECT airplanes.id, model, business_seat, economy_seat," +
            " maximum_takeoff_weight, flight_range, cruising_speed, maximum_flight_height," +
            " manufacturers.manufacturer_name AS manufacturer_name FROM airline.airplanes JOIN airline.manufacturers" +
            " ON airline.airplanes.manufacturers_id = airline.manufacturers.id";

    @Override
    public void create(Airplane entity) throws DAOException {

    }

    @Override
    public void update(Airplane entity) throws DAOException {

    }

    @Override
    public void delete(Long id) throws DAOException {

    }

    @Override
    public List<Airplane> findAllAirplanes() throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Airplane> airplanes = new ArrayList<>();
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(FIND_All_AIRPLANES);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Airplane airplane = readAirplane(resultSet);
                    airplanes.add(airplane);
                }
            } catch (SQLException e) {
                LOGGER.error("findAllAirplanes error", e);
                throw new DAOException("findAllAirplanes error", e);
            }
        } catch (SQLException e) {
            LOGGER.error("findAllAirplanes error", e);
            throw new DAOException("findAllAirplanes error", e);
        } finally {
            closeResources(connection, preparedStatement);
        }
        return airplanes;
    }

    private Airplane readAirplane(ResultSet resultSet) throws SQLException {
        Airplane currentAirplane = new Airplane();
        Manufacture currenManufacture = new Manufacture();
        currentAirplane.setId(resultSet.getLong(1));
        currentAirplane.setModel(resultSet.getString(2));
        currentAirplane.setBusinessSeat(resultSet.getInt(3));
        currentAirplane.setEconomySeat(resultSet.getInt(4));
        currentAirplane.setMaximumTakeoffWeight(resultSet.getInt(5));
        currentAirplane.setFlightRange(resultSet.getInt(6));
        currentAirplane.setCruisingSpeed(resultSet.getInt(7));
        currentAirplane.setMaximumFlightHeight(resultSet.getInt(8));
        currenManufacture.setManufacturerName(resultSet.getString(9));
        currentAirplane.setManufacturer(currenManufacture);
        return currentAirplane;
    }
}
