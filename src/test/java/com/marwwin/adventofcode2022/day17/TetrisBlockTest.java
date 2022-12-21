package com.marwwin.adventofcode2022.day17;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.marwwin.aoc.Coord;

public class TetrisBlockTest {

  @Test
  public void shouldBeAbleToCreateBoxShape() {
    TetrisBlock box = new TetrisBlock(TetrisShape.BOX);
    assertEquals(box.getBricks().size(), 4);

    assertEquals(box.getBricks().get(0), new Coord( 0, 0 ));
    assertEquals(box.getBricks().get(1), new Coord( -1, 0 ));
    assertEquals(box.getBricks().get(2), new Coord( -1, 1 ));
    assertEquals(box.getBricks().get(3), new Coord( 0, 1 ));
  }

  @Test
  public void shouldBeAbleToCreateVerticalShape() {
    TetrisBlock vertical = new TetrisBlock(TetrisShape.VERTICAL);
    assertEquals(vertical.getBricks().size(), 4);

    assertEquals(vertical.getBricks().get(0), new Coord( -1, 0 ));
    assertEquals(vertical.getBricks().get(1), new Coord( -1, 1 ));
    assertEquals(vertical.getBricks().get(2), new Coord( -1, 2 ));
    assertEquals(vertical.getBricks().get(3), new Coord( -1, 3 ));

  
  }

  @Test
  public void shouldBeAbleToCreateHorisontalShape() {
    TetrisBlock horisontal = new TetrisBlock(TetrisShape.HORISONTAL);
    assertEquals(horisontal.getBricks().size(), 4);
    assertEquals(horisontal.getBricks().get(0), new Coord( 0, 0 ));
    assertEquals(horisontal.getBricks().get(1), new Coord( -1, 0 ));
    assertEquals(horisontal.getBricks().get(2), new Coord( 1, 0 ));
    assertEquals(horisontal.getBricks().get(3), new Coord( 2, 0 ));
 
  }

  @Test
  public void shouldBeAbleToCreateStarShape() {
    TetrisBlock star = new TetrisBlock(TetrisShape.STAR);
    assertEquals(star.getBricks().size(), 5);

    assertEquals(star.getBricks().get(0), new Coord( 0, 0 ));
    assertEquals(star.getBricks().get(1), new Coord( 0, 1 ));
    assertEquals(star.getBricks().get(2), new Coord( -1, 1 ));
    assertEquals(star.getBricks().get(3), new Coord( 1, 1 ));
    assertEquals(star.getBricks().get(4), new Coord( 0, 2 ));
  }

  @Test
  public void shouldBeAbleToCreateWedgeShape() {
    TetrisBlock wedge = new TetrisBlock(TetrisShape.WEDGE);
    assertEquals(wedge.getBricks().size(), 5);

    assertEquals(wedge.getBricks().get(0), new Coord( 0, 0 ));
    assertEquals(wedge.getBricks().get(1), new Coord( -1, 0 ));
    assertEquals(wedge.getBricks().get(2), new Coord( 1, 0 ));
    assertEquals(wedge.getBricks().get(3), new Coord( 1, 1 ));
    assertEquals(wedge.getBricks().get(4), new Coord( 1, 2 ));
  }

  @Test
  public void shouldReturnBricksRelativeToPosition() {
    TetrisBlock block = new TetrisBlock(TetrisShape.HORISONTAL,1);

    assertEquals(block.getBricks().get(0), new Coord( 0, 2 ));
    assertEquals(block.getBricks().get(1), new Coord( -1, 2 ));
    assertEquals(block.getBricks().get(2), new Coord( 1, 2 ));
    assertEquals(block.getBricks().get(3), new Coord( 2, 2 ));
  }

  @Test
  public void shouldReturnBricksRelativeToPosition2() {
    TetrisBlock block = new TetrisBlock(TetrisShape.HORISONTAL,2);

    assertEquals(block.getBricks().get(0), new Coord( 0, 3 ));
    assertEquals(block.getBricks().get(1), new Coord( -1, 3 ));
    assertEquals(block.getBricks().get(2), new Coord( 1, 3 ));
    assertEquals(block.getBricks().get(3), new Coord( 2, 3 ));
  }

