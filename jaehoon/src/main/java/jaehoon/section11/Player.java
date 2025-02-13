package jaehoon.section11;

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

  public void loss() {
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
  public String toString() {
    return "Player{" +
        "이름=" + name +
        ", 점수=" + score +
        ", 승리=" + wins +
        ", 패배=" + losses +
        '}';
  }
}
