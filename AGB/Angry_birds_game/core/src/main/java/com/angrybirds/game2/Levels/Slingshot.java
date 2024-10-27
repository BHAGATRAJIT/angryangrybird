package com.angrybirds.game2.Levels; // Change this to your main package

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Slingshot {
    private Texture slingshotTexture;
    private Vector2 position;
    private float angle;
    private float maxStretch;

    public Slingshot(float x, float y, float maxStretch) {
        this.position = new Vector2(x, y);
        this.maxStretch = maxStretch;
        this.slingshotTexture = new Texture(Gdx.files.internal("slingshot.png"));
        this.angle = 0;
    }

    // Render method can be simplified and combined with the draw method
    public void draw(SpriteBatch batch) {
        batch.begin();
        batch.draw(slingshotTexture, position.x, position.y);
        batch.end();
    }

    public void aim(Vector2 touchPosition) {
        Vector2 direction = touchPosition.cpy().sub(position);
        angle = direction.angle();
        // Here you could also handle stretching logic if needed
    }

    public void launch() {
        // Implement launch logic here
    }

    public void dispose() {
        slingshotTexture.dispose();
    }

    public Vector2 getPosition() {
        return position;
    }

    public float getAngle() {
        return angle;
    }
}
