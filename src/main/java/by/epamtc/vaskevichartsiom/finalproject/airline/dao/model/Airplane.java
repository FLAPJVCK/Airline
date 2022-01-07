package by.epamtc.vaskevichartsiom.finalproject.airline.dao.model;

import java.util.*;

public class Airplane extends BaseEntity<Integer>{
    private Integer airplaneModelId;
    private Set<AirplaneHasRank> airplaneHasRanks = new HashSet<AirplaneHasRank>();
    private Set<Flight> flights = new HashSet<Flight>();

    public Airplane() {
    }

    public Integer getAirplaneModelId() {
        return airplaneModelId;
    }

    public void setAirplaneModelId(Integer airplaneModelId) {
        this.airplaneModelId = airplaneModelId;
    }

    public Set<AirplaneHasRank> getAirplaneHasRanks() {
        return airplaneHasRanks;
    }

    public void setAirplaneHasRanks(Set<AirplaneHasRank> airplaneHasRanks) {
        this.airplaneHasRanks = airplaneHasRanks;
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
        Airplane airplane = (Airplane) o;
        return Objects.equals(airplaneModelId, airplane.airplaneModelId) && Objects.equals(airplaneHasRanks, airplane.airplaneHasRanks) && Objects.equals(flights, airplane.flights);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airplaneModelId, airplaneHasRanks, flights);
    }
}
