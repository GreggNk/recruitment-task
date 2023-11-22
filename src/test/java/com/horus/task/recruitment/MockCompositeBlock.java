package com.horus.task.recruitment;

import java.util.ArrayList;
import java.util.List;

public class MockCompositeBlock implements CompositeBlock {

    private List<Block> components = new ArrayList<Block>() {
        {
            add(new MockConcreeteBlock());
            add(new MockBrickBlock());
        }
    };

    @Override
    public String getColor() {
        return "pink";
    }

    @Override
    public String getMaterial() {
        return "concreet & clay";
    }

    @Override
    public List<Block> getBlocks() {
        return components;
    }
}
