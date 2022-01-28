package by.epamtc.vaskevichartsiom.finalproject.airline.domain.enums;

public enum UserRole {
    ADMIN(1),
    MANAGER(2),
    WORKER(3);

    private final int id;

    UserRole(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
