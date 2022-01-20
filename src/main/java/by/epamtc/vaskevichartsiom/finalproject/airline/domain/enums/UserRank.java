package by.epamtc.vaskevichartsiom.finalproject.airline.domain.enums;

public enum UserRank {
    PILOT(1),
    NAVIGATOR(2),
    RADIO_OPERATOR(3),
    STEWARDESS(4),
    WORKER(5);

    private final int rank;

    UserRank(int rank) {
        this.rank = rank;
    }

    public static UserRank of(String rank) {
        for (UserRank value : UserRank.values()) {
            if (value.rank == Integer.parseInt(rank)) {
                return value;
            }
        }
        return WORKER;
    }
}
