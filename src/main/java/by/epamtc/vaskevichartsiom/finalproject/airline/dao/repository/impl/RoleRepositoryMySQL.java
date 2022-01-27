package by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.impl;

import by.epamtc.vaskevichartsiom.finalproject.airline.dao.exception.DAOException;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.RoleRepository;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Role;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class RoleRepositoryMySQL implements RoleRepository {
    private final static String INSERT_ROLE = "INSERT into airline.roles(role_name) values (?)";
    private final static String UPDATE_ROLE = "UPDATE airline.roles SET role_name = ? WHERE id = ?";
    private final static String DELETE_ROLE = "DELETE FROM airline.roles WHERE id = ?";
    private static final String FIND_ROLE_BY_NAME = "SELECT * FROM airline.roles WHERE role_name = ?";


    @Override
    public void create(Role entity) throws DAOException {

    }

    @Override
    public void update(Role entity) throws DAOException {

    }

    @Override
    public void delete(Long id) throws DAOException {

    }

    @Override
    public Optional<Role> findRoleByName(String name) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try  {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(FIND_ROLE_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Role role = readRole(resultSet);
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

    private Role readRole(ResultSet resultSet) throws SQLException {
        Role currentRole = new Role();
        currentRole.setId(resultSet.getLong(1));
        currentRole.setRoleName(resultSet.getString(2));
        return currentRole;
    }
}