  @Test
  public void shouldReturnBricksRelativeToPosition3() {
    TetrisBlock block = new TetrisBlock(TetrisShape.HORISONTAL,3);

    assertEquals(block.getBricks().get(0), new Coord( 0, 4 ));
    assertEquals(block.getBricks().get(1), new Coord( -1, 4 ));
    assertEquals(block.getBricks().get(2), new Coord( 1, 4 ));
    assertEquals(block.getBricks().get(3), new Coord( 2, 4 ));
  }

  @Test
  public void shouldReturnBricksRelativeToPositionAfterMove() {
    TetrisBlock block = new TetrisBlock(TetrisShape.HORISONTAL,3);
    block.moveDown();
    assertEquals(block.getBricks().get(0), new Coord( 0, 3 ));
    assertEquals(block.getBricks().get(1), new Coord( -1, 3 ));
    assertEquals(block.getBricks().get(2), new Coord( 1, 3 ));
    assertEquals(block.getBricks().get(3), new Coord( 2, 3 ));

    block.moveLeft();
    assertEquals(block.getBricks().get(0), new Coord( -1, 3 ));
    assertEquals(block.getBricks().get(1), new Coord( -2, 3 ));
    assertEquals(block.getBricks().get(2), new Coord( 0, 3 ));
    assertEquals(block.getBricks().get(3), new Coord( 1, 3 ));

    block.moveLeft();
    assertEquals(block.getBricks().get(0), new Coord( -2, 3 ));
    assertEquals(block.getBricks().get(1), new Coord( -3, 3 ));
    assertEquals(block.getBricks().get(2), new Coord( -1, 3 ));
    assertEquals(block.getBricks().get(3), new Coord( 0, 3 ));

    block.moveDown();
    assertEquals(block.getBricks().get(0), new Coord( -2, 2 ));
    assertEquals(block.getBricks().get(1), new Coord( -3, 2 ));
    assertEquals(block.getBricks().get(2), new Coord( -1, 2 ));
    assertEquals(block.getBricks().get(3), new Coord( 0, 2 ));
    
    block.moveRight();
    block.moveRight();
    block.moveRight();
    assertEquals(block.getBricks().get(0), new Coord( 1, 2 ));
    assertEquals(block.getBricks().get(1), new Coord( 0, 2 ));
    assertEquals(block.getBricks().get(2), new Coord( 2, 2 ));
    assertEquals(block.getBricks().get(3), new Coord( 3, 2 ));
  }

  @Test
  public void shouldHaveAStartingPosition() {
    TetrisBlock block = new TetrisBlock(TetrisShape.VERTICAL);
    assertEquals(block.getPosition(), new Coord( 0, 0 ));
  }

  @Test
  public void shouldMoveOneStepDown() {
    TetrisBlock block = new TetrisBlock(TetrisShape.VERTICAL);
    block.moveDown();
    assertEquals(block.getPosition(), new Coord( 0, -1 ));
  }

  @Test
  public void shouldMoveOneStepToLeft() {
    TetrisBlock block = new TetrisBlock(TetrisShape.VERTICAL);
    block.moveLeft();
    assertEquals(block.getPosition(), new Coord( -1, 0 ));
  }

  @Test
  public void shouldMoveOneStepToRight() {
    TetrisBlock block = new TetrisBlock(TetrisShape.VERTICAL);
    block.moveRight();
    assertEquals(block.getPosition(), new Coord( 1, 0 ));
  }

  @Test
  public void givenJetPatternToMoveRightShouldMoveCorrectly() {
    TetrisBlock block = new TetrisBlock(TetrisShape.VERTICAL);
    block.move('>');
    assertEquals(block.getPosition(), new Coord( 1, -1 ));
  }
  @Test
  public void givenJetPatternToMoveLeftShouldMoveCorrectly() {
    TetrisBlock block = new TetrisBlock(TetrisShape.VERTICAL);
    block.move('<');
    assertEquals(block.getPosition(), new Coord( -1, -1 ));
  }
}
