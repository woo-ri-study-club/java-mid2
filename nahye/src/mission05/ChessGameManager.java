package mission05;

import java.util.*;

public class ChessGameManager implements Iterable<Player> {

    private Map<String, Player> players = new HashMap<>();
    private final List<String> matchHistory = new ArrayList<>();

    public void addPlayer(String name) {
        players.put(name, new Player(name));
    }

    public void recordMatch(String winnerName, String loserName) {
        if (winnerName.equals(loserName)) {
            throw new IllegalArgumentException("승자와 패자가 동일할 수 없습니다.");
        }
        if (!players.containsKey(winnerName) || !players.containsKey(loserName)) {
            throw new IllegalArgumentException("존재하지 않는 플레이어입니다.");
        }
        Player winner = players.get(winnerName);
        Player loser = players.get(loserName);

        winner.recordWin();
        loser.recordLoss();
        matchHistory.add(winnerName);
        matchHistory.add(loserName);
    }

    public void printScores() {
         players.values().stream()
                 .sorted(Player::compareTo)
                 .forEach(p->
                         System.out.println(p.getName()+" : "+p.getScore())
                 );
    }

    public List<Player> sortByWins() {
        return players.values().stream()
                .sorted(Comparator
                        .comparingInt(Player::getWins)
                        .reversed())
                .toList();
    }

    public int getMatchCount(String playerName) {
        return Collections.frequency(matchHistory, playerName);
    }

    public Optional<Player> getTopPlayer() {
        if (players.isEmpty()) {
            return Optional.empty();
        }
        Player topPlayer = Collections.max(players.values(), Comparator.comparingInt(Player::getScore));
        return Optional.of(topPlayer);
    }

    public void displayBestWinRatePlayer(){
        players.values().stream()
                .max(Comparator.comparingDouble(player -> {
                    int totalGames = player.getWins() + player.getLosses();
                    return totalGames > 0 ? (double) player.getWins() / totalGames : 0;
                }))
                .ifPresentOrElse(
                        p -> System.out.println(p),
                        ()-> {
                            throw new IllegalArgumentException("해당 플레이어가 없습니다.");
                        }
                );
    }

    public List<Player> filterByScore(int minScore){
        return players.values().stream()
                .filter(player -> player.getScore() > minScore)
                .sorted(Player::compareTo)
                .toList();
    }

    @Override
    public Iterator<Player> iterator() {
        return players.values().iterator();
    }
}
