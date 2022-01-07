package by.epamtc.vaskevichartsiom.finalproject.airline.dao.model;

import java.util.Objects;

public class Destination extends BaseEntity<Integer>{
    private String airport;

    public Destination() {
    }

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Destination that = (Destination) o;
        return Objects.equals(airport, that.airport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airport);
    }
}
