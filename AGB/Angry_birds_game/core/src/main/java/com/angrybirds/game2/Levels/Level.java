package com.angrybirds.game2.Levels;

import com.angrybirds.game2.Birds.Bird;
import com.angrybirds.game2.Pigs.Pig;
import com.angrybirds.game2.Blocks.Block;
import com.angrybirds.game2.Core;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public abstract class Level {
    protected Core game;
    protected int levelNumber;
    protected int maxScore;
    protected List<Bird> birds;
    protected List<Pig> pigs;
    protected List<Block> blocks;
    protected Slingshot catapult; // Assuming there's a Catapult class
    protected int remainingBirds;
    protected boolean isCompleted;

    public Level(Core game, int levelNumber, int maxScore) {
        this.game = game;
        this.levelNumber = levelNumber;
        this.maxScore = maxScore;
        this.birds = new ArrayList<>();
        this.pigs = new ArrayList<>();
        this.blocks = new ArrayList<>();
        this.remainingBirds = 0;
        this.isCompleted = false;
        initializeBirds();
        initializePigs();
        initializeBlocks();
    }

    public void setBirds(List<Bird> birds) {
        this.birds = birds;
    }

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }

    public void setCatapult(Slingshot catapult) {
        this.catapult = catapult;
    }

    public void setGame(Core game) {
        this.game = game;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    public void setPigs(List<Pig> pigs) {
        this.pigs = pigs;
    }

    public void setRemainingBirds(int remainingBirds) {
        this.remainingBirds = remainingBirds;
    }

    protected abstract void initializeBirds();
    protected abstract void initializePigs();
    protected abstract void initializeBlocks();

    public void show() {
        // Implement the method to display the level or its components
        System.out.println("Level " + levelNumber + " is now active.");
    }

    public void render(SpriteBatch batch) {
        // Render birds, pigs, and blocks
        for (Bird bird : birds) {
            bird.draw(batch);  // Assuming Bird has a draw method
        }
        for (Pig pig : pigs) {
            pig.draw(batch);    // Assuming Pig has a draw method
        }
        for (Block block : blocks) {
            block.draw(batch);  // Assuming Block has a draw method
        }
    }

    public void startLevel() {
        isCompleted = false;
        remainingBirds = birds.size(); // Reset remaining birds to total at start
        // Initialize game elements as needed for the level
        System.out.println("Starting Level " + levelNumber);
    }

    public boolean endLevel() {
        return isCompleted; // Check if the level is completed
    }

    public void resetLevel() {
        for (Pig pig : pigs) {
            pig.reset(); // Assuming Pig has a reset method
        }
        for (Block block : blocks) {
            block.reset(); // Assuming Block has a reset method
        }
        remainingBirds = birds.size();
        isCompleted = false;
        System.out.println("Level " + levelNumber + " has been reset.");
    }

    public int calculateScore() {
        int score = 0;
        for (Pig pig : pigs) {
            score += pig.getScoreValue(); // Assuming Pig has a method to get score value
        }
        for (Block block : blocks) {
            score += block.getScoreValue(); // Assuming Block has a method to get score value
        }
        score += (remainingBirds * 10); // Example: each remaining bird gives 10 points
        return score;
    }

    public boolean isLevelCompleted() {
        return isCompleted; // Return the current completion state
    }

    public Core getGame() {
        return game;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public List<Bird> getBirds() {
        return birds;
    }

    public List<Pig> getPigs() {
        return pigs;
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public Slingshot getCatapult() {
        return null;
    }

    public int getRemainingBirds() {
        return remainingBirds;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed; // Setter for completion status
    }

    public void dispose() {
    }
}
