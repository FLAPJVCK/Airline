package by.epamtc.vaskevichartsiom.finalproject.airline.service;

import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> logIn(String email, String password);

    Optional<User> register(User user);

    Optional<User> updateUser(User user);

    Optional<User> deleteUser(Long id);

    Optional<User> findById(Long id);
}
