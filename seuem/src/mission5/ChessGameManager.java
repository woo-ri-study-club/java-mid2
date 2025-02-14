import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ChessGameManager {
    List<Player> players = new ArrayList<>();

    public void addPlayer(String name) {
        players.add(new Player(name));
    }

    public void recordMatch(String winner, String loser) {
        for (Player player : players) {
            if (player.getName().equals(winner)) {
                player.wins();
                continue;
            }
            if (player.getName().equals(loser)) {
                player.loses();
            }
        }
    }


    public void getScores() {
        players.sort(null);
        System.out.println("players = " + players);

    }

    public void getTopPlayer() {
        players.stream().max(Comparator.comparing(Player::getScore)).ifPresent(System.out::println);
    }

    public void sortByWins() {
        players.sort(Comparator.comparing(Player::getWins).reversed());
        System.out.println("players = " + players);

    }
}
