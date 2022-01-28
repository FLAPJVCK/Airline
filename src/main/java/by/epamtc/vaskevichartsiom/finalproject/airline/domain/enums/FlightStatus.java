package by.epamtc.vaskevichartsiom.finalproject.airline.domain.enums;

public enum FlightStatus {
    NOT_READY(1),
    READY(2),
    COMPLETED(3);

    private final int id;

    FlightStatus(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
