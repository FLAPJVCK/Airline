package by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.impl;

import by.epamtc.vaskevichartsiom.finalproject.airline.dao.exception.DAOException;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.RoleRepository;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.enums.UserRole;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Role;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RoleRepositoryMySQL implements RoleRepository {
    private final static String INSERT_ROLE = "INSERT into airline.roles(role_name) values (?)";
    private final static String UPDATE_ROLE = "UPDATE airline.roles SET role_name = ? WHERE id = ?";
    private final static String DELETE_ROLE = "DELETE FROM airline.roles WHERE id = ?";
    private static final String FIND_ROLE_BY_NAME = "SELECT * FROM airline.roles WHERE role_name = ?";
    private static final String FIND_ALL_ROLES = "SELECT role_name FROM airline.roles";

    @Override
    public void create(UserRole entity) throws DAOException {

    }

    @Override
    public void update(UserRole entity) throws DAOException {

    }

    @Override
    public void delete(Long id) throws DAOException {

    }
//    @Override
//    public void create(UserRole entity) throws DAOException {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        try {
//            connection = getConnection();
//            preparedStatement = connection.prepareStatement(INSERT_ROLE);
//            preparedStatement.setString(1, entity.getRoleName());
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            LOGGER.error("Create role error", e);
//            throw new DAOException("Create role error", e);
//        } finally {
//            closeResources(connection, preparedStatement);
//        }
//    }
//
//    @Override
//    public void update(UserRole entity) throws DAOException {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        try {
//            connection = getConnection();
//            preparedStatement = connection.prepareStatement(UPDATE_ROLE);
//            preparedStatement.setString(1, entity.getRoleName());
//            preparedStatement.setLong(2, entity.getId());
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            LOGGER.error("Update role error", e);
//            throw new DAOException("Update role error", e);
//        } finally {
//            closeResources(connection, preparedStatement);
//        }
//    }
//
//    @Override
//    public void delete(Long id) throws DAOException {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        try {
//            connection = getConnection();
//            preparedStatement = connection.prepareStatement(DELETE_ROLE);
//            preparedStatement.setLong(1, id);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            LOGGER.error("Delete role error", e);
//            throw new DAOException("Delete role error", e);
//        } finally {
//            closeResources(connection, preparedStatement);
//        }
//    }

    @Override
    public Optional<UserRole> findRoleByName(String name) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try  {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(FIND_ROLE_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                UserRole role = readRole(resultSet);
                return Optional.of(role);
            }
        } catch (SQLException e) {
            LOGGER.error("Find role by name error", e);
            throw new DAOException("Find role by name error", e);
        } finally {
            closeResources(connection, preparedStatement);
        }
        return Optional.empty();
    }

    @Override
    public List<UserRole> findAllRoles() throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<UserRole> roles = new ArrayList<>();
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(FIND_ALL_ROLES);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    UserRole role = readRole(resultSet);
                    roles.add(role);
                }
            } catch (SQLException e) {
                LOGGER.error("findAllRoles error", e);
                throw new DAOException("findAllRoles error", e);
            }
        } catch (SQLException e) {
            LOGGER.error("findAllRoles error", e);
            throw new DAOException("findAllRoles error", e);
        } finally {
            closeResources(connection, preparedStatement);
        }
        return roles;
    }

    private UserRole readRole(ResultSet resultSet) throws SQLException {
        return UserRole.valueOf(resultSet.getString(1).toUpperCase());
    }
}
