package by.epamtc.vaskevichartsiom.finalproject.airline.domain.model;

import by.epamtc.vaskevichartsiom.finalproject.airline.domain.enums.FlightStatus;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

public class Flight extends BaseEntity<Long> {
    private String flightNumber;
    private Date departureDate;
    private Time departureTime;
    private Destination destination;
    private FlightStatus flightStatus;
    private Airplane airplane;

    public Flight() {
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public FlightStatus getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(FlightStatus flightStatus) {
        this.flightStatus = flightStatus;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(flightNumber, flight.flightNumber) && Objects.equals(departureDate, flight.departureDate) && Objects.equals(departureTime, flight.departureTime) && Objects.equals(destination, flight.destination) && flightStatus == flight.flightStatus && Objects.equals(airplane, flight.airplane);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightNumber, departureDate, departureTime, destination, flightStatus, airplane);
    }
}
