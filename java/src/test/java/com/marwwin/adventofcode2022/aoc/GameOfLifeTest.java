package com.marwwin.adventofcode2022.aoc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.junit.Test;

import com.marwwin.aoc.Matrix;

public class GameOfLifeTest {
  @Test
  public void shouldReturnAmountOfNeighbours() {
    GameOfLife game = new GameOfLife();
    game.setCell(0 + "x" + 0, true);
    assertEquals(game.amountOfNeighbours(new Position("0x0")), 0);
    game.setCell(1 + "x" + 0, true);
    assertEquals(game.amountOfNeighbours(new Position("0x0")), 1);
    game.setCell(-1 + "x" + 0, true);
    assertEquals(game.amountOfNeighbours(new Position("0x0")), 2);
    game.setCell(0 + "x" + -1, true);
    assertEquals(game.amountOfNeighbours(new Position("0x0")), 3);
    game.setCell(0 + "x" + 1, true);
    assertEquals(game.amountOfNeighbours(new Position("0x0")), 4);
  }

  @Test
  public void name() {
    
  }
  // @Test
  // public void shouldReturnABooleanForCell(){
  // GameOfLife game = new GameOfLife();
  // game.setCell(new Cell(0,0));
  // assertEquals(game.getCell(new Cell(0,0)), true);
  // }
  // @Test
  // public void doesCellHaveLeftOrRightNeighbour(){
  // GameOfLife game = new GameOfLife();
  // game.setCell(new Cell(0,0));
  // assertEquals(game.hasLeft(new Cell(0,0)), true);
  // }
  // @Test
  // public void shouldReturnAmountOfNeighbours(){
  // GameOfLife game = new GameOfLife();
  // game.setCell(new Cell(0,0));
  // assertEquals(game.getCell(new Cell(0,0)), true);
  // }

}
