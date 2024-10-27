package com.angrybirds.game2.Pigs;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class Pig {
    protected int health;
    protected Vector2 position;
    protected int scoreValue;
    protected String size;
    protected Texture texture;


    public Pig(String texturePath, float x, float y, int health, int scoreValue, String size) {
        this.texture = new Texture(texturePath);
        this.position = new Vector2(x, y);
        this.health = health;
        this.scoreValue = scoreValue;
        this.size = size;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public void setScoreValue(int scoreValue) {
        this.scoreValue = scoreValue;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (isDestroyed()) {
            System.out.println("Pig destroyed!");
        }
    }

    public boolean isDestroyed() {
        return health <= 0;
    }

    public void dispose() {
        texture.dispose();
    }

    // Getters
    public Vector2 getPosition() {
        return position;
    }

    public float getX() {
        return position.x; // Get the x-coordinate
    }

    public float getY() {
        return position.y; // Get the y-coordinate
    }

    public int getHealth() {
        return health;
    }

    public int getScoreValue() {
        return scoreValue;
    }

    public String getSize() {
        return size;
    }

    public void reset() {
        // Reset logic can be implemented here if needed
    }
}
