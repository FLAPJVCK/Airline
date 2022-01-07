package by.epamtc.vaskevichartsiom.finalproject.airline.dao.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class AirplaneHasRank extends BaseEntity<Integer>{
    private Integer rankCount;
    private Set<Airplane> airplanes = new HashSet<Airplane>();
    private Set<Rank> ranks = new HashSet<Rank>();

    public AirplaneHasRank() {
    }

    public Integer getRankCount() {
        return rankCount;
    }

    public void setRankCount(Integer rankCount) {
        this.rankCount = rankCount;
    }

    public Set<Airplane> getAirplanes() {
        return airplanes;
    }

    public void setAirplanes(Set<Airplane> airplanes) {
        this.airplanes = airplanes;
    }

    public Set<Rank> getRanks() {
        return ranks;
    }

    public void setRanks(Set<Rank> ranks) {
        this.ranks = ranks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AirplaneHasRank that = (AirplaneHasRank) o;
        return Objects.equals(rankCount, that.rankCount) && Objects.equals(airplanes, that.airplanes) && Objects.equals(ranks, that.ranks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rankCount, airplanes, ranks);
    }
}
