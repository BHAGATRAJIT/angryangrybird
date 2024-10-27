package com.angrybirds.game2.Levels;

import com.angrybirds.game2.Birds.Bird;
import com.angrybirds.game2.Birds.RedBird;
import com.angrybirds.game2.Birds.YellowBird;
import com.angrybirds.game2.Pigs.*;
import com.angrybirds.game2.Blocks.*;
import com.angrybirds.game2.Core;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public class Level2 extends Level {

    public Level2(Core game) {
        super(game, 2, 100); // Initialize with level number and max score
    }

    @Override
    protected void initializeBirds() {
        List<Bird> birds = new ArrayList<>();
        birds.add(new YellowBird(130, 160));
        birds.add(new YellowBird(50, 100));
        birds.add(new YellowBird(90, 100));
        // You can add more bird types if needed
        setBirds(birds);
        remainingBirds = birds.size(); // Initialize remaining birds
    }

    @Override
    protected void initializePigs() {
        List<Pig> pigs = new ArrayList<>();
        pigs.add(new MediumPig(500, 160));
        pigs.add(new MediumPig(560, 130));

        pigs.add(new SmallPig(440, 190));


        setPigs(pigs);
    }

    @Override
    protected void initializeBlocks() {
        List<Block> blocks = new ArrayList<>();
        blocks.add(new WoodBlock(440, 100));
        blocks.add(new WoodBlock(500, 130));
        blocks.add(new WoodBlock(560, 100));
        blocks.add(new WoodBlock(500, 100));
        blocks.add(new GlassBlock(440, 130));
        blocks.add(new GlassBlock(440, 160));



        // You can add stone blocks or glass blocks if they exist in your project
        setBlocks(blocks);
    }

    @Override
    public void show() {
        // Displaying the level status
        System.out.println("Level " + getLevelNumber() + " is now active.");
        // Setup the UI or other necessary game elements here
        // For example, you could reset the game state if starting anew
        startLevel();
    }

    @Override
    public void render(SpriteBatch batch) {
        // Implement the rendering logic here
        drawGameElements(batch);
    }

    private void drawGameElements(SpriteBatch batch) {
        // Draw birds
        for (Bird bird : getBirds()) {
            bird.draw(batch); // Assuming Bird has a draw method
        }

        // Draw pigs
        for (Pig pig : getPigs()) {
            pig.draw(batch); // Assuming Pig has a draw method
        }

        // Draw blocks
        for (Block block : getBlocks()) {
            block.draw(batch); // Assuming Block has a draw method
        }

        // Draw the catapult if it exists
        if (catapult != null) {
            catapult.draw(batch); // Assuming Catapult has a draw method
        }
    }

    @Override
    public void startLevel() {
        super.startLevel(); // Call the parent class method
        // Additional setup for starting the level can go here if needed
    }

    @Override
    public boolean endLevel() {
        // Check for completion logic
        // Example: Check if all pigs are defeated
        boolean allPigsDefeated = getPigs().isEmpty();
        if (allPigsDefeated) {
            isCompleted = true; // Mark the level as completed
        }
        return isCompleted;
    }
}
