package aimLab;

import com.codeforall.simplegraphics.graphics.Text;
import com.codeforall.simplegraphics.graphics.Color;

    public class GameOverScreen {

        private Text gameOverText;
        private Text scoreText;
        private boolean isVisible = false;

        public void show(int score) {

            if (isVisible) return;

            gameOverText = new Text(400, 400, "GAME OVER");
            gameOverText.setColor(Color.RED);
            gameOverText.grow(40, 40);
            gameOverText.draw();

            scoreText = new Text(250, 300, "FINAL SCORE: " + score);
            scoreText.setColor(Color.BLACK);
            scoreText.grow(25, 25);
            scoreText.draw();

            isVisible = true;
        }

        public void hide() {

            if (gameOverText != null) gameOverText.delete();
            if (scoreText != null) scoreText.delete();

            isVisible = false;
        }
    }

