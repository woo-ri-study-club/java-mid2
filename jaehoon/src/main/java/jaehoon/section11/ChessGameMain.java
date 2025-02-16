package jaehoon.section11;

import java.util.List;
import java.util.Optional;

public class ChessGameMain {

  public static void main(String[] args) {
    ChessGameManager game = new ChessGameManager();

    // 플레이어 추가
    game.addPlayer("성기훈");
    game.addPlayer("타노스");
    game.addPlayer("김민수");

    // 경기 기록
    game.recordMatch("타노스", "성기훈");
    game.recordMatch("김민수", "타노스");
    game.recordMatch("타노스", "김민수");

    // 전체 점수 조회
    System.out.println("📌 전체 점수 목록");
    List<Integer> scores = game.getScores();// 점수 내림차순 정렬된 목록 출력
    System.out.println(scores);

    // 최고 점수 플레이어 조회
    System.out.println("📌 최고 점수 플레이어");
    Optional<Player> topPlayer = game.getTopPlayer();
    topPlayer.ifPresentOrElse(
        System.out::println,
        () -> System.out.println("최고 점수 플레이어가 없습니다.")
    );

    // 승리 횟수 기준 정렬
    System.out.println("📌 승리 횟수 기준 정렬");
    List<Player> sortByWinPlayers = game.sortByWins();
    System.out.println(sortByWinPlayers);

    // 특정 점수 이상 필터링
    System.out.println("📌 1000점 이상인 플레이어 필터링");
    List<Player> players = game.filterByScore(1000);
    System.out.println(players);

    // 최고 승률 플레이어 조회
    System.out.println("📌 최고 승률 플레이어");
    Optional<Player> bestWinRatePlayer = game.getBestWinRatePlayer();
    bestWinRatePlayer.ifPresentOrElse(
        System.out::println,
        () -> System.out.println("최고 승률 플레이어가 없습니다.")
    );

    // for-each문을 통한 순회
    System.out.println("📌 for-each문 순회");
    for (Player player : game) {
      System.out.println(player);
    }
  }
}
