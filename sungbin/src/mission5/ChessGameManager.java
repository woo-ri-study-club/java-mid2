package mission5;

import java.util.*;

public class ChessGameManager implements Iterable<Player> {

    private final List<Player> players;

    public ChessGameManager() {
        this.players = new ArrayList<>();
    }

    public void addPlayer(String name) {
        players.add(new Player(name));
    }

    public void recordMatch(String winnerName, String loserName) {
        Player winner = findPlayer(winnerName);
        Player loser = findPlayer(loserName);

        if (winner != null && loser != null) {
            winner.win();
            loser.lose();
        }
    }

    public void getScores() {
        Collections.sort(players);
        for (Player p : players) {
            System.out.println(p);
        }
    }

    public void getTopPlayer() {
        Optional<Player> topPlayer = players.stream().max(Comparator.comparingInt(Player::getScore));
        topPlayer.ifPresent(player -> System.out.println("🏆 Top Player: " + player));
    }

    public void sortByWins() {
        players.sort(Comparator.comparingInt(Player::getWins).reversed());
        getScores();
    }

    private Player findPlayer(String name) {
        return players.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Iterator<Player> iterator() {
        return players.iterator();
    }
}
