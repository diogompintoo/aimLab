package aimLab;

public class Score {

    private int score = 0;

    public void add() {
        score += 10;
        System.out.println("Score: " + score);
    }

    public int getScore() {
        return score;
    }
}

