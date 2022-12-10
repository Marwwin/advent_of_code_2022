package com.marwwin.adventofcode2022.day9;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


import org.junit.Test;

import com.marwwin.aoc.Directions;

public class KnotMoveTest {

  @Test
  public void shouldCreateRightMove() {
    KnotMove move = new KnotMove("R 4");
    assertEquals(move.getDirection(), Directions.RIGHT);
    assertEquals(move.getStepsRemaining(), 4);
  }

  @Test
  public void shouldCreateLeftMove() {
    KnotMove move = new KnotMove("L 3");
    assertEquals(move.getDirection(), Directions.LEFT);
    assertEquals(move.getStepsRemaining(), 3);
  }

  @Test
  public void shouldCreateUpMove() {
    KnotMove move = new KnotMove("U 2");
    assertEquals(move.getDirection(), Directions.UP);
    assertEquals(move.getStepsRemaining(), 2);
  }

  @Test
  public void shouldCreateDownMove() {
    KnotMove move = new KnotMove("D 1");
    assertEquals(move.getDirection(), Directions.DOWN);
    assertEquals(move.getStepsRemaining(), 1);
  }

  @Test
  public void shouldCreateUpRightMove() {
    KnotMove move = new KnotMove("UR 42");
    assertEquals(move.getDirection(), Directions.UPRIGHT);
    assertEquals(move.getStepsRemaining(), 42);
  }

  @Test
  public void shouldCreateUpLeftMove() {
    KnotMove move = new KnotMove("UL 5");
    assertEquals(move.getDirection(), Directions.UPLEFT);
    assertEquals(move.getStepsRemaining(), 5);
  }

  @Test
  public void shouldCreateDownLeftMove() {
    KnotMove move = new KnotMove("DL 7");
    assertEquals(move.getDirection(), Directions.DOWNLEFT);
    assertEquals(move.getStepsRemaining(), 7);
  }

  @Test
  public void shouldCreateDownRightMove() {
    KnotMove move = new KnotMove("DR 1");
    assertEquals(move.getDirection(), Directions.DOWNRIGHT);
    assertEquals(move.getStepsRemaining(), 1);
  }

  @Test
  public void shouldDecreseStepCountOnNextStep() {
    KnotMove move = new KnotMove("U 2");
    assertEquals(move.getStepsRemaining(), 2);
    assertTrue(move.nextStep());
    assertEquals(move.getStepsRemaining(), 1);
    assertTrue(move.nextStep());
    assertEquals(move.getStepsRemaining(), 0);
    assertFalse(move.nextStep());
  }
}
