package by.epamtc.vaskevichartsiom.finalproject.airline.domain.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class User extends BaseEntity<Long>{
    private String name;
    private String surname;
    private String username;
    private String password;
    private String email;
    private Long roleId;
    private Long rankId;
    private Set<Flight> flights = new HashSet<Flight>();

    public User() {
    }

    public User(String name, String surname, String username, String password, String email, Long roleId, Long rankId) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.roleId = roleId;
        this.rankId = rankId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getRankId() {
        return rankId;
    }

    public void setRankId(Long rankId) {
        this.rankId = rankId;
    }

    public Set<Flight> getFlights() {
        return flights;
    }

    public void setFlights(Set<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(email, user.email) && Objects.equals(roleId, user.roleId) && Objects.equals(rankId, user.rankId) && Objects.equals(flights, user.flights);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, username, password, email, roleId, rankId, flights);
    }
}
