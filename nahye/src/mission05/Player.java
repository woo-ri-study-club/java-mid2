package mission05;

public class Player {

    private String name;
    private int wins;
    private int losses;
    private int score;

    public Player(String name, int wins, int losses, int score) {
        this.name = name;
        this.wins = wins;
        this.losses = losses;
        this.score = score;
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
}
