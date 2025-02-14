import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ChessGameManager implements Iterable<Player> {

    Map<String, Player> players = new HashMap<>();

    public void addPlayer(String name) {
        players.put(name, new Player(name));
    }

    public void recordMatch(String winner, String loser) {
        if (winner.equals(loser)) {
            System.out.println("승자와 패자가 같을 수 없습니다.");
            return;
        }
        if (players.containsKey(winner) && players.containsKey(loser)) {
            players.get(winner).wins();
            players.get(loser).loses();
        }

    }

    public void sortByWins() {
        List<Player> sortWinners = new ArrayList<>(players.values());
        sortWinners.sort(Comparator.comparing(Player::getWins).reversed());
        System.out.println("players = " + sortWinners);
    }

    public void getScores() {
        List<Player> scoreList = new ArrayList<>(players.values());
        scoreList.sort(null);
        System.out.println("players = " + scoreList);
    }

    public void getTopPlayer() {
        players.values().stream().max(Comparator.comparing(Player::getScore)).ifPresent(System.out::println);
    }

    @Override
    public Iterator<Player> iterator() {
        return players.values().iterator();
    }
}
