package by.epamtc.vaskevichartsiom.finalproject.airline.domain.enums;

public enum FlightStatus {
    NOT_READY(1),
    READY(2),
    COMPLETED(3);

    private final int status;

    FlightStatus(int status) {
        this.status = status;
    }

    public static FlightStatus of(String status) {
        for (FlightStatus value : FlightStatus.values()) {
            if (value.status == Integer.parseInt(status)) {
                return value;
            }
        }
        return NOT_READY;
    }
}
