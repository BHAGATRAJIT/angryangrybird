package com.angrybirds.game2.Birds;

import com.badlogic.gdx.math.Vector2;

public class YellowBird extends Bird {

    public YellowBird(float x, float y) {
        super("YellowBird.png", x, y);
    }

    public void speedBoost() {
        if (isLaunched) {
            System.out.println("Yellow bird activated speed boost!");
            velocity.x *= 2;
            velocity.y *= 2;
        }
    }

    @Override
    public String getBirdType() {
        return "yellow"; // Returns the color/type of the bird
    }
}
