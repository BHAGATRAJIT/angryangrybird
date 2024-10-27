package com.angrybirds.game2.Blocks;

public class GlassBlock extends Block {

    public GlassBlock(float x, float y) {
        super("GlassBlock.png", x, y, 1.0f, 1);
    }

    @Override
    public String getBlockType() {
        return "glass"; // Returns the type of the block
    }
}
