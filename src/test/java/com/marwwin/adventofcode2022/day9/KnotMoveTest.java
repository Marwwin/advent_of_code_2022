package com.marwwin.adventofcode2022.day9;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class KnotMoveTest {

  @Test
  public void shouldCreateRightMove() {
    KnotMove move = new KnotMove("R 4");
    assertEquals(move.getDirection(), KnotMoves.RIGHT);
    assertEquals(move.getSteps(), 4);

  }

  @Test
  public void shouldCreateLeftMove() {
    KnotMove move = new KnotMove("L 3");
    assertEquals(move.getDirection(), KnotMoves.LEFT);
    assertEquals(move.getSteps(), 3);
  }

  @Test
  public void shouldCreateUpMove() {
    KnotMove move = new KnotMove("U 2");
    assertEquals(move.getDirection(), KnotMoves.UP);
    assertEquals(move.getSteps(), 2);
  }

  @Test
  public void shouldCreateDownMove() {
    KnotMove move = new KnotMove("D 1");
    assertEquals(move.getDirection(), KnotMoves.DOWN);
    assertEquals(move.getSteps(), 1);
  }

  @Test
  public void testStep() {
    KnotMove move = new KnotMove("U 2");
    assertEquals(move.getSteps(), 2);
    move.step();
    assertEquals(move.getSteps(), 1);
    move.step();
    assertEquals(move.getSteps(), 0);
  }
}
