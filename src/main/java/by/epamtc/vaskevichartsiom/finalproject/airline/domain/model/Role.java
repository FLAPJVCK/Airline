package by.epamtc.vaskevichartsiom.finalproject.airline.domain.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Role extends BaseEntity<Long>{
    private String roleName;
    private Set<User> users = new HashSet<User>();

    public Role() {
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(roleName, role.roleName) && Objects.equals(users, role.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleName, users);
    }
}
