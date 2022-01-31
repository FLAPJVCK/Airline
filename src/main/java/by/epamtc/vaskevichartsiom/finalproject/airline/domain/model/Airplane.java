package by.epamtc.vaskevichartsiom.finalproject.airline.domain.model;

import java.util.Objects;

public class Airplane extends BaseEntity<Long>{
    private String model;
    private Integer businessSeat;
    private Integer economySeat;
    private Integer maximumTakeoffWeight;
    private Integer flightRange;
    private Integer cruisingSpeed;
    private Integer maximumFlightHeight;
    private Manufacture manufacturer;

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

    public Manufacture getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacture manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airplane airplane = (Airplane) o;
        return Objects.equals(model, airplane.model) && Objects.equals(businessSeat, airplane.businessSeat) && Objects.equals(economySeat, airplane.economySeat) && Objects.equals(maximumTakeoffWeight, airplane.maximumTakeoffWeight) && Objects.equals(flightRange, airplane.flightRange) && Objects.equals(cruisingSpeed, airplane.cruisingSpeed) && Objects.equals(maximumFlightHeight, airplane.maximumFlightHeight) && Objects.equals(manufacturer, airplane.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, businessSeat, economySeat, maximumTakeoffWeight, flightRange, cruisingSpeed, maximumFlightHeight, manufacturer);
    }
}
