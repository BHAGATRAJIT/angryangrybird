package com.angrybirds.game2;

import com.angrybirds.game2.Levels.Level;
import com.angrybirds.game2.Levels.Level1;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Level currentLevel;
    private int score;
    private int lives;
    private List<SavedGame> savedGames; // List to hold saved games
    private Player currentPlayer;
    private boolean isPaused;
    private int totalLevels;
    private String difficulty;

    public Level getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(Level currentLevel) {
        this.currentLevel = currentLevel;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public boolean isPaused() {
        return isPaused;
    }

    public void setPaused(boolean paused) {
        isPaused = paused;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public List<SavedGame> getSavedGames() {
        return savedGames;
    }

    public void setSavedGames(List<SavedGame> savedGames) {
        this.savedGames = savedGames;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTotalLevels() {
        return totalLevels;
    }

    public void setTotalLevels(int totalLevels) {
        this.totalLevels = totalLevels;
    }

    public Game() {
        this.savedGames = new ArrayList<>(); // Initialize the list
        this.score = 0; // Initialize score
        this.lives = 3; // Initialize lives (you can change this value)
        this.isPaused = false; // Game starts unpaused
        this.totalLevels = 5; // Set the total number of levels (example)
        this.difficulty = "Normal"; // Default difficulty
    }

    public void startGame() {
        // Logic to start the game
        System.out.println("Game started!");
        // Initialize the first level or reset state if restarting
        currentLevel = getLevel(1); // Assuming levels are indexed from 1
    }

    public void nextLevel() {
        // Logic to advance to the next level
        if (currentLevel != null && currentLevel.getLevelNumber() < totalLevels) {
            currentLevel = getLevel(currentLevel.getLevelNumber() + 1);
            System.out.println("Moved to level " + currentLevel.getLevelNumber());
        } else {
            System.out.println("No more levels to advance.");
        }
    }

    public void saveGame() {
        // Logic to save the current game state
        SavedGame savedGame = new SavedGame(currentLevel, score, lives, difficulty);
        savedGames.add(savedGame);
        System.out.println("Game saved!");
    }

    public void loadGame(SavedGame savedGame) {
        // Logic to load a saved game state
        this.currentLevel = savedGame.getLevel();
        this.score = savedGame.getScore();
        this.lives = savedGame.getLives();
        this.difficulty = savedGame.getDifficulty();
        System.out.println("Game loaded!");
    }

    public void pauseGame() {
        isPaused = true;
        System.out.println("Game paused.");
    }

    public void resumeGame() {
        isPaused = false;
        System.out.println("Game resumed.");
    }

    public void restartLevel() {
        // Logic to restart the current level
        if (currentLevel != null) {
            System.out.println("Restarting level " + currentLevel.getLevelNumber());
            // Reset level state if needed
        }
    }

    public void exitGame() {
        // Logic to exit the game
        System.out.println("Exiting game. Thanks for playing!");
        // Perform any cleanup if necessary
    }

    public void displayScore() {
        System.out.println("Current Score: " + score);
    }

    public void adjustDifficulty(String level) {
        this.difficulty = level;
        System.out.println("Difficulty set to: " + difficulty);
    }

    private Level getLevel(int levelNumber) {
        // Placeholder for level retrieval logic
        // You may want to implement a LevelFactory or similar pattern to create levels
        return new Level1(new Core()); // Example, replace with actual level retrieval logic
    }

    // Additional getters and setters if necessary
}
