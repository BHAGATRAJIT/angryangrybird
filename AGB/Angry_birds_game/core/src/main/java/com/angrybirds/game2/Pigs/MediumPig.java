package com.angrybirds.game2.Pigs;

public class MediumPig extends Pig {

    public MediumPig(float x, float y) {
        super("MediumPig.png", x, y, 100, 20, "medium");
    }
    @Override
    public String getSize() {
        return "medium"; // Returns the type of the block
    }

}
