package com.skai.games;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.List;

public class GameRecordStatsServiceImplTest {

    private final GameStatsServiceImpl gameStatsService = new GameStatsServiceImpl();


    private final Collection<GameRecord> gameRecords = List.of(
            new GameRecord("New York Rangers", "Zibanezhad", 2, 1),
            new GameRecord("New York Rangers", "Zibanezhad", 2, 1),
            new GameRecord("New York Rangers", "Zibanezhad", 2, 1),
            new GameRecord("Boston Bruins", "Marchan", 2, 1),
            new GameRecord("Boston Bruins", "Pastrniak", 5, 1)
    );

    private final Collection<GameRecord> gameRecords2 = List.of(
            new GameRecord("New York Rangers", "Zibanezhad", 2, 1),
            new GameRecord("New York Rangers", "Zibanezhad", 2, 1),
            new GameRecord("Boston Bruins", "Zibanezhad", 5, 1),
            new GameRecord("Boston Bruins", "Pastrniak", 6, 1)
    );

    private final Collection<GameRecord> gameRecords3 = List.of(
            new GameRecord("New York Rangers", "Zibanezhad", 2, 1),
            new GameRecord("Boston Bruins", "Marchan", 5, 1),
            new GameRecord("Boston Bruins", "Pastrniak", 5, 2)
    );

    @Test
    public void winner() {
        Assert.assertEquals("Boston Bruins", gameStatsService.winner(gameRecords));
        Assert.assertEquals("Boston Bruins", gameStatsService.winner(gameRecords2));
        Assert.assertEquals("Boston Bruins", gameStatsService.winner(gameRecords3));

    }

    @Test
    public void mvp() {
        Assert.assertEquals("Zibanezhad", gameStatsService.mvp(gameRecords));
        Assert.assertEquals("Pastrniak", gameStatsService.mvp(gameRecords2));
        Assert.assertEquals("Pastrniak", gameStatsService.mvp(gameRecords3));
    }

}


