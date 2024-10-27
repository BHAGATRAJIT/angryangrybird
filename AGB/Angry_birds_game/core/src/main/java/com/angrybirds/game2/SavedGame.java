package com.angrybirds.game2;

import com.angrybirds.game2.Levels.Level;

public class SavedGame {
    private Level level;
    private int score;
    private int lives;
    private String difficulty;

    public SavedGame(Level level, int score, int lives, String difficulty) {
        this.level = level;
        this.score = score;
        this.lives = lives;
        this.difficulty = difficulty;
    }

    public Level getLevel() {
        return level;
    }

    public int getScore() {
        return score;
    }

    public int getLives() {
        return lives;
    }

    public String getDifficulty() {
        return difficulty;
    }
}
