package aimLab;

import com.codeforall.simplegraphics.graphics.Color;
import com.codeforall.simplegraphics.graphics.Text;

public class Score {

    private int score = 0;
    private Text scoreText;

    public Score(){
        scoreText = new Text(30, 30, "SCORE: 0");
        scoreText.setColor(Color.BLACK);
        scoreText.grow(8, 8);
        scoreText.draw();
    }

    public void add() {
        score += 10;
        updateDisplay();
        System.out.println("Score: " + score);
    }
    private void updateDisplay(){
        if (scoreText != null) {
            scoreText.setText("SCORE: "+score);
        }
    }

    public void hideScore(){
        if (scoreText != null)
            scoreText.delete();


        //isVisible = false;
    }

    public int getScore() {
        return score;
    }

}

