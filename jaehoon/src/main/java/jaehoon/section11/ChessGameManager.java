package jaehoon.section11;

import java.util.*;
import java.util.stream.Collectors;

public class ChessGameManager implements Iterable<Player> {

  private final Map<String, Player> players = new HashMap<>();

  // 플레이어 추가
  public void addPlayer(String name) {
    players.putIfAbsent(name, new Player(name));
  }

  // 경기 기록
  public void recordMatch(String winner, String loser) {
    if (players.containsKey(winner) && players.containsKey(loser)) {
      players.get(winner).win();
      players.get(loser).lose();
    }
  }

  // 전체 점수 조회 (점수 내림차순 정렬)
  public List<Integer> getScores() {
    return players.values().stream()
                  .sorted()
                  .map(Player::getScore)
                  .collect(Collectors.toList());
  }

  // 최고 점수 플레이어 조회
  public Optional<Player> getTopPlayer() {
    return players.values().stream()
                  .max(Comparator.comparingInt(Player::getScore));
  }

  // 승리 횟수 기준 정렬
  public List<Player> sortByWins() {
    List<Player> list = new ArrayList<>(players.values());
    list.sort(Comparator.comparingInt(Player::getWins).reversed());
    return list;
  }

  // 특정 점수 이상인 플레이어 필터링
  public List<Player> filterByScore(int minScore) {
    return players.values().stream()
                  .filter(p -> p.getScore() >= minScore)
                  .sorted()
                  .toList();
  }

  // 최고 승률 플레이어 조회
  public Optional<Player> getBestWinRatePlayer() {
    return players.values().stream()
                  .max(Comparator.comparingDouble(Player::getWinRate));
  }

  @Override
  public Iterator<Player> iterator() {
    return players.values().iterator();
  }
}
