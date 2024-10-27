package com.angrybirds.game2.Pigs;

public class SmallPig extends Pig {

    public SmallPig(float x, float y) {
        super("SmallPig.png", x, y, 50, 10, "small");
    }
    @Override
    public String getSize() {
        return "small"; // Returns the type of the block
    }

}
