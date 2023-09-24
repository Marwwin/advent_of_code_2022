package com.marwwin.adventofcode2022.day17;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigInteger;

import org.junit.Test;

import com.marwwin.adventofcode2022.day14.Unit;
import com.marwwin.aoc.AoC;
import com.marwwin.aoc.Coord;

public class TetrisTest {

  @Test
  public void shouldBeAbleToCreateATetrisGameWithDifferentWidths() {
    Tetris tetrisWidth7 = new Tetris(7);
    assertEquals(7, tetrisWidth7.getWidth());

    Tetris tetrisWidth11 = new Tetris(11);
    assertEquals(11, tetrisWidth11.getWidth());
  }

  @Test
  public void gameShouldHaveWalls() {
    Tetris tetris = new Tetris(7);
    assertTrue(tetris.isInsideArea(new Coord(0, 0)));
    assertFalse(tetris.isInsideArea(new Coord(-4, 0)));
    assertFalse(tetris.isInsideArea(new Coord(4, 0)));
  }

  @Test
  public void shouldBeAbleToSetPattern() {
    Tetris tetris = new Tetris(7);
    tetris.setPattern(AoC.getInputAsString("day17", true));
    assertEquals('>', tetris.getPattern().charAt(0));
    assertEquals('>', tetris.getPattern().charAt(1));
    assertEquals('>', tetris.getPattern().charAt(2));
    assertEquals('<', tetris.getPattern().charAt(3));
    assertEquals('<', tetris.getPattern().charAt(4));
    assertEquals('>', tetris.getPattern().charAt(5));
  }

  @Test
  public void shouldNewlyCreatedBlockShouldBePushedToStack() {
    Tetris tetris = new Tetris(7);
    TetrisBlock block = tetris.spawnNext();
    assertEquals(TetrisShape.HORISONTAL, block.getShape());
    assertEquals(new Coord(0, 4), block.getPosition());
    assertEquals(block, tetris.currentBlock());
  }

  @Test
  public void shouldDropBlock() {
    Tetris tetris = new Tetris(7);
    tetris.spawnNext();
    assertEquals(new Coord(0, 4), tetris.currentBlock().getPosition());
    tetris.move(' ');
    assertEquals(new Coord(0, 3), tetris.currentBlock().getPosition());
    tetris.move(' ');
  }

  @Test
  public void shouldSaveBlockWhenItReachesFloor() {
    Tetris tetris = new Tetris(7);
    tetris.drop(tetris.spawn(TetrisShape.HORISONTAL));
    assertEquals(Unit.ROCK, tetris.at(-1, 1));
    assertEquals(Unit.ROCK, tetris.at(0, 1));
    assertEquals(Unit.ROCK, tetris.at(1, 1));
    assertEquals(Unit.ROCK, tetris.at(2, 1));
  }

  @Test
  public void shouldAcceptAJetPatternMovingRight() {
    Tetris tetris = new Tetris(7, AoC.getInputAsString("day17", true).get(0));
    tetris.spawnNext();
    assertEquals(new Coord(0, 4), tetris.currentBlock().getPosition());
    assertEquals(2, tetris.currentBlock().getRightBoundary());
    tetris.move('>');

    assertEquals(new Coord(1, 3), tetris.currentBlock().getPosition());
    assertEquals(tetris.currentBlock().getRightBoundary(), 3);
    tetris.move('>');
    assertEquals(tetris.currentBlock().getRightBoundary(), 3);

  }

  @Test
  public void shouldAcceptAJetPatternMovingLeft() {
    Tetris tetris = new Tetris(7, AoC.getInputAsString("day17", true).get(0));
    tetris.spawn(TetrisShape.HORISONTAL);

    assertEquals(new Coord(0, 4), tetris.currentBlock().getPosition());
    assertEquals(-1, tetris.currentBlock().getLeftBoundary());
    tetris.move('<');

    assertEquals(new Coord(-1, 3), tetris.currentBlock().getPosition());
    assertEquals(-2, tetris.currentBlock().getLeftBoundary());
    tetris.move('<');
    assertEquals(-3, tetris.currentBlock().getLeftBoundary());
    tetris.move('<');
    assertEquals(-3, tetris.currentBlock().getLeftBoundary());
  }

  @Test
  public void shouldNotGoThroughRockWhenMovingLeft() {
    Tetris tetris = new Tetris(7, AoC.getInputAsString("day17", true).get(0));
    tetris.setPattern(">>>><><>><<<>><>>><<<>>><<<><<<>><>><<>>");
    tetris.drop(tetris.spawn(TetrisShape.VERTICAL));
    tetris.print();

  }

  @Test
  public void shouldReturnHeightOfRocksWhenNoRocks() {
    Tetris tetris = new Tetris(7, AoC.getInputAsString("day17", true).get(0));
    assertEquals(0, tetris.heightOfRocks());
  }

  @Test
  public void shouldReturnHeightOfRocksWhenOneHorisontal() {
    Tetris tetris = new Tetris(7, AoC.getInputAsString("day17", true).get(0));
    TetrisBlock horisontal = tetris.spawn(TetrisShape.HORISONTAL);
    tetris.drop(horisontal);
    assertEquals(1, tetris.heightOfRocks());
  }

