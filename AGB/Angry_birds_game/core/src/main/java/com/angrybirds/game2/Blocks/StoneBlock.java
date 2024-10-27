package com.angrybirds.game2.Blocks;

public class StoneBlock extends Block {

    public StoneBlock(float x, float y) {
        super("StoneBlock.png", x, y, 5.0f, 3);
    }

    @Override
    public String getBlockType() {
        return "stone"; // Returns the type of the block
    }
}
