package com.skai.games;

import java.util.Objects;

public class GameRecord {
    public String team;
    public String player;
    public int scores;
    public int passes;

    public GameRecord(String team, String player, int scores, int passes) {
        this.team = team;
        this.player = player;
        this.scores = scores;
        this.passes = passes;
    }

    public String getTeam() {
        return team;
    }

    public String getPlayer() {
        return player;
    }

    public int getScores() {
        return scores;
    }

    public int getPasses() {
        return passes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameRecord that = (GameRecord) o;
        return team.equals(that.team) && player.equals(that.player);
    }

    @Override
    public int hashCode() {
        return Objects.hash(team, player);
    }
}
