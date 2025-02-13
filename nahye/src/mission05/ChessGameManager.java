package mission05;

import java.util.*;

public class ChessGameManager implements Iterable<Player> {

    private final List<Player> playerList = new ArrayList<>();
    private final List<String> matchHistory = new ArrayList<>();

    public void addPlayer(String name) {
        Player newPlayer = new Player(name);
        playerList.add(newPlayer);
    }

    public void recordMatch(String winnerName, String loserName) {
        Player winner = findPlayer(winnerName);
        Player loser = findPlayer(loserName);

        if (winner == null || loser == null) {
            throw new IllegalArgumentException(
                    String.format("플레이어를 찾을 수 없습니다. winner: %s, loser: %s",
                            winnerName, loserName));
        }
        if (winner.equals(loser)) {
            throw new IllegalArgumentException("승자와 패자가 동일할 수 없습니다.");
        }

        winner.recordWin();
        loser.recordLoss();
        matchHistory.add(winnerName);
        matchHistory.add(loserName);
    }

    public List<Player> getScores() {
        return playerList.stream()
                .sorted(Player::compareTo)
                .toList();
    }

    public List<Player> sortByWins() {
        return playerList.stream()
                .sorted(Comparator
                        .comparingInt(Player::getWins)
                        .reversed())
                .toList();
    }

    public int getMatchCount(String playerName) {
        return Collections.frequency(matchHistory, playerName);
    }

    public Player getTopPlayer() {
        return Collections.max(playerList, Comparator.comparingInt(Player::getScore));
    }

    public Player getBestWinRatePlayer(){
        return playerList.stream()
                .max(Comparator.comparingDouble(player -> {
                    int totalGames = player.getWins() + player.getLosses();
                    return totalGames > 0 ? (double) player.getWins() / totalGames : 0;
                }))
                .orElse(null);
    }

    public List<Player> filterByScore(int minScore){
        return playerList.stream()
                .filter(player -> player.getScore() > minScore)
                .toList();
    }

    private Player findPlayer(String name) {
        return playerList.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Iterator<Player> iterator() {
        return new ChessPlayerIterator();
    }

    public class ChessPlayerIterator implements Iterator<Player> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < playerList.size();
        }

        @Override
        public Player next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return playerList.get(currentIndex++);
        }
    }
}
