package by.epamtc.vaskevichartsiom.finalproject.airline.service.impl;

import by.epamtc.vaskevichartsiom.finalproject.airline.dao.exception.DAOException;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.UserRepository;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.impl.UserRepositoryMySQL;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.User;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.UserService;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class UserServiceImpl implements UserService {

    private static final UserRepository userRepository = new UserRepositoryMySQL();
    private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);

    @Override
    public Optional<User> logIn(String email, String password) throws ServiceException {
        try {
            final Optional<User> user = userRepository.findUserByEmail(email);
            final String passwordFromRepository = user.get().getPassword();
            if (password.equals(passwordFromRepository)) {
                return user;
            } else {
                return Optional.empty();
            }
        } catch (DAOException e) {
            LOGGER.error("Find by email error", e);
            throw new ServiceException("Find by email error", e);
        }
    }

    @Override
    public Optional<User> register(User user) throws ServiceException {
        try {
            final Optional<User> alreadyExists = userRepository.findUserByEmail(user.getEmail());
            if (alreadyExists.isPresent()) {
                return Optional.empty();
            } else {
                userRepository.create(user);
                return Optional.of(user);
            }
        } catch (DAOException e) {
            LOGGER.error("register error", e);
            throw new ServiceException("register error", e);
        }

    }

    @Override
    public Optional<User> updateUser(User user) throws ServiceException {
        return Optional.empty();
    }

    @Override
    public Optional<User> deleteUser(Long id) throws ServiceException {
        return Optional.empty();
    }

    @Override
    public Optional<User> findById(Long id) throws ServiceException {
        return Optional.empty();
    }
}
