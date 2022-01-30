package by.epamtc.vaskevichartsiom.finalproject.airline.domain.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Manufacture extends BaseEntity<Long>{
    private String manufacturerName;
    private Set<Airplane> airplaneModels = new HashSet<Airplane>();

    public Manufacture() {
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public Set<Airplane> getAirplaneModels() {
        return airplaneModels;
    }

    public void setAirplaneModels(Set<Airplane> airplaneModels) {
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
