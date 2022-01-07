package by.epamtc.vaskevichartsiom.finalproject.airline.dao.repository;

import java.util.List;

public abstract class AbstractRepository <T> {
    public abstract boolean add (T t);
    public abstract boolean get();
    public abstract boolean remove(T t);
    public abstract List<T> getAll();
}
