package by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.impl;

import by.epamtc.vaskevichartsiom.finalproject.airline.dao.exception.DAOException;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.UserRepository;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserRepositoryMySQL implements UserRepository {
    private static final Logger LOGGER = LogManager.getLogger(UserRepositoryMySQL.class);

    private final static String INSERT_USER = "insert into airline.users(name,surname,username,password,email,role_id,rank_id) values (?,?,?,?,?,?,?)";
    private final static String UPDATE_USER = "UPDATE users SET name = ?,surname = ?,username = ?,password = ?,email = ?,role_id = ?,rank_id = ? WHERE id = ?";
    private final static String DELETE_USER = "DELETE FROM users WHERE users_id = ?";
    private static final String FIND_USER_BY_EMAIL_AND_PASSWORD = "SELECT * FROM users WHERE email = ?";

    @Override
    public void create(User user) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(INSERT_USER);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getEmail());
            if (user.getRoleId() != null) {
                preparedStatement.setLong(6, user.getRoleId());
            } else {
                preparedStatement.setLong(6, 3);
            }
            if (user.getRankId() != null) {
                preparedStatement.setLong(7, user.getRankId());
            } else {
                preparedStatement.setLong(7, 5);
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Create error", e);
            throw new DAOException("Create error", e);
        } finally {
            closeResources(connection, preparedStatement);
        }
    }

    @Override
    public void update(User user) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_USER);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getEmail());
            if (user.getRoleId() != null) {
                preparedStatement.setLong(6, user.getRoleId());
            } else {
                preparedStatement.setLong(6, 3);
            }
            if (user.getRankId() != null) {
                preparedStatement.setLong(7, user.getRankId());
            } else {
                preparedStatement.setLong(7, 5);
            }
            preparedStatement.setLong(8, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Update error" + user.toString(), e);
            throw new DAOException("Update error", e);
        } finally {
            closeResources(connection, preparedStatement);
        }
    }

    @Override
    public void delete(Long id) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(DELETE_USER);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Delete error", e);
            throw new DAOException("Delete error", e);
        } finally {
            closeResources(connection, preparedStatement);
        }
    }

    @Override
    public Optional<User> findUserByEmail(String email) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try  {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(FIND_USER_BY_EMAIL_AND_PASSWORD);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = readUser(resultSet);
                return Optional.of(user);
            }
        } catch (SQLException e) {
            LOGGER.error("Find by email error", e);
            throw new DAOException("Find by email error", e);
        } finally {
            closeResources(connection, preparedStatement);
        }
        return Optional.empty();
    }

    private User readUser(ResultSet resultSet) throws SQLException {
        User currentUser = new User();
        currentUser.setId(resultSet.getLong(1));
        currentUser.setName(resultSet.getString(2));
        currentUser.setSurname(resultSet.getString(3));
        currentUser.setUsername(resultSet.getString(4));
        currentUser.setPassword(resultSet.getString(5));
        currentUser.setEmail(resultSet.getString(6));
        currentUser.setRoleId(resultSet.getLong(7));
        currentUser.setRankId(resultSet.getLong(8));
        return currentUser;
    }
}
