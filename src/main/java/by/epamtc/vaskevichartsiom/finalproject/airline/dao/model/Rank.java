package by.epamtc.vaskevichartsiom.finalproject.airline.dao.model;

import java.util.*;

public class Rank extends BaseEntity<Integer>{
    private String rankName;
    private Set<User> users = new HashSet<User>();
    private Set<AirplaneHasRank> airplaneHasRanks= new HashSet<AirplaneHasRank>();

    public Rank() {
    }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<AirplaneHasRank> getAirplaneHasRanks() {
        return airplaneHasRanks;
    }

    public void setAirplaneHasRanks(Set<AirplaneHasRank> airplaneHasRanks) {
        this.airplaneHasRanks = airplaneHasRanks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rank rank = (Rank) o;
        return Objects.equals(rankName, rank.rankName) && Objects.equals(users, rank.users) && Objects.equals(airplaneHasRanks, rank.airplaneHasRanks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rankName, users, airplaneHasRanks);
    }
}
