package by.epamtc.vaskevichartsiom.finalproject.airline.service.impl;

import by.epamtc.vaskevichartsiom.finalproject.airline.dao.exception.DAOException;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.RankRepository;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.RoleRepository;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.UserRepository;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.impl.RankRepositoryMySQL;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.impl.RoleRepositoryMySQL;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.impl.UserRepositoryMySQL;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.enums.UserRank;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.enums.UserRole;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Rank;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.Role;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.User;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.UserService;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private static final UserRepository userRepository = new UserRepositoryMySQL();
    private static final RankRepository rankRepository = new RankRepositoryMySQL();
    private static final RoleRepository roleRepository = new RoleRepositoryMySQL();
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
            LOGGER.error("Find user by email error", e);
            throw new ServiceException("Find user by email error", e);
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
            LOGGER.error("register user error", e);
            throw new ServiceException("register user error", e);
        }
    }

    @Override
    public void updateUser(User user) throws ServiceException {
        try {
            userRepository.update(user);
        } catch (DAOException e) {
            LOGGER.error("update user error", e);
            throw new ServiceException("update user error", e);
        }
    }

    @Override
    public void deleteUser(Long id) throws ServiceException {
        try {
            userRepository.delete(id);
        } catch (DAOException e) {
            LOGGER.error("delete user error", e);
            throw new ServiceException("delete user error", e);
        }
    }

    @Override
    public Optional<User> findById(Long id) throws ServiceException {
        try {
            final Optional<User> user = userRepository.findUserById(id);
            return user;
        } catch (DAOException e) {
            LOGGER.error("Find user by id error", e);
            throw new ServiceException("Find user by id error", e);
        }
    }

    @Override
    public List<User> findAllUsers() throws ServiceException {
        try {
            final List<User> users = userRepository.findAllUsers();
            return users;
        } catch (DAOException e) {
            LOGGER.error("getAllUsers error", e);
            throw new ServiceException("getAllUsers error", e);
        }
    }

    @Override
    public List<UserRank> findAllRanks() throws ServiceException {
        try {
            final List<UserRank> ranks = rankRepository.findAllRanks();
            return ranks;
        } catch (DAOException e) {
            LOGGER.error("findAllRanks error", e);
            throw new ServiceException("findAllRanks error", e);
        }
    }

    @Override
    public List<UserRole> findAllRoles() throws ServiceException {
        try {
            final List<UserRole> roles = roleRepository.findAllRoles();
            return roles;
        } catch (DAOException e) {
            LOGGER.error("findAllRoles error", e);
            throw new ServiceException("findAllRoles error", e);
        }
    }
}
