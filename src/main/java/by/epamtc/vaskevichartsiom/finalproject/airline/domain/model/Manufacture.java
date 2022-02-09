package by.epamtc.vaskevichartsiom.finalproject.airline.domain.model;

import java.util.Objects;

public class Manufacture extends BaseEntity<Long> {
    private String manufacturerName;

    public Manufacture() {
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manufacture that = (Manufacture) o;
        return Objects.equals(manufacturerName, that.manufacturerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturerName);
    }
}
