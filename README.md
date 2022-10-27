#Game-stats-service


Overrode equals and hashcode in GameRecord entity because of usage GameRecord as key in maps in mvp method.

would be good to make private fields in GameRecord entity or remove getters.

Added 2 methods for mvp in case more than 1 player has the same max score.
getPlayersWithEqualScore returns map of players whit same max score. It might return list, but
if this method returns List, we have to create one more if-statement in next method. 

getMvpByScoreAndPasses method has the same logic as winner or mvp method