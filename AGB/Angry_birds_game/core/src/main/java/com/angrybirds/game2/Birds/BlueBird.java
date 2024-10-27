package com.angrybirds.game2.Birds;

public class BlueBird extends Bird {

    public BlueBird(float x, float y) {
        super("BlueBird.png", x, y);
    }

    public void split() {
        System.out.println("Blue bird splitting into multiple birds!");
    }

    @Override
    public String getBirdType() {
        return "blue"; // Returns the color/type of the bird
    }
}
