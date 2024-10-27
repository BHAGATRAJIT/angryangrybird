package com.angrybirds.game2.Blocks;

public class WoodBlock extends Block {

    public WoodBlock(float x, float y) {
        super("WoodBlock.png", x, y, 2.0f, 2);
    }

    @Override
    public String getBlockType() {
        return "wood"; // Returns the type of the block
    }
}
