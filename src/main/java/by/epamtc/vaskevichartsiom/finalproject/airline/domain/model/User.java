package by.epamtc.vaskevichartsiom.finalproject.airline.domain.model;

import by.epamtc.vaskevichartsiom.finalproject.airline.domain.enums.UserRank;
import by.epamtc.vaskevichartsiom.finalproject.airline.domain.enums.UserRole;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class User extends BaseEntity<Long>{
    private String name;
    private String surname;
    private String username;
    private String password;
    private String email;
    private UserRole userRole;
    private UserRank userRank;
    private Set<Flight> flights = new HashSet<Flight>();

    public User() {
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

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public UserRank getUserRank() {
        return userRank;
    }

    public void setUserRank(UserRank userRank) {
        this.userRank = userRank;
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
        return Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(email, user.email) && userRole == user.userRole && userRank == user.userRank && Objects.equals(flights, user.flights);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, username, password, email, userRole, userRank, flights);
    }
}
