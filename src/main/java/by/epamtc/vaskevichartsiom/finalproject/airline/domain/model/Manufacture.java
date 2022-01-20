package by.epamtc.vaskevichartsiom.finalproject.airline.domain.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Manufacture extends BaseEntity<Long>{
    private String manufacturerName;
    private Set<AirplaneModel> airplaneModels = new HashSet<AirplaneModel>();

    public Manufacture() {
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
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
        Manufacture that = (Manufacture) o;
        return Objects.equals(manufacturerName, that.manufacturerName) && Objects.equals(airplaneModels, that.airplaneModels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturerName, airplaneModels);
    }
}
