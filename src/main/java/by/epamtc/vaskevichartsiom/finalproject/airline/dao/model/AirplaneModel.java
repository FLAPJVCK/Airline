package by.epamtc.vaskevichartsiom.finalproject.airline.dao.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class AirplaneModel extends BaseEntity<Integer>{
    private String model;
    private Integer businessSeat;
    private Integer economySeat;
    private Integer maximumTakeoffWeight;
    private Integer flightRange;
    private Integer cruisingSpeed;
    private Integer maximumFlightHeight;
    private Set<Manufacture> manufactures = new HashSet<Manufacture>();

    public AirplaneModel() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getBusinessSeat() {
        return businessSeat;
    }

    public void setBusinessSeat(Integer businessSeat) {
        this.businessSeat = businessSeat;
    }

    public Integer getEconomySeat() {
        return economySeat;
    }

    public void setEconomySeat(Integer economySeat) {
        this.economySeat = economySeat;
    }

    public Integer getMaximumTakeoffWeight() {
        return maximumTakeoffWeight;
    }

    public void setMaximumTakeoffWeight(Integer maximumTakeoffWeight) {
        this.maximumTakeoffWeight = maximumTakeoffWeight;
    }

    public Integer getFlightRange() {
        return flightRange;
    }

    public void setFlightRange(Integer flightRange) {
        this.flightRange = flightRange;
    }

    public Integer getCruisingSpeed() {
        return cruisingSpeed;
    }

    public void setCruisingSpeed(Integer cruisingSpeed) {
        this.cruisingSpeed = cruisingSpeed;
    }

    public Integer getMaximumFlightHeight() {
        return maximumFlightHeight;
    }

    public void setMaximumFlightHeight(Integer maximumFlightHeight) {
        this.maximumFlightHeight = maximumFlightHeight;
    }

    public Set<Manufacture> getManufactures() {
        return manufactures;
    }

    public void setManufactures(Set<Manufacture> manufactures) {
        this.manufactures = manufactures;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AirplaneModel that = (AirplaneModel) o;
        return Objects.equals(model, that.model) && Objects.equals(businessSeat, that.businessSeat) && Objects.equals(economySeat, that.economySeat) && Objects.equals(maximumTakeoffWeight, that.maximumTakeoffWeight) && Objects.equals(flightRange, that.flightRange) && Objects.equals(cruisingSpeed, that.cruisingSpeed) && Objects.equals(maximumFlightHeight, that.maximumFlightHeight) && Objects.equals(manufactures, that.manufactures);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, businessSeat, economySeat, maximumTakeoffWeight, flightRange, cruisingSpeed, maximumFlightHeight, manufactures);
    }
}
