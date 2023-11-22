package com.horus.task.recruitment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RecruitmentApplicationTests {

	@Test
	void contextLoads() {

		var brickBlock1 = new MockBrickBlock();
		var brickBlock2 = new MockBrickBlock();
		var concreteBlock1 = new MockConcreeteBlock();
		var compositeBlock1 = new MockCompositeBlock();
		var compositeBlock2 = new MockCompositeBlock();

		List<Block> blocks = new ArrayList<Block>() {
			{
				add(brickBlock1);
				add(brickBlock2);
				add(concreteBlock1);
				add(compositeBlock1);
				add(compositeBlock2);
			}
		};

		Wall wall = new Wall(blocks);

		var block = wall.findBlockByColor("red");
		assertEquals(block.get().getColor(), "red");

		block = wall.findBlockByColor("gray");
		assertEquals(block.isPresent(), false);

		var clayBlocks = wall.findBlocksByMaterial("clay");
		assertEquals(clayBlocks, Arrays.asList(brickBlock1, brickBlock2));

		var stoneBlocks = wall.findBlocksByMaterial("stone");
		assertEquals(stoneBlocks.size(), 0);

		var concreteBlock = wall.findBlocksByMaterial("concrete");
		assertEquals(concreteBlock, Arrays.asList(concreteBlock1));

		var compositeBlocks = wall.findBlocksByMaterial("concreet & clay");
		assertEquals(compositeBlocks, Arrays.asList(compositeBlock1, compositeBlock2));

		var compositeBlocksNotExist = wall.findBlocksByMaterial("stone");
		assertEquals(compositeBlocksNotExist.size(), 0);

		assertEquals(wall.count(), 5);
	}
}