  @Test
  public void shouldReturnHeightOfRocksWhenOneBox() {
    Tetris tetris = new Tetris(7, AoC.getInputAsString("day17", true).get(0));
    TetrisBlock box = tetris.spawn(TetrisShape.BOX);
    tetris.drop(box);
    assertEquals(2, tetris.heightOfRocks());
  }

  @Test
  public void shouldReturnHeightOfRocksWhenOneVertical() {
    Tetris tetris = new Tetris(7, AoC.getInputAsString("day17", true).get(0));
    TetrisBlock vertical = tetris.spawn(TetrisShape.VERTICAL);
    tetris.drop(vertical);
    assertEquals(4, tetris.heightOfRocks());
  }

  @Test
  public void shouldReturnHeightOfRocksWhenOneStar() {
    Tetris tetris = new Tetris(7, AoC.getInputAsString("day17", true).get(0));
    TetrisBlock star = tetris.spawn(TetrisShape.STAR);
    tetris.drop(star);
    assertEquals(3, tetris.heightOfRocks());
  }

  @Test
  public void shouldReturnHeightOfRocksWhenOneWedge() {
    Tetris tetris = new Tetris(7, AoC.getInputAsString("day17", true).get(0));
    TetrisBlock wedge = tetris.spawn(TetrisShape.WEDGE);
    tetris.drop(wedge);
    assertEquals(3, tetris.heightOfRocks());
  }

  @Test
  public void shouldReturnHeightOfRocksAfterStarHorisontal() {
    Tetris tetris = new Tetris(7, AoC.getInputAsString("day17", true).get(0));
    tetris.drop(tetris.spawn(TetrisShape.STAR));
    tetris.drop(tetris.spawn(TetrisShape.HORISONTAL));
    assertEquals(4, tetris.heightOfRocks());
  }

  @Test
  public void shouldReturnHeightOfRocksAfterMultipleBlocks() {
    Tetris tetris = new Tetris(7, AoC.getInputAsString("day17", true).get(0));
    tetris.drop(tetris.spawn(TetrisShape.STAR));
    tetris.drop(tetris.spawn(TetrisShape.HORISONTAL));
    assertEquals(4, tetris.heightOfRocks());
    tetris.drop(tetris.spawn(TetrisShape.WEDGE));
    assertEquals(7, tetris.heightOfRocks());
    tetris.drop(tetris.spawn(TetrisShape.BOX));
    assertEquals(7, tetris.heightOfRocks());
    tetris.drop(tetris.spawn(TetrisShape.VERTICAL));
    assertEquals(11, tetris.heightOfRocks());
    tetris.print();
  }

  @Test
  public void shouldWorkForTestData() {
    Tetris tetris = new Tetris(7, AoC.getInputAsString("day17", true).get(0));
    tetris.play(2022);
    assertEquals(tetris.heightOfRocks(), 3068);
  }

  @Test
  public void shouldWorkForTestDataPart2() {
    Tetris tetris = new Tetris(7, AoC.getInputAsString("day17", true).get(0));

    assertEquals(true, tetris.isRepeat(2));
    tetris.drop(tetris.spawn(TetrisShape.STAR));
    assertEquals(false, tetris.isRepeat(2));

  }
  @Test
  public void shouldFindRepetition() {
    Tetris tetris = new Tetris(7, AoC.getInputAsString("day17", true).get(0));
    tetris.play(900);
    //assertEquals(false, tetris.isRepeat(2));
    System.out.println("");
  }
  @Test
  public void shouldWorkForRealData() {
    Tetris tetris = new Tetris(7, AoC.getInputAsString("day17", false).get(0));

    tetris.play(50460);
    long first = tetris.heightOfRocks();
    System.out.println("first set of rounds " + first);

    tetris.getPatternIndex();

    tetris.play(50460);
    long second = tetris.heightOfRocks();
    System.out.println("after second set of rounds " + second);
    tetris.getPatternIndex();

    tetris.play(50460);
    long third = tetris.heightOfRocks();
    System.out.println("after third set of rounds " + third);
    tetris.getPatternIndex();

    tetris.play(50460);
    long fourth = tetris.heightOfRocks();
    System.out.println("after fourth set of rounds " + fourth);
    // assertEquals(tetris.heightOfRocks(), 3068);
    int mod = 18580;
    System.out.println(tetris.heightOfRocks());
    tetris.play(mod);
    System.out.println(tetris.heightOfRocks());
    // int times = tetris.heightOfRocks() * 19817677;
    // 1504122048946
  }

  @Test
  public void shouldWorkForRemanderData() {
    Tetris tetris = new Tetris(7, AoC.getInputAsString("day17", false).get(0));
    tetris.play(18580);
    assertEquals(tetris.heightOfRocks(), 3068);
    // int times = tetris.heightOfRocks() * 19817677;
    // 1504122048946
  }

  @Test
  public void shouldReturnCorrectHeightsAfterSomeRounds() {
    Tetris tetris = new Tetris(7, AoC.getInputAsString("day17", true).get(0));
    tetris.setPattern(">>><<><>><<<>><>>><<<>>><<<><<<>><>><<>>");
    tetris.play(1);
    tetris.print();
    assertEquals(1, tetris.heightOfRocks());
    tetris.play(1);
    assertEquals(4, tetris.heightOfRocks());

  }
}
