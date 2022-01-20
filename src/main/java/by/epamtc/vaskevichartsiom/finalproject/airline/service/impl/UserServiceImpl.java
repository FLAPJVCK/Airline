package by.epamtc.vaskevichartsiom.finalproject.airline.service.impl;

import by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.UserRepository;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.impl.UserRepositoryMySQL;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.User;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.UserService;

import java.util.Optional;

public class UserServiceImpl implements UserService {

    private static final UserRepository userRepository = new UserRepositoryMySQL();

    @Override
    public Optional<User> logIn(String email, String password) {
        final Optional<User> user = userRepository.findUserByEmail(email);
        final String passwordFromRepository = user.get().getPassword();
        if (password.equals(passwordFromRepository)) {
            return user;
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> register(User user) {
        final Optional<User> alreadyExists = userRepository.findUserByEmail(user.getEmail());
        if (alreadyExists.isPresent()) {
            return Optional.empty();
        } else {
            userRepository.create(user);
            return Optional.of(user);
        }
    }

    @Override
    public Optional<User> updateUser(User user) {
        return Optional.empty();
    }

    @Override
    public Optional<User> deleteUser(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }
}
