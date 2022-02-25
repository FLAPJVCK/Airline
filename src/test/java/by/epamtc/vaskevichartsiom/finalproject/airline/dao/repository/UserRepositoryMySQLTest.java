package by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository;

import by.epamtc.vaskevichartsiom.finalproject.airline.dao.exception.DAOException;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.impl.UserRepositoryMySQL;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class UserRepositoryMySQLTest {
    @Test
    public void findUserByEmailTest_True() throws DAOException {
        String email = "admin@gmail.com";
        String actualName = "Admin";
        Optional<User> expectedUser = new UserRepositoryMySQL().findUserByEmail(email);
        expectedUser.ifPresent(user -> Assertions.assertEquals(actualName, user.getName()));
    }

    @Test
    public void findUserByEmailTest_False() throws DAOException {
        String email = "admin@gmail.com";
        String actualName = "admin";
        Optional<User> expectedUser = new UserRepositoryMySQL().findUserByEmail(email);
        expectedUser.ifPresent(user -> Assertions.assertNotEquals(actualName, user.getName()));
    }

    @Test
    public void findUserByIdTest_True() throws DAOException {
        Long id = 1L;
        String actualName = "Admin";
        Optional<User> expectedUser = new UserRepositoryMySQL().findUserById(id);
        expectedUser.ifPresent(user -> Assertions.assertEquals(actualName, user.getName()));
    }

    @Test
    public void findUserByIdTest_False() throws DAOException {
        Long id = 1L;
        String actualName = "admin";
        Optional<User> expectedUser = new UserRepositoryMySQL().findUserById(id);
        expectedUser.ifPresent(user -> Assertions.assertNotEquals(actualName, user.getName()));
    }
}
