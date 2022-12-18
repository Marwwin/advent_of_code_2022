package com.marwwin.adventofcode2022.day17;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TetrisBlockTest {

  @Test
  public void shouldBeAbleToCreateBoxShape() {
    TetrisBlock box = new TetrisBlock(TetrisShape.BOX);
    assertEquals(box.getBricks().size(), 4);

    assertArrayEquals(box.getBricks().get(0).getPosition(), new int[] { 0, 0 });
    assertArrayEquals(box.getBricks().get(1).getPosition(), new int[] { -1, 0 });
    assertArrayEquals(box.getBricks().get(2).getPosition(), new int[] { -1, 1 });
    assertArrayEquals(box.getBricks().get(3).getPosition(), new int[] { 0, 1 });
  }

  @Test
  public void shouldBeAbleToCreateVerticalShape() {
    TetrisBlock vertical = new TetrisBlock(TetrisShape.VERTICAL);
    assertEquals(vertical.getBricks().size(), 4);

    assertArrayEquals(vertical.getBricks().get(0).getPosition(), new int[] { -1, 0 });
    assertArrayEquals(vertical.getBricks().get(1).getPosition(), new int[] { -1, 1 });
    assertArrayEquals(vertical.getBricks().get(2).getPosition(), new int[] { -1, 2 });
    assertArrayEquals(vertical.getBricks().get(3).getPosition(), new int[] { -1, 3 });

  
  }

  @Test
  public void shouldBeAbleToCreateHorisontalShape() {
    TetrisBlock horisontal = new TetrisBlock(TetrisShape.HORISONTAL);
    assertEquals(horisontal.getBricks().size(), 4);
    assertArrayEquals(horisontal.getBricks().get(0).getPosition(), new int[] { 0, 0 });
    assertArrayEquals(horisontal.getBricks().get(1).getPosition(), new int[] { -1, 0 });
    assertArrayEquals(horisontal.getBricks().get(2).getPosition(), new int[] { 1, 0 });
    assertArrayEquals(horisontal.getBricks().get(3).getPosition(), new int[] { 2, 0 });
 
  }

  @Test
  public void shouldBeAbleToCreateStarShape() {
    TetrisBlock star = new TetrisBlock(TetrisShape.STAR);
    assertEquals(star.getBricks().size(), 5);

    assertArrayEquals(star.getBricks().get(0).getPosition(), new int[] { 0, 0 });
    assertArrayEquals(star.getBricks().get(1).getPosition(), new int[] { 0, 1 });
    assertArrayEquals(star.getBricks().get(2).getPosition(), new int[] { -1, 1 });
    assertArrayEquals(star.getBricks().get(3).getPosition(), new int[] { 1, 1 });
    assertArrayEquals(star.getBricks().get(4).getPosition(), new int[] { 0, 2 });
  }

  @Test
  public void shouldBeAbleToCreateWedgeShape() {
    TetrisBlock wedge = new TetrisBlock(TetrisShape.WEDGE);
    assertEquals(wedge.getBricks().size(), 5);

    assertArrayEquals(wedge.getBricks().get(0).getPosition(), new int[] { 0, 0 });
    assertArrayEquals(wedge.getBricks().get(1).getPosition(), new int[] { -1, 0 });
    assertArrayEquals(wedge.getBricks().get(2).getPosition(), new int[] { 1, 0 });
    assertArrayEquals(wedge.getBricks().get(3).getPosition(), new int[] { 1, 1 });
    assertArrayEquals(wedge.getBricks().get(4).getPosition(), new int[] { 1, 2 });
  }

  @Test
  public void shouldReturnBricksRelativeToPosition() {
    TetrisBlock block = new TetrisBlock(TetrisShape.HORISONTAL,1);

    assertArrayEquals(block.getBricks().get(0).getPosition(), new int[] { 0, 1 });
    assertArrayEquals(block.getBricks().get(1).getPosition(), new int[] { -1, 1 });
    assertArrayEquals(block.getBricks().get(2).getPosition(), new int[] { 1, 1 });
    assertArrayEquals(block.getBricks().get(3).getPosition(), new int[] { 2, 1 });
  }

  @Test
  public void shouldReturnBricksRelativeToPosition2() {
    TetrisBlock block = new TetrisBlock(TetrisShape.HORISONTAL,2);

    assertArrayEquals(block.getBricks().get(0).getPosition(), new int[] { 0, 2 });
    assertArrayEquals(block.getBricks().get(1).getPosition(), new int[] { -1, 2 });
    assertArrayEquals(block.getBricks().get(2).getPosition(), new int[] { 1, 2 });
    assertArrayEquals(block.getBricks().get(3).getPosition(), new int[] { 2, 2 });
  }

  @Test
  public void shouldReturnBricksRelativeToPosition3() {
    TetrisBlock block = new TetrisBlock(TetrisShape.HORISONTAL,3);

    assertArrayEquals(block.getBricks().get(0).getPosition(), new int[] { 0, 3 });
    assertArrayEquals(block.getBricks().get(1).getPosition(), new int[] { -1, 3 });
    assertArrayEquals(block.getBricks().get(2).getPosition(), new int[] { 1, 3 });
    assertArrayEquals(block.getBricks().get(3).getPosition(), new int[] { 2, 3 });
  }

  @Test
  public void shouldReturnBricksRelativeToPositionAfterMove() {
    TetrisBlock block = new TetrisBlock(TetrisShape.HORISONTAL,3);
    block.moveDown();
    assertArrayEquals(block.getBricks().get(0).getPosition(), new int[] { 0, 2 });
    assertArrayEquals(block.getBricks().get(1).getPosition(), new int[] { -1, 2 });
    assertArrayEquals(block.getBricks().get(2).getPosition(), new int[] { 1, 2 });
    assertArrayEquals(block.getBricks().get(3).getPosition(), new int[] { 2, 2 });

    block.moveLeft();
    assertArrayEquals(block.getBricks().get(0).getPosition(), new int[] { -1, 2 });
    assertArrayEquals(block.getBricks().get(1).getPosition(), new int[] { -2, 2 });
    assertArrayEquals(block.getBricks().get(2).getPosition(), new int[] { 0, 2 });
    assertArrayEquals(block.getBricks().get(3).getPosition(), new int[] { 1, 2 });

    block.moveLeft();
    assertArrayEquals(block.getBricks().get(0).getPosition(), new int[] { -2, 2 });
    assertArrayEquals(block.getBricks().get(1).getPosition(), new int[] { -3, 2 });
    assertArrayEquals(block.getBricks().get(2).getPosition(), new int[] { -1, 2 });
    assertArrayEquals(block.getBricks().get(3).getPosition(), new int[] { 0, 2 });

    block.moveDown();
    assertArrayEquals(block.getBricks().get(0).getPosition(), new int[] { -2, 1 });
    assertArrayEquals(block.getBricks().get(1).getPosition(), new int[] { -3, 1 });
    assertArrayEquals(block.getBricks().get(2).getPosition(), new int[] { -1, 1 });
    assertArrayEquals(block.getBricks().get(3).getPosition(), new int[] { 0, 1 });
    
    block.moveRight();
    block.moveRight();
    block.moveRight();
    assertArrayEquals(block.getBricks().get(0).getPosition(), new int[] { 1, 1 });
    assertArrayEquals(block.getBricks().get(1).getPosition(), new int[] { 0, 1 });
    assertArrayEquals(block.getBricks().get(2).getPosition(), new int[] { 2, 1 });
    assertArrayEquals(block.getBricks().get(3).getPosition(), new int[] { 3, 1 });
  }

  @Test
  public void shouldHaveAStartingPosition() {
    TetrisBlock block = new TetrisBlock(TetrisShape.VERTICAL);
    assertArrayEquals(block.getPosition(), new int[] { 0, 0 });
  }

  @Test
  public void shouldMoveOneStepDown() {
    TetrisBlock block = new TetrisBlock(TetrisShape.VERTICAL);
    block.moveDown();
    assertArrayEquals(block.getPosition(), new int[] { 0, -1 });
  }

  @Test
  public void shouldMoveOneStepToLeft() {
    TetrisBlock block = new TetrisBlock(TetrisShape.VERTICAL);
    block.moveLeft();
    assertArrayEquals(block.getPosition(), new int[] { -1, 0 });
  }

  @Test
  public void shouldMoveOneStepToRight() {
    TetrisBlock block = new TetrisBlock(TetrisShape.VERTICAL);
    block.moveRight();
    assertArrayEquals(block.getPosition(), new int[] { 1, 0 });
  }

  @Test
  public void givenJetPatternToMoveRightShouldMoveCorrectly() {
    TetrisBlock block = new TetrisBlock(TetrisShape.VERTICAL);
    block.move('>');
    assertArrayEquals(block.getPosition(), new int[] { 1, -1 });
  }
  @Test
  public void givenJetPatternToMoveLeftShouldMoveCorrectly() {
    TetrisBlock block = new TetrisBlock(TetrisShape.VERTICAL);
    block.move('<');
    assertArrayEquals(block.getPosition(), new int[] { -1, -1 });
  }
}
