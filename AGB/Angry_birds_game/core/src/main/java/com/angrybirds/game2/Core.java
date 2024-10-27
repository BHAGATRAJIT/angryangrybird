package com.angrybirds.game2;

import com.angrybirds.game2.Screens.HomeScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Core extends Game {
    public SpriteBatch batch;

    @Override
    public void create() {
        batch = new SpriteBatch();
        setScreen(new HomeScreen(this));  // Set the HomeScreen as the starting screen
    }

    @Override
    public void render() {
        super.render();  // This calls the render() method of the active screen
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
