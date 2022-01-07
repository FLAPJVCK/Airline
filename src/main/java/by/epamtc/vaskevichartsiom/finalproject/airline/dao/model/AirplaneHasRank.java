package by.epamtc.vaskevichartsiom.finalproject.airline.dao.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class AirplaneHasRank extends BaseEntity<Integer>{
    private Integer rankCount;
    private Integer airplaneId;
    private Integer rankId;

    public AirplaneHasRank() {
    }

    public Integer getRankCount() {
        return rankCount;
    }

    public void setRankCount(Integer rankCount) {
        this.rankCount = rankCount;
    }

    public Integer getAirplaneId() {
        return airplaneId;
    }

    public void setAirplaneId(Integer airplaneId) {
        this.airplaneId = airplaneId;
    }

    public Integer getRankId() {
        return rankId;
    }

    public void setRankId(Integer rankId) {
        this.rankId = rankId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AirplaneHasRank that = (AirplaneHasRank) o;
        return Objects.equals(rankCount, that.rankCount) && Objects.equals(airplaneId, that.airplaneId) && Objects.equals(rankId, that.rankId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rankCount, airplaneId, rankId);
    }
}
