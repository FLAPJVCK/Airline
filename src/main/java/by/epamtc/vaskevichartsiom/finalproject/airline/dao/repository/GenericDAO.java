package by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository;

import java.io.Serializable;
import java.util.Optional;

public interface GenericDAO<T> {
    void create(T entity);
    void update(T entity);
    void delete(Long id);
}
