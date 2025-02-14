package mission05;

import java.util.Objects;

public class Player implements Comparable<Player> {
    private String name;
    private int wins;
    private int loses;
    private int score;

    public Player(String name) {
        this.name = name;
        this.wins = 0;
        this.loses = 0;
        this.score = 0;
    }

    public void win() {
        this.wins++;
        score += 50;
    }

    public void lose() {
        this.loses++;
        score -= 30;
    }

    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }

    public int getScore() {
        return score;
    }

    public double getWinRate() {
        if (wins + loses == 0) {
            return 0.0;
        }

        return (double) wins / (wins + loses);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "이름: " + name + " | 승리 횟수: " + wins + " | 패배 횟수: " + loses + " | 점수: " + score;
    }

    @Override
    public int compareTo(Player o) {
        return Integer.compare(o.getScore(), score);
    }
}
