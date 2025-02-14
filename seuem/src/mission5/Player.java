import java.util.Iterator;

public class Player implements Comparable<Player> {
    private final String name;
    private int wins;
    private int loses;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 1000;
    }

    public void loses() {
        this.loses++;
        score -= 30;
    }

    public void wins() {
        this.wins++;
        score += 50;
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

    @Override
    public int compareTo(Player o) {
        return Integer.compare(o.score, this.score);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", wins=" + wins +
                ", loses=" + loses +
                ", score=" + score +
                '}';
    }
}
