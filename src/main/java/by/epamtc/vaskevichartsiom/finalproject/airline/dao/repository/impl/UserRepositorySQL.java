package by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.impl;

import by.epamtc.vaskevichartsiom.finalproject.airline.dao.ConnectionPool;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.UserRepository;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.model.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRepositorySQL implements UserRepository {
    private final static String INSERT_USER = "insert into airline.users(name,surname,username,password,email,role_id,rank_id) values (?,?,?,?,?,?,?)";

    @Override
    public boolean register(User user) {
        boolean result = false;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = ConnectionPool.getInstance().getConnection().prepareStatement(INSERT_USER);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setString(6, "1");
            preparedStatement.setString(7, "1");
            result = preparedStatement.execute();;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean login() {
        return false;
    }
}
