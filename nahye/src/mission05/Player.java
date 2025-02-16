package mission05;

import java.util.Iterator;

public class Player implements Comparable<Player>{

    private String name;
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
    public int getLosses() {
        return losses;
    }

    public int getScore() {
        return score;
    }


    public void recordWin() {
        wins++;
        score += 50;
    }

    public void recordLoss() {
        losses++;
        score -= 30;
    }

    @Override
    public int compareTo(Player o) {
        return Integer.compare(o.getScore(), this.getScore());
    }

    @Override
    public String toString() {
        return "이름: " + name + "," +
                " 승: " + wins +"," +
                " 패: " + losses +"," +
                " 점수: " + score;
    }
}
