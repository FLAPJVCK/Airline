package by.epamtc.vaskevichartsiom.finalproject.airline.domain.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Airplane extends BaseEntity<Long>{
    private String model;
    private Integer businessSeat;
    private Integer economySeat;
    private Integer maximumTakeoffWeight;
    private Integer flightRange;
    private Integer cruisingSpeed;
    private Integer maximumFlightHeight;
    private Long manufacturerId;
    private Set<AirplaneHasRank> airplanes = new HashSet<AirplaneHasRank>();

    public Airplane() {
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

    public Long getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public Set<AirplaneHasRank> getAirplanes() {
        return airplanes;
    }

    public void setAirplanes(Set<AirplaneHasRank> airplanes) {
        this.airplanes = airplanes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airplane that = (Airplane) o;
        return Objects.equals(model, that.model) && Objects.equals(businessSeat, that.businessSeat) && Objects.equals(economySeat, that.economySeat) && Objects.equals(maximumTakeoffWeight, that.maximumTakeoffWeight) && Objects.equals(flightRange, that.flightRange) && Objects.equals(cruisingSpeed, that.cruisingSpeed) && Objects.equals(maximumFlightHeight, that.maximumFlightHeight) && Objects.equals(manufacturerId, that.manufacturerId) && Objects.equals(airplanes, that.airplanes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, businessSeat, economySeat, maximumTakeoffWeight, flightRange, cruisingSpeed, maximumFlightHeight, manufacturerId, airplanes);
    }
}
