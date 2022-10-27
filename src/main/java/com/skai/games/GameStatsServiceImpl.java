package com.skai.games;

import java.util.*;

public class GameStatsServiceImpl implements GameStatsService {


    @Override
    public String mvp(Collection<GameRecord> gameRecords) {

        Map<GameRecord, Integer> playerScore = new HashMap<>();

        for (GameRecord gameRecord : gameRecords) {
            if (playerScore.containsKey(gameRecord)) {
                playerScore.put(gameRecord, playerScore.get(gameRecord) + gameRecord.getScores());
            } else {
                playerScore.put(gameRecord, gameRecord.getScores());
            }
        }

        int maxScore = Collections.max(playerScore.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getValue();

        if (Collections.frequency(playerScore.values(), maxScore) == 0)
            return Collections.max(playerScore.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey().getPlayer();

        return getMvpByScoreAndPasses(playerScore, gameRecords, maxScore);

    }

    @Override
    public String winner(Collection<GameRecord> gameRecords) {

        Map<String, Integer> teamTotalScores = new HashMap<>();

        for (GameRecord gameRecord : gameRecords) {
            if (teamTotalScores.containsKey(gameRecord.getTeam())) {
                teamTotalScores.put(gameRecord.getTeam(),
                        teamTotalScores.get(gameRecord.getTeam()) + gameRecord.getScores());
            } else {
                teamTotalScores.put(gameRecord.getTeam(), gameRecord.getScores());
            }
        }

        return Collections.max(teamTotalScores.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();

    }

    private Map<GameRecord, Integer> getPlayersWithEqualScore(Map<GameRecord, Integer> playerScore, int value) {

        Map<GameRecord, Integer> playerPasses = new HashMap<>();

        for (GameRecord gameRecord : playerScore.keySet()) {
            if (playerScore.get(gameRecord) == value) {
                playerPasses.put(gameRecord, 0);
            }
        }

        return playerPasses;
    }

    private String getMvpByScoreAndPasses(Map<GameRecord, Integer> playerScore,
                                          Collection<GameRecord> gameRecords, int maxScore) {

        Map<GameRecord, Integer> playerPasses = getPlayersWithEqualScore(playerScore, maxScore);

        for (GameRecord gameRecord : gameRecords) {
            if (playerPasses.containsKey(gameRecord)) {
                playerPasses.put(gameRecord, playerPasses.get(gameRecord) + gameRecord.getPasses());
            }
        }

        return Collections.max(playerPasses.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey().getPlayer();
    }

}

