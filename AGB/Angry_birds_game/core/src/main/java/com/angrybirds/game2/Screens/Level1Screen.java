package com.angrybirds.game2.Screens;

import com.angrybirds.game2.Birds.Bird;
import com.angrybirds.game2.Blocks.Block;
import com.angrybirds.game2.Core;
import com.angrybirds.game2.Levels.Level1;
import com.angrybirds.game2.Pigs.Pig;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class Level1Screen implements Screen {
    private final Core game;
    private Stage stage;
    private Skin skin;
    private Texture floor;
    private Texture slingshot;
    private Texture bird;
    private Texture block;
    private Texture pig;
    private Texture sky;
    private SpriteBatch batch;

    private Slider angleSlider;
    private Slider powerSlider;
    private TextButton launchButton;
    private TextButton pauseButton;

    private Level1 level; // Reference to the Level1 instance

    private static final int SLINGSHOT_WIDTH = 100;
    private static final int SLINGSHOT_HEIGHT = 100;
    private static final int BIRD_WIDTH = 40;
    private static final int BIRD_HEIGHT = 40;
    private static final int BLOCK_WIDTH = 60;
    private static final int BLOCK_HEIGHT = 30;
    private static final int PIG_WIDTH = 50;
    private static final int PIG_HEIGHT = 50;
    private static final int FLOOR_HEIGHT = 100;

    private static final float SLIDER_WIDTH = 100;
    private static final float BUTTON_WIDTH = 100;
    private static final float BUTTON_HEIGHT = 30;

    public Level1Screen(Core game, Level1 level) {
        this.game = game;
        this.level = level; // Store the Level1 instance
        batch = new SpriteBatch();
        loadTextures();
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        skin = new Skin(Gdx.files.internal("uiskin.json"));

        createUI();
    }

    private void loadTextures() {
        floor = new Texture(Gdx.files.internal("floor.png"));
        slingshot = new Texture(Gdx.files.internal("slingshot.png"));
        bird = new Texture(Gdx.files.internal("Redbird.png"));
        block = new Texture(Gdx.files.internal("WoodBlock.png"));
        pig = new Texture(Gdx.files.internal("SmallPig.png"));
        sky = new Texture(Gdx.files.internal("Sky.png"));
    }

    private void createUI() {
        Table table = new Table();
        table.setFillParent(true);
        table.bottom().left();

        angleSlider = new Slider(0, 90, 1, false, skin);
        powerSlider = new Slider(0, 100, 1, false, skin);

        createLaunchButton();
        createPauseButton();

        table.add(angleSlider).width(SLIDER_WIDTH).pad(10);
        table.row();
        table.add(powerSlider).width(SLIDER_WIDTH).pad(10);
        table.row();
        table.add(launchButton).width(BUTTON_WIDTH).pad(10);
        table.row();
        table.add(pauseButton).width(BUTTON_WIDTH).pad(10);

        stage.addActor(table);
        pauseButton.setPosition(10, Gdx.graphics.getHeight() - pauseButton.getHeight() - 10);
        stage.addActor(pauseButton);
    }

    private void createLaunchButton() {
        launchButton = new TextButton("Launch", skin);
        launchButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                float angle = angleSlider.getValue();
                float power = powerSlider.getValue();
                System.out.println("Launching at angle: " + angle + " and power: " + power);
                // Call launchBird method from the Level1 class using the stored level reference
//                level.launchBird(0); // Example for the first bird
            }
        });
    }

    private void createPauseButton() {
        pauseButton = new TextButton("Pause", skin);
        pauseButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("Game Paused");
                game.setScreen(new PauseScreen(game));
            }
        });
    }

    @Override
    public void show() {}

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.15f, 0.15f, 0.2f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        drawBackground();
        drawGameElements(); // Drawing game elements using the Level1 instance
        batch.end();

        stage.act(delta);
        stage.draw();
    }

    private void drawBackground() {
        batch.draw(sky, 0, FLOOR_HEIGHT, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.draw(floor, 0, 0, Gdx.graphics.getWidth(), FLOOR_HEIGHT);
    }

    private void drawGameElements() {
        // Example: Draw the slingshot
        batch.draw(slingshot, 100, 100, SLINGSHOT_WIDTH, SLINGSHOT_HEIGHT);
        // Draw birds, pigs, and blocks using the level reference
        for (Bird bird : level.getBirds()) {
            batch.draw(bird.getTexture(), bird.getX(), bird.getY(), BIRD_WIDTH, BIRD_HEIGHT);
        }
        for (Pig pig : level.getPigs()) {
            batch.draw(pig.getTexture(), pig.getX(), pig.getY(), PIG_WIDTH, PIG_HEIGHT);
        }
        for (Block block : level.getBlocks()) {
            batch.draw(block.getTexture(), block.getX(), block.getY(), BLOCK_WIDTH, BLOCK_HEIGHT);
        }
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {
        batch.dispose();
        floor.dispose();
        slingshot.dispose();
        bird.dispose();
        block.dispose();
        pig.dispose();
        sky.dispose();
        stage.dispose();
    }
}
