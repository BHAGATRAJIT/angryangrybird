package com.angrybirds.game2.Blocks;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Rectangle;

public abstract class Block {
    protected Texture texture;
    protected Vector2 position;

    protected Rectangle bounds;
    protected float weight;
    protected int health;
    private String material;

    public Block(String texturePath, float x, float y, float weight, int health) {
        this.texture = new Texture(texturePath);
        this.position = new Vector2(x, y);
        this.bounds = new Rectangle(x, y, texture.getWidth(), texture.getHeight());
        this.weight = weight;
        this.health = health;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Texture getTexture() {
        return texture;
    }

    public String getMaterial() {
        return material;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);
    }

    public void dispose() {
        texture.dispose();
    }

    public float getX() {
        return position.x; // Get the x-coordinate
    }

    public float getY() {
        return position.y; // Get the y-coordinate
    }

    public void setPosition(Vector2 position) {
        this.position = position;
        bounds.setPosition(position.x, position.y);
    }

    public void setPosition(float x, float y) {
        position.set(x, y);
        bounds.setPosition(x, y);
    }

    public boolean isColliding(Rectangle otherBounds) {
        return bounds.overlaps(otherBounds);
    }

    public void hit() {
        health--;
        if (health <= 0) {
            dispose();
        }
    }

    public int getHealth() {
        return health;
    }

    public float getWeight() {
        return weight;
    }

    public void update() {
        // You can add update logic here if needed
    }

    public int getScoreValue() {
        return 0; // Return score value for this block, if applicable
    }

    public void reset() {
        // Reset logic for the block, if needed
    }

    public abstract String getBlockType();
}
