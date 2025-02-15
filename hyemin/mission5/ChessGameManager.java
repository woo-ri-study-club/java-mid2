package mission5;

import java.util.*;

public class ChessGameManager implements Iterable<Player> {
    private Map<String, Player> players;

    public ChessGameManager() {
        players = new HashMap<>();
    }

    public void addPlayer(String name) {
        players.put(name, new Player(name));
    }

    public void recordMatch(String winnerName, String loserName) {
        Player winner = players.get(winnerName);
        Player loser = players.get(loserName);

        if (winner != null && loser != null) {
            winner.win();
            loser.lose();
        }
    }

    public List<Player> getScores() {
        List<Player> playerList = new ArrayList<>(players.values());
        playerList.sort(null);
        return playerList;
    }

    public List<Player> sortByWins() {
        List<Player> playerList = new ArrayList<>(players.values());
        playerList.sort(Comparator.comparingInt(Player::getWins).reversed());
        return playerList;
    }

    public Player getTopPlayer() {
        return players.values().stream()
                .max(Comparator.comparingInt(Player::getScore)).orElse(null);
    }

    public Iterator<Player> iterator() {
        return players.values().iterator();
    }

    public List<Player> filterByScore(int minScore) {
        List<Player> filtered = new ArrayList<>();
        for (Player player : players.values()) {
            if (player.getScore() >= minScore) {
                filtered.add(player);
            }
        }
        return filtered;
    }

    public Player getBestWinRatePlayer() {
        return Collections.max(players.values(), Comparator.comparingDouble(p -> {
            int totalGames = p.getWins() + p.getLosses();
            if(totalGames == 0){
                return 0;
            }
            return (double) p.getWins() / totalGames;
        }));
    }
}

