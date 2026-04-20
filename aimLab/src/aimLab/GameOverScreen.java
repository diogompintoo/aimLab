package aimLab;

import com.codeforall.simplegraphics.graphics.Text;
import com.codeforall.simplegraphics.graphics.Color;

    public class GameOverScreen {

        private Text gameOverText;
        private Text scoreText;
        private Text restartText;
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

            restartText = new Text(420, 490, "RESTART");
            restartText.setColor(Color.BLACK);
            restartText.grow(25, 25);
            restartText.draw();



            isVisible = true;
        }

        public void hide() {

            if (gameOverText != null) gameOverText.delete();
            if (scoreText != null) scoreText.delete();
            if (restartText!= null) restartText.delete();

            isVisible = false;
        }
    }

