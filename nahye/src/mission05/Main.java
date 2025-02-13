package mission05;

import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ChessGameManager game = new ChessGameManager();
        game.addPlayer("Alice");
        game.addPlayer("Bob");
        game.addPlayer("Charlie");

        game.recordMatch("Alice", "Bob");
        game.recordMatch("Charlie", "Alice");
        game.recordMatch("Alice", "Charlie");

        System.out.println("📌 전체 점수 목록 (내림차순) ");
        List<Player> scores = game.getScores();
        for (Player p : scores) {
            System.out.println(p);
        }

        System.out.println("📌 승리 횟수 기준 정렬");
        List<Player> players = game.sortByWins();
        for (Player player : players) {
            System.out.println(player);
        }

        System.out.println("📌 1000점 이상 기준 정렬");
        List<Player> filterByScore = game.filterByScore(1000);
        for (Player player : filterByScore) {
            System.out.println(player);
        }

        System.out.println("📌 최고 점수 플레이어");
        System.out.println(game.getTopPlayer());

        System.out.println("📌 최고 승률 플레이어");
        Player bestWinRatePlayer = game.getBestWinRatePlayer();
        System.out.println(bestWinRatePlayer);

        System.out.println("📌 Alice의 총 경기 횟수");
        int AliceMatchCount = game.getMatchCount("Alice");
        System.out.println(AliceMatchCount);
    }
}
