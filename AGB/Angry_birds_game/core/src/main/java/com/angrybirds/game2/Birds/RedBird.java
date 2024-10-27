package com.angrybirds.game2.Birds;

import com.badlogic.gdx.graphics.Texture;

public class RedBird extends Bird {

    public RedBird(float x, float y) {
        super("Redbird.png", x, y);
    }

    @Override
    public String getBirdType() {
        return "red";
    }
}
