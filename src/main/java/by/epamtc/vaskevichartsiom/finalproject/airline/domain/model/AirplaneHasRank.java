package by.epamtc.vaskevichartsiom.finalproject.airline.domain.model;

import java.util.Objects;

public class AirplaneHasRank extends BaseEntity<Long>{
    private Integer rankCount;
    private Long airplaneId;
    private Long rankId;

    public AirplaneHasRank() {
    }

    public Integer getRankCount() {
        return rankCount;
    }

    public void setRankCount(Integer rankCount) {
        this.rankCount = rankCount;
    }

    public Long getAirplaneId() {
        return airplaneId;
    }

    public void setAirplaneId(Long airplaneId) {
        this.airplaneId = airplaneId;
    }

    public Long getRankId() {
        return rankId;
    }

    public void setRankId(Long rankId) {
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
