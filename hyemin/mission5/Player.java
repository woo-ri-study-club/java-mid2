package mission5;

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

    @Override
    public int compareTo(Player other) {
        return Integer.compare(this.score, other.score);
    }

    @Override
    public String toString() {
        return String.format("%s: %d wins, %d losses, Score: %d", name, wins, losses, score);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player player)) return false;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

