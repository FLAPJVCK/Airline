package by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.impl;

import by.epamtc.vaskevichartsiom.finalproject.airline.dao.exception.DAOException;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.RankRepository;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.enums.UserRank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RankRepositoryMySQL implements RankRepository {
    private final static String INSERT_RANK = "INSERT into airline.ranks(rank_name) values (?)";
    private final static String UPDATE_RANK = "UPDATE airline.ranks SET rank_name = ? WHERE id = ?";
    private final static String DELETE_RANK = "DELETE FROM airline.ranks WHERE id = ?";
    private static final String FIND_RANK_BY_NAME = """
            SELECT * FROM airline.ranks 
            WHERE rank_name = ?
            """;
    private static final String FIND_ALL_RANKS = """
            SELECT rank_name 
            FROM airline.ranks
            """;

    @Override
    public void create(UserRank entity) throws DAOException {

    }

    @Override
    public void update(UserRank entity) throws DAOException {

    }

    @Override
    public void delete(Long id) throws DAOException {

    }

    @Override
    public Optional<UserRank> findRankByName(String name) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(FIND_RANK_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                UserRank rank = readRank(resultSet);
                return Optional.of(rank);
            }
        } catch (SQLException e) {
            LOGGER.error("Find rank by name error", e);
            throw new DAOException("Find rank by name error", e);
        } finally {
            closeResources(connection, preparedStatement);
        }
        return Optional.empty();
    }

    @Override
    public List<UserRank> findAllRanks() throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<UserRank> ranks = new ArrayList<>();
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(FIND_ALL_RANKS);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    UserRank rank = readRank(resultSet);
                    ranks.add(rank);
                }
            } catch (SQLException e) {
                LOGGER.error("findAllRanks error", e);
                throw new DAOException("findAllRanks error", e);
            }
        } catch (SQLException e) {
            LOGGER.error("findAllRanks error", e);
            throw new DAOException("findAllRanks error", e);
        } finally {
            closeResources(connection, preparedStatement);
        }
        return ranks;
    }

    private UserRank readRank(ResultSet resultSet) throws SQLException {
        return UserRank.valueOf(resultSet.getString(1).toUpperCase());
    }
}
