package by.epamtc.vaskevichartsiom.finalproject.airline.dao;

import by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.RankRepository;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.RoleRepository;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.impl.RankRepositoryMySQL;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.impl.RoleRepositoryMySQL;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.impl.UserRepositoryMySQL;
import by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository.UserRepository;

public class FactoryDao {
    private static final FactoryDao instance = new FactoryDao();

    private UserRepository UserDaoImpl = new UserRepositoryMySQL();

    private RankRepository RankDaoImpl = new RankRepositoryMySQL();

    private RoleRepository RoleDaoImpl = new RoleRepositoryMySQL();

    public FactoryDao() {
    }

    public static FactoryDao getInstance() {
        return instance;
    }

    public UserRepository getUserDaoImpl() {
        return UserDaoImpl;
    }

    public void setUserDaoImpl(UserRepository userDaoImpl) {
        UserDaoImpl = userDaoImpl;
    }
}
