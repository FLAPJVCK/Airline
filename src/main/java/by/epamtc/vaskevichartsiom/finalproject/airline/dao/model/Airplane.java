package by.epamtc.vaskevichartsiom.finalproject.airline.dao.model;

import java.util.*;

public class Airplane extends BaseEntity<Integer>{
    private Set<AirplaneModel> airplaneModels = new HashSet<AirplaneModel>();

    public Airplane() {
    }

    public Set<AirplaneModel> getAirplaneModels() {
        return airplaneModels;
    }

    public void setAirplaneModels(Set<AirplaneModel> airplaneModels) {
        this.airplaneModels = airplaneModels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airplane airplane = (Airplane) o;
        return Objects.equals(airplaneModels, airplane.airplaneModels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airplaneModels);
    }
}
