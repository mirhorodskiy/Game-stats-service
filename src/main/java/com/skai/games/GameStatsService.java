package com.skai.games;

import java.util.Collection;

public interface GameStatsService {

    /**
     * MVP player name - player with best stats
     * @param gameRecords
     * @return
     */
    String mvp(Collection<GameRecord> gameRecords);

    /**
     * Game winner team name
     * @param gameRecords
     * @return
     */
    String winner(Collection<GameRecord> gameRecords);

}
