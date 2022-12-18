package com.marwwin.adventofcode2022.day17;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.marwwin.adventofcode2022.aoc.Position;
import com.marwwin.adventofcode2022.day14.Unit;
import com.marwwin.aoc.AoC;

public class TetrisTest {

  @Test
  public void shouldBeAbleToCreateATetrisGameWithDifferentWidths() {
    Tetris tetrisWidth7 = new Tetris(7);
    assertEquals(tetrisWidth7.getWidth(), 7);

    Tetris tetrisWidth11 = new Tetris(11);
    assertEquals(tetrisWidth11.getWidth(), 11);
  }


  @Test
  public void gameShouldHaveWalls() {
    Tetris tetris = new Tetris(7);
    assertEquals(tetris.isInsideArea(new Position(0, 0)), true);
    assertEquals(tetris.isInsideArea(new Position(-4, 0)), false);
    assertEquals(tetris.isInsideArea(new Position(4, 0)), false);
  }

  @Test
  public void shouldBeAbleToSetPattern() {
    Tetris tetris = new Tetris(7);
    tetris.setPattern(AoC.getInputAsString("day17", true));
    assertEquals(tetris.getPattern().charAt(0), '>');
    assertEquals(tetris.getPattern().charAt(1), '>');
    assertEquals(tetris.getPattern().charAt(2), '>');
    assertEquals(tetris.getPattern().charAt(3), '<');
    assertEquals(tetris.getPattern().charAt(4), '<');
    assertEquals(tetris.getPattern().charAt(5), '>');
  }

  @Test
  public void shouldNewlyCreatedBlockShouldBePushedToStack() {
    Tetris tetris = new Tetris(7);
    TetrisBlock block = tetris.spawnNext();
    assertEquals(block.getShape(), TetrisShape.HORISONTAL);
    assertArrayEquals(block.getPosition(), new int[] { 0, 3 });
    assertEquals(tetris.currentBlock(), block);
  }

  @Test
  public void shouldDropBlock() {
    Tetris tetris = new Tetris(7);
    tetris.spawnNext();
    assertArrayEquals(tetris.currentBlock().getPosition(), new int[]{0,3});
    tetris.move(' ');;
    assertArrayEquals(tetris.currentBlock().getPosition(), new int[]{0,2});
    tetris.move(' ');;
  }

  @Test
  public void shouldSaveBlockWhenItReachesFloor() {
    Tetris tetris = new Tetris(7);
    tetris.spawnNext();
    tetris.move(' ');;
    tetris.move(' ');;
    assertEquals(tetris.at(-1,1), Unit.ROCK);
    assertEquals(tetris.at(0,1), Unit.ROCK);
    assertEquals(tetris.at(1,1), Unit.ROCK);
    assertEquals(tetris.at(2,1), Unit.ROCK);
  }

  @Test
  public void shouldSaveBlockWhenIfItLandsOnOtherRock() {
    Tetris tetris = new Tetris(7);
    tetris.spawnNext();
    tetris.move(' ');;
    tetris.move(' ');;
    tetris.print();
  }
  @Test
  public void shouldAcceptAJetPattern() {
    Tetris tetris = new Tetris(7,AoC.getInputAsString("day17", true).get(0));
    tetris.spawnNext();
    assertArrayEquals(tetris.currentBlock().getPosition(), new int []{0,3});
    assertEquals(tetris.currentBlock().getRightBoundary(),2);
    tetris.move('>');

    System.out.println(tetris.currentBlock().getPosition()[0]+ " "+tetris.currentBlock().getPosition()[1]);
    System.out.println(tetris.currentBlock().getBricks());
    assertArrayEquals(tetris.currentBlock().getPosition(), new int []{1,2});
    assertEquals(tetris.currentBlock().getRightBoundary(), 3);
    tetris.move('>');
    assertEquals(tetris.currentBlock().getRightBoundary(), 3);

  }
}
