package by.epamtc.vaskevichartsiom.finalproject.airline.domain.model;

import by.epamtc.vaskevichartsiom.finalproject.airline.domain.enums.UserRank;

import java.util.Objects;

public class AirplaneHasRank extends BaseEntity<Long> {
    private Integer rankCount;
    private Airplane airplane;
    private UserRank userRank;

    public AirplaneHasRank() {
    }

    public Integer getRankCount() {
        return rankCount;
    }

    public void setRankCount(Integer rankCount) {
        this.rankCount = rankCount;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public UserRank getUserRank() {
        return userRank;
    }

    public void setUserRank(UserRank userRank) {
        this.userRank = userRank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AirplaneHasRank that = (AirplaneHasRank) o;
        return Objects.equals(rankCount, that.rankCount) && Objects.equals(airplane, that.airplane) && userRank == that.userRank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rankCount, airplane, userRank);
    }
}
