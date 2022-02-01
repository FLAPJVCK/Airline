package by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.impl;

import by.epamtc.vaskevichartsiom.finalproject.airline.dao.exception.DAOException;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.AirplaneHasRankRepository;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.enums.UserRank;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.AirplaneHasRank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirplaneHasRankRepositoryMySQL implements AirplaneHasRankRepository {

    private static final String FIND_All_AIRPLANE_HAS_RANKS_BY_AIRPLANE_ID = "SELECT rank_count, ranks.rank_name AS " +
            "rank_name FROM airline.airplanes_has_ranks JOIN airline.airplanes ON " +
            "airline.airplanes_has_ranks.airplanes_id = airline.airplanes.id JOIN airline.ranks ON " +
            "airline.airplanes_has_ranks.ranks_id = airline.ranks.id WHERE airplanes.id = ?";

    @Override
    public List<AirplaneHasRank> findAllAirplaneHasRanksByAirplaneId(Long id) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<AirplaneHasRank> airplaneHasRanks = new ArrayList<>();
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(FIND_All_AIRPLANE_HAS_RANKS_BY_AIRPLANE_ID);
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    AirplaneHasRank airplaneHasRank = readAirplaneHasRanks(resultSet);
                    airplaneHasRanks.add(airplaneHasRank);
                }
            } catch (SQLException e) {
                LOGGER.error("findAllAirplaneHasRanksByAirplaneId error", e);
                throw new DAOException("findAllAirplaneHasRanksByAirplaneId error", e);
            }
        } catch (SQLException e) {
            LOGGER.error("findAllAirplaneHasRanksByAirplaneId error", e);
            throw new DAOException("findAllAirplaneHasRanksByAirplaneId error", e);
        } finally {
            closeResources(connection, preparedStatement);
        }
        return airplaneHasRanks;
    }

    @Override
    public void create(AirplaneHasRank entity) throws DAOException {

    }

    @Override
    public void update(AirplaneHasRank entity) throws DAOException {

    }

    @Override
    public void delete(Long id) throws DAOException {

    }

    private AirplaneHasRank readAirplaneHasRanks(ResultSet resultSet) throws SQLException {
        AirplaneHasRank currentAirplaneHasRank = new AirplaneHasRank();
        currentAirplaneHasRank.setRankCount(resultSet.getInt(1));
        currentAirplaneHasRank.setUserRank(UserRank.valueOf(resultSet.getString(2).toUpperCase()));
        return currentAirplaneHasRank;
    }
}
