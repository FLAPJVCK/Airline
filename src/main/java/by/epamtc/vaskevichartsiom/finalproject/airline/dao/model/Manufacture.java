package by.epamtc.vaskevichartsiom.finalproject.airline.dao.model;

import java.util.Objects;

public class Manufacture extends BaseEntity<Integer>{
    private String name;

    public Manufacture() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manufacture that = (Manufacture) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
