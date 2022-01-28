package by.epamtc.vaskevichartsiom.finalproject.airline.domain.enums;

public enum UserRank {
    PILOT(1),
    NAVIGATOR(2),
    RADIO_OPERATOR(3),
    STEWARDESS(4),
    WORKER(5);

    private final int id;

    UserRank(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
