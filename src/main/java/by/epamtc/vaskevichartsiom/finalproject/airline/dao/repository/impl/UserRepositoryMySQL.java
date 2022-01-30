package by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.impl;

import by.epamtc.vaskevichartsiom.finalproject.airline.dao.exception.DAOException;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.UserRepository;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.enums.UserRank;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.enums.UserRole;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepositoryMySQL implements UserRepository {
    private final static String INSERT_USER = "INSERT into airline.users(name,surname,username,password,email," +
            "role_id,rank_id) values (?,?,?,?,?,?,?)";
    private final static String UPDATE_USER = "UPDATE airline.users SET name = ?,surname = ?,username = ?," +
            "email = ?,role_id = ?,rank_id = ?, password = ? WHERE id = ?";
    private final static String UPDATE_USER_WITHOUT_PASSWORD = "UPDATE airline.users SET name = ?,surname = ?," +
            "username = ?,email = ?,role_id = ?,rank_id = ? WHERE id = ?";
    private final static String DELETE_USER = "DELETE FROM airline.users WHERE id = ?";
    private static final String FIND_USER_BY_ID = "SELECT users.id, name, surname, username, password, email," +
            " roles.role_name AS role_name, ranks.rank_name AS rank_name FROM airline.users JOIN airline.roles" +
            " ON airline.users.role_id = airline.roles.id JOIN airline.ranks ON " +
            "airline.users.rank_id = airline.ranks.id WHERE users.id = ?";
    private static final String FIND_USER_BY_EMAIL = "SELECT users.id, name, surname, username, password, email," +
            " roles.role_name AS role_name, ranks.rank_name AS rank_name FROM airline.users JOIN airline.roles" +
            " ON airline.users.role_id = airline.roles.id JOIN airline.ranks ON" +
            " airline.users.rank_id = airline.ranks.id WHERE users.email = ?";
    private static final String FIND_All_USERS = "SELECT users.id, name, surname, username, password, email," +
            " roles.role_name AS role_name, ranks.rank_name AS rank_name FROM airline.users JOIN airline.roles" +
            " ON airline.users.role_id = airline.roles.id JOIN airline.ranks ON" +
            " airline.users.rank_id = airline.ranks.id ORDER BY users.id DESC";

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
            if (user.getUserRole() != null) {
                preparedStatement.setLong(6, user.getUserRole().getId());
            } else {
                preparedStatement.setLong(6, 3);
            }
            if (user.getUserRank() != null) {
                preparedStatement.setLong(7, user.getUserRank().getId());
            } else {
                preparedStatement.setLong(7, 5);
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Create user error", e);
            throw new DAOException("Create user error", e);
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
            if (!user.getPassword().equals("")){
                preparedStatement = connection.prepareStatement(UPDATE_USER);
            } else {
                preparedStatement = connection.prepareStatement(UPDATE_USER_WITHOUT_PASSWORD);
            }

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getUsername());

            preparedStatement.setString(4, user.getEmail());
            if (user.getUserRole() != null) {
                preparedStatement.setLong(5, user.getUserRole().getId());
            } else {
                preparedStatement.setLong(5, 3);
            }
            if (user.getUserRank() != null) {
                preparedStatement.setLong(6, user.getUserRank().getId());
            } else {
                preparedStatement.setLong(6, 5);
            }
            if (!user.getPassword().equals("")){
                preparedStatement.setString(7, user.getPassword());
                preparedStatement.setLong(8, user.getId());
            } else {
                preparedStatement.setLong(7, user.getId());
            }


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Update user error" + user.toString(), e);
            throw new DAOException("Update user error", e);
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
            LOGGER.error("Delete user error", e);
            throw new DAOException("Delete user error", e);
        } finally {
            closeResources(connection, preparedStatement);
        }
    }

    @Override
    public Optional<User> findUserById(Long id) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try  {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(FIND_USER_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = readUser(resultSet);
                return Optional.of(user);
            }
        } catch (SQLException e) {
            LOGGER.error("Find user by id error", e);
            throw new DAOException("Find user by id error", e);
        } finally {
            closeResources(connection, preparedStatement);
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> findUserByEmail(String email) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try  {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(FIND_USER_BY_EMAIL);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = readUser(resultSet);
                return Optional.of(user);
            }
        } catch (SQLException e) {
            LOGGER.error("Find user by email error", e);
            throw new DAOException("Find user by email error", e);
        } finally {
            closeResources(connection, preparedStatement);
        }
        return Optional.empty();
    }

    @Override
    public List<User> findAllUsers() throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<User> users = new ArrayList<>();
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(FIND_All_USERS);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    User user = readUser(resultSet);
                    users.add(user);
                }
            } catch (SQLException e) {
                LOGGER.error("findAllUsers error", e);
                throw new DAOException("findAllUsers error", e);
            }
        } catch (SQLException e) {
            LOGGER.error("findAllUsers error", e);
            throw new DAOException("findAllUsers error", e);
        } finally {
            closeResources(connection, preparedStatement);
        }
        return users;
    }

    private User readUser(ResultSet resultSet) throws SQLException {
        User currentUser = new User();
        currentUser.setId(resultSet.getLong(1));
        currentUser.setName(resultSet.getString(2));
        currentUser.setSurname(resultSet.getString(3));
        currentUser.setUsername(resultSet.getString(4));
        currentUser.setPassword(resultSet.getString(5));
        currentUser.setEmail(resultSet.getString(6));
        currentUser.setUserRole(UserRole.valueOf(resultSet.getString(7).toUpperCase()));
        currentUser.setUserRank(UserRank.valueOf(resultSet.getString(8).toUpperCase()));
        return currentUser;
    }
}
