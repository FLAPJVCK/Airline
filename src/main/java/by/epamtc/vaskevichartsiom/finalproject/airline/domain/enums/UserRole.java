package by.epamtc.vaskevichartsiom.finalproject.airline.domain.enums;

public enum UserRole {
    ADMIN(1),
    MANAGER(2),
    WORKER(3);

    private final int role;

    UserRole(int role) {
        this.role = role;
    }

    public static UserRole of(String role) {
        for (UserRole value : UserRole.values()) {
            if (value.role == Integer.parseInt(role)) {
                return value;
            }
        }
        return WORKER;
    }
}
