package by.epamtc.vaskevichartsiom.finalproject.airline.dao.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Destination extends BaseEntity<Integer>{
    private String airport;
    private Set<Flight> flights = new HashSet<Flight>();

    public Destination() {
    }

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public Set<Flight> getFlights() {
        return flights;
    }

    public void setFlights(Set<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Destination that = (Destination) o;
        return Objects.equals(airport, that.airport) && Objects.equals(flights, that.flights);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airport, flights);
    }
}
