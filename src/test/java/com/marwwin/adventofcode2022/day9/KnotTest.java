package com.marwwin.adventofcode2022.day9;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class KnotTest {
  @Test
  public void shouldCreateAKnotWithStartPos() {
    Knot knot = new Knot();
    List<Integer> startPosition = new ArrayList<Integer>();
    startPosition.add(0);
    startPosition.add(0);
    startPosition.set(1, 0);
    assertEquals(knot.position(), startPosition);
    assertEquals(knot.x(), 0);
    assertEquals(knot.y(), 0);
  }

  @Test
  public void shouldMoveUp() {
    Knot knot = new Knot();
    assertEquals(knot.x(), 0);
    assertEquals(knot.y(), 0);
    knot.up();
    assertEquals(knot.x(), 0);
    assertEquals(knot.y(), 1);
    knot.up();
    assertEquals(knot.y(), 2);

  }

  @Test
  public void shouldMoveDown() {
    Knot knot = new Knot();
    assertEquals(knot.x(), 0);
    assertEquals(knot.y(), 0);
    knot.down();
    assertEquals(knot.x(), 0);
    assertEquals(knot.y(), -1);
    knot.down();
    assertEquals(knot.y(), -2);

  }

  @Test
  public void shouldMoveRight() {
    Knot knot = new Knot();
    assertEquals(knot.y(), 0);
    assertEquals(knot.x(), 0);
    knot.right();
    assertEquals(knot.y(), 0);
    assertEquals(knot.x(), 1);
    knot.right();
    assertEquals(knot.x(), 2);
  }

  @Test
  public void shouldMoveLeft() {
    Knot knot = new Knot();
    assertEquals(knot.y(), 0);
    assertEquals(knot.x(), 0);
    knot.left();
    assertEquals(knot.y(), 0);
    assertEquals(knot.x(), -1);
    knot.left();
    assertEquals(knot.x(), -2);
  }

  @Test
  public void shouldMoveUpLeft() {
    Knot knot = new Knot();
    assertEquals(knot.y(), 0);
    assertEquals(knot.x(), 0);
    knot.upLeft();
    assertEquals(knot.y(), 1);
    assertEquals(knot.x(), -1);
  }

  @Test
  public void shouldMoveUpRIGHT() {
    Knot knot = new Knot();
    assertEquals(knot.y(), 0);
    assertEquals(knot.x(), 0);
    knot.upRight();
    assertEquals(knot.y(), 1);
    assertEquals(knot.x(), 1);
  }

  @Test
  public void shouldMoveDownRIGHT() {
    Knot knot = new Knot();
    assertEquals(knot.y(), 0);
    assertEquals(knot.x(), 0);
    knot.downRight();
    assertEquals(knot.y(), -1);
    assertEquals(knot.x(), 1);
  }

  @Test
  public void shouldSavePosition() {
    Knot knot = new Knot();
    knot.savePosition();
    knot.up();
    knot.savePosition();
    knot.down();
    knot.savePosition();
    assertEquals(knot.visited.size(), 2);

    knot.right();
    knot.savePosition();
    knot.left();
    knot.savePosition();
    assertEquals(knot.visited.size(), 3);
  }

}
