package com.angrybirds.game2.Birds;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Polygon;

public abstract class Bird {
    protected Texture texture;
    private String color;
    protected Vector2 position;
    protected Vector2 velocity;
    protected Vector2 initialPosition;
    protected Vector2 acceleration;
    protected float launchAngle;
    protected float launchForce;
    protected boolean isLaunched;

    protected boolean hasHitTarget;
    protected Polygon bounds;
    protected float rotation;
    protected float damage;

    public Bird(String texturePath, float x, float y) {
        this.texture = new Texture(texturePath);
        this.position = new Vector2(x, y);
        this.initialPosition = new Vector2(x, y);
        this.velocity = new Vector2(0, 0);
        this.acceleration = new Vector2(0, -9.8f); // Gravity
        this.launchAngle = 0;
        this.launchForce = 0;
        this.isLaunched = false;
        this.hasHitTarget = false;
        this.rotation = 0;
        this.damage = 10;

        // Set bounds for collision detection
        this.bounds = new Polygon(new float[]{
            0, 0,
            texture.getWidth(), 0,
            texture.getWidth(), texture.getHeight(),
            0, texture.getHeight()
        });
        this.bounds.setPosition(position.x, position.y);
    }

    // Update method to handle movement and physics
    public void update(float delta) {
        if (isLaunched) {
            velocity.add(acceleration.x * delta, acceleration.y * delta);
            position.add(velocity.x * delta, velocity.y * delta);
            bounds.setPosition(position.x, position.y);
            rotation = velocity.angleDeg();
        }
    }
    public String getColor() {
        return color;
    }

    // Draw method to render the bird on the screen
    public void draw(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y, texture.getWidth() / 2f, texture.getHeight() / 2f,
            texture.getWidth(), texture.getHeight(), 1, 1, rotation, 0, 0,
            texture.getWidth(), texture.getHeight(), false, false);
    }

    // Launch the bird with specified angle and force
    public void launch(float angle, float force) {
        this.launchAngle = angle;
        this.launchForce = force;
        this.velocity.set((float) Math.cos(Math.toRadians(angle)) * force,
            (float) Math.sin(Math.toRadians(angle)) * force);
        this.isLaunched = true;
    }

    // Reset the bird's position and state
    public void reset() {
        position.set(initialPosition);
        velocity.set(0, 0);
        isLaunched = false;
        hasHitTarget = false;
        rotation = 0;
    }

    // Dispose of the texture when no longer needed
    public void dispose() {
        texture.dispose();
    }

    // Getters and Setters
    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public Vector2 getPosition() {
        return position;
    }

    public float getX() {
        return position.x; // Get the x-coordinate
    }

    public float getY() {
        return position.y; // Get the y-coordinate
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public Polygon getBounds() {
        return bounds;
    }

    public boolean checkCollision(Polygon targetBounds) {
        if (bounds.getBoundingRectangle().overlaps(targetBounds.getBoundingRectangle())) {
            hasHitTarget = true;
            return true;
        }
        return false;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }

    public float getDamage() {
        return damage;
    }

    public boolean hasHitTarget() {
        return hasHitTarget;
    }

    public boolean isLaunched() {
        return isLaunched;
    }

    public Vector2 getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Vector2 acceleration) {
        this.acceleration = acceleration;
    }

    public void setBounds(Polygon bounds) {
        this.bounds = bounds;
    }

    public void setInitialPosition(Vector2 initialPosition) {
        this.initialPosition = initialPosition;
    }

    public void setLaunched(boolean launched) {
        isLaunched = launched;
    }

    public float getLaunchAngle() {
        return launchAngle;
    }

    public void setLaunchAngle(float launchAngle) {
        this.launchAngle = launchAngle;
    }

    public float getLaunchForce() {
        return launchForce;
    }

    public void setLaunchForce(float launchForce) {
        this.launchForce = launchForce;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
        bounds.setPosition(position.x, position.y);
    }

    public void setPosition(float x, float y) {
        position.set(x, y);
        bounds.setPosition(x, y);
    }

    public float getRotation() {
        return rotation;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public void applyGravity() {
    }

    public abstract String getBirdType();
}
