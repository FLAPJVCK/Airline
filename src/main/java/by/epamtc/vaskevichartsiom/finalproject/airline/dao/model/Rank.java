package by.epamtc.vaskevichartsiom.finalproject.airline.dao.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Rank extends BaseEntity<Integer>{
    private String rankName;

    public Rank() {
    }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rank rank = (Rank) o;
        return Objects.equals(rankName, rank.rankName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rankName);
    }
}
