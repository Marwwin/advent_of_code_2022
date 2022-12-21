package com.marwwin.adventofcode2022.day17;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.marwwin.adventofcode2022.aoc.Position;
import com.marwwin.adventofcode2022.day14.Unit;
import com.marwwin.aoc.AoC;
import com.marwwin.aoc.Coord;

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
    assertEquals(tetris.isInsideArea(new Coord(0, 0)), true);
    assertEquals(tetris.isInsideArea(new Coord(-4, 0)), false);
    assertEquals(tetris.isInsideArea(new Coord(4, 0)), false);
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
    assertEquals(block.getPosition(), new Coord(0, 5));
    assertEquals(tetris.currentBlock(), block);
  }

  @Test
  public void shouldDropBlock() {
    Tetris tetris = new Tetris(7);
    tetris.spawnNext();
    assertEquals(tetris.currentBlock().getPosition(), new Coord(0, 5));
    tetris.move(' ');
    assertEquals(tetris.currentBlock().getPosition(), new Coord(0, 4));
    tetris.move(' ');
  }

  @Test
  public void shouldDropBlockToFloor() {
    Tetris tetris = new Tetris(7);
    tetris.spawnNext();

  }

  @Test
  public void shouldSaveBlockWhenItReachesFloor() {
    Tetris tetris = new Tetris(7);
    tetris.drop(tetris.spawn(TetrisShape.HORISONTAL));
    assertEquals(tetris.at(-1, 1), Unit.ROCK);
    assertEquals(tetris.at(0, 1), Unit.ROCK);
    assertEquals(tetris.at(1, 1), Unit.ROCK);
    assertEquals(tetris.at(2, 1), Unit.ROCK);
  }

  @Test
  public void shouldSaveBlockWhenIfItLandsOnOtherRock() {
    Tetris tetris = new Tetris(7);
    tetris.spawnNext();
    tetris.move(' ');
    ;
    tetris.move(' ');
    ;
    tetris.print();
  }

  @Test
  public void shouldAcceptAJetPatternMovingRight() {
    Tetris tetris = new Tetris(7, AoC.getInputAsString("day17", true).get(0));
    tetris.spawnNext();
    assertEquals(tetris.currentBlock().getPosition(), new Coord(0, 5));
    assertEquals(tetris.currentBlock().getRightBoundary(), 2);
    tetris.move('>');

    assertEquals(tetris.currentBlock().getPosition(), new Coord(1, 4));
    assertEquals(tetris.currentBlock().getRightBoundary(), 3);
    tetris.move('>');
    assertEquals(tetris.currentBlock().getRightBoundary(), 3);

  }

  @Test
  public void shouldAcceptAJetPatternMovingLeft() {
    Tetris tetris = new Tetris(7, AoC.getInputAsString("day17", true).get(0));
    tetris.spawn(TetrisShape.HORISONTAL);

    assertEquals(tetris.currentBlock().getPosition(), new Coord(0, 5));
    assertEquals(tetris.currentBlock().getLeftBoundary(), -1);
    tetris.move('<');

    assertEquals(tetris.currentBlock().getPosition(), new Coord(-1, 4));
    assertEquals(tetris.currentBlock().getLeftBoundary(), -2);
    tetris.move('<');
    assertEquals(tetris.currentBlock().getLeftBoundary(), -3);
    tetris.move('<');
    assertEquals(tetris.currentBlock().getLeftBoundary(), -3);
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
    tetris.setPattern(">>><<><>><<<>><>>><<<>>><<<><<<>><>><<>>");
    tetris.play(2022);
    assertEquals(tetris.heightOfRocks(), 3068);
  }

  @Test
  public void shouldcorrectMovesForPattern() {
    Tetris tetris = new Tetris(7, AoC.getInputAsString("day17", true).get(0));
    tetris.setPattern(">>><<><>><<<>><>>><<<>>><<<><<<>><>><<>>");
    tetris.play(1);
    assertEquals(tetris.heightOfRocks(), 3068);
  }
}
