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
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.model.User;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.UserService;
import by.epamtc.vaskevichartsiom.finalproject.airline.service.exception.ServiceException;
import by.epamtc.vaskevichartsiom.finalproject.airline.util.cryptography.PasswordEncryptorBCrypt;
import by.epamtc.vaskevichartsiom.finalproject.airline.util.validator.UserValidator;
import by.epamtc.vaskevichartsiom.finalproject.airline.util.validator.impl.UserValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private static final UserRepository userRepository = new UserRepositoryMySQL();
    private static final RankRepository rankRepository = new RankRepositoryMySQL();
    private static final RoleRepository roleRepository = new RoleRepositoryMySQL();
    private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);
    private final UserValidator validator = new UserValidatorImpl();

    @Override
    public Optional<User> logIn(String email, String password) throws ServiceException {
        if (!validator.isEmailValid(email) || !validator.isPasswordValid(password)) {
            throw new ServiceException("Incorrect log in data!");
        }
        Optional<User> user;
        try {
            user = userRepository.findUserByEmail(email);
            if (user.isPresent()) {
                String passwordFromRepository = user.get().getPassword();
                if (PasswordEncryptorBCrypt.getInstance().checkPassword(password, passwordFromRepository)) {
                    return user;
                }
            }
            return Optional.empty();
        } catch (DAOException e) {
            LOGGER.error("Find user by email error", e);
            throw new ServiceException("Find user by email error", e);
        }
    }

    @Override
    public Optional<User> register(User user) throws ServiceException {
        if (!validator.isNameValid(user.getName()) || !validator.isNameValid(user.getSurname())
                || !validator.isUsernameValid(user.getUsername()) || !validator.isEmailValid(user.getEmail())
                || !validator.isPasswordValid(user.getPassword())) {
            throw new ServiceException("Incorrect register data!");
        }
        try {
            Optional<User> alreadyExists = userRepository.findUserByEmail(user.getEmail());
            if (alreadyExists.isPresent()) {
                return Optional.empty();
            } else {
                user.setPassword(PasswordEncryptorBCrypt.getInstance().encryptPassword(user.getPassword()));
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
        if (!validator.isNameValid(user.getName()) || !validator.isNameValid(user.getSurname())
                || !validator.isUsernameValid(user.getUsername()) || !validator.isEmailValid(user.getEmail())) {
            throw new ServiceException("Incorrect register data!");
        }
        try {
            if (!user.getPassword().equals("")) {
                if (!validator.isPasswordValid(user.getPassword())){
                    throw new ServiceException("Incorrect password in register data!");
                }
                user.setPassword(PasswordEncryptorBCrypt.getInstance().encryptPassword(user.getPassword()));
            }
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
            return userRepository.findUserById(id);
        } catch (DAOException e) {
            LOGGER.error("Find user by id error", e);
            throw new ServiceException("Find user by id error", e);
        }
    }

    @Override
    public List<User> findAllUsers() throws ServiceException {
        try {
            return userRepository.findAllUsers();
        } catch (DAOException e) {
            LOGGER.error("findAllUsers error", e);
            throw new ServiceException("findAllUsers error", e);
        }
    }

    @Override
    public List<User> findAllUsersByRank(Long id, Date date) throws ServiceException {
        try {
            return userRepository.findAllUsersByRank(id, date);
        } catch (DAOException e) {
            LOGGER.error("findAllUsersByRank error", e);
            throw new ServiceException("findAllUsersByRank error", e);
        }
    }

    @Override
    public List<UserRank> findAllRanks() throws ServiceException {
        try {
            return rankRepository.findAllRanks();
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
