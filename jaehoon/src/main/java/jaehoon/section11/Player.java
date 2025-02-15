package jaehoon.section11;

import java.util.Objects;

public class Player implements Comparable<Player> {

  private String name;

  private int wins;

  private int losses;

  private int score;

  public Player(String name) {
    this.name = name;
    this.score = 1000;
  }

  public String getName() {
    return name;
  }

  public int getWins() {
    return wins;
  }

  public int getLosses() {
    return losses;
  }

  public int getScore() {
    return score;
  }

  public void win() {
    wins++;
    score += 50;
  }

  public void lose() {
    losses++;
    score -= 30;
  }

  public int getMatchCount() {
    return wins + losses;
  }

  // 승률 계산
  public double getWinRate() {
    int totalGames = wins + losses;
    return totalGames == 0 ? 0 : (double) wins / totalGames;
  }

  @Override
  public int compareTo(Player anotherPlayer) {
    return Integer.compare(anotherPlayer.score, this.score);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {return true;}
    if (o == null || getClass() != o.getClass()) {return false;}
    Player player = (Player) o;
    return Objects.equals(name, player.name);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(name);
  }

  @Override
  public String toString() {
    return "Player{" +
        "이름=" + name +
        ", 점수=" + score +
        ", 승리=" + wins +
        ", 패배=" + losses +
        '}';
  }
}
