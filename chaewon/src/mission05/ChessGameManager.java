package mission05;

import java.util.*;

public class ChessGameManager implements Iterable<Player> {
    private final List<Player> players;
    private final List<String> winners;

    public ChessGameManager() {
        this.players = new ArrayList<>();
        this.winners = new ArrayList<>();
    }

    public void addPlayer(String name) {
        players.add(new Player(name));
    }

    public void recordMatch(String winnerName, String loserName) {
        Player winner = findPlayer(winnerName);
        Player loser = findPlayer(loserName);

        isWinnerAndLoserSame(winner, loser);

        winner.win();
        loser.lose();

        winners.add(winner.getName());
    }

    public List<Player> getScores() {
        return players.stream().sorted().toList();
    }

    public void sortByWins() {
        players.sort(Comparator.comparingInt(Player::getWins).reversed());
    }

    public Player getTopPlayer() {
        return players.stream().max(Comparator.comparingInt(Player::getScore)).orElseThrow(() -> new IllegalArgumentException("탑 플레이어가 존재하지 않습니다."));
    }

    public int numOfMatches(String name) {
        return Collections.frequency(winners, name);
    }

    public List<Player> filterByScore(int minScore) {
        return players.stream().filter(player -> player.getScore() >= minScore).toList();
    }

    public Player getBestWiniRatePlayer() {
        return players.stream().max(Comparator.comparingDouble(Player::getWinRate)).orElseThrow(() -> new IllegalArgumentException("최고 승률 플레이어가 존재하지 않습니다."));
    }

    @Override
    public Iterator<Player> iterator() {
        return players.iterator();
    }

    private Player findPlayer(String name) {
        return players.stream()
                .filter(player -> name.equals(player.getName()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 플레이어입니다."));
    }


    private void isWinnerAndLoserSame(Player winner, Player loser) {
        if (winner.equals(loser)) {
            throw new IllegalArgumentException("승자와 패자가 동일할 수 없습니다.");
        }
    }
}