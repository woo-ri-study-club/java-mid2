package mission5;

import java.util.Objects;

public class Player implements Comparable<Player> {

    private final String name;

    private int wins;

    private int losses;

    private int score;

    public Player(String name) {
        this.name = name;
        this.wins = 0;
        this.losses = 0;
        this.score = 1000;
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

    public void win() {
        wins++;
        score += 50;
    }

    public void lose() {
        losses++;
        score -= 30;
    }

    @Override
    public int compareTo(Player o) {
        return Integer.compare(o.score, this.score);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return name + " - Wins: " + wins + ", Losses: " + losses + ", Score: " + score;
    }
}
