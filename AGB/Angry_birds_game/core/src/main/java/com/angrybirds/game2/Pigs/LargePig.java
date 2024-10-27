package com.angrybirds.game2.Pigs;

public class LargePig extends Pig {

    public LargePig(float x, float y) {
        super("LargePig.png", x, y, 150, 30, "large");
    }
    @Override
    public String getSize() {
        return "large"; // Returns the type of the block
    }
}
