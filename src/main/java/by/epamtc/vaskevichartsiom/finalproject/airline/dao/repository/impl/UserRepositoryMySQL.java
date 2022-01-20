package by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.impl;

import by.epamtc.vaskevichartsiom.finalproject.airline.dao.connection.ConnectionPool;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.UserRepository;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
    public void create(User user) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = ConnectionPool.getInstance().getConnection().prepareStatement(INSERT_USER);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getEmail());
            if (user.getRoleId() != null){
                preparedStatement.setLong(6, user.getRoleId());
            } else {
                preparedStatement.setLong(6, 3);
            }
            if (user.getRankId() != null){
                preparedStatement.setLong(7, user.getRankId());
            } else {
                preparedStatement.setLong(7, 5);
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("UserRepositoryMySQL create error" + user.toString(), e);
        }
    }

    @Override
    public void update(User user) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = ConnectionPool.getInstance().getConnection().prepareStatement(UPDATE_USER);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getEmail());
            if (user.getRoleId() != null){
                preparedStatement.setLong(6, user.getRoleId());
            } else {
                preparedStatement.setLong(6, 3);
            }
            if (user.getRankId() != null){
                preparedStatement.setLong(7, user.getRankId());
            } else {
                preparedStatement.setLong(7, 5);
            }
            preparedStatement.setLong(8,user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("UserRepositoryMySQL update error" + user.toString(), e);
        }
    }

    @Override
    public void delete(Long id) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = ConnectionPool.getInstance().getConnection().prepareStatement(DELETE_USER);
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("UserRepositoryMySQL delete error", e);
        }
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = ConnectionPool.getInstance().getConnection().prepareStatement(FIND_USER_BY_EMAIL_AND_PASSWORD);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = readUser(resultSet);
                return Optional.of(user);
            }
        } catch (SQLException e) {
            LOGGER.error("UserRepositoryMySQL find by email error", e);
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
