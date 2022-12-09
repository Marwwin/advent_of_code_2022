package com.marwwin.adventofcode2022.day9;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import java.util.Arrays;

import org.junit.Test;

public class KnotTest {
  @Test
  public void shouldInitializeKnot() {
    Knot knot = new Knot();
    assertEquals(knot.getX(), 0);
    assertEquals(knot.getY(), 0);
  }

  @Test
  public void shouldInitializeAKnotWith1Tail() {
    Knot head = new Knot(1);
    assertNotNull(head.getTail());
    assertNull(head.getTail().getTail());
  }

  @Test
  public void shouldInitializeAKnotWithMultiplTails() {
    Knot head = new Knot(3);
    assertNotNull(head.getTail());
    assertNotNull(head.getTail().getTail());
    assertNotNull(head.getTail().getTail().getTail());
    assertNull(head.getTail().getTail().getTail().getTail());
  }

  @Test
  public void shouldSavePosition() {
    Knot knot = new Knot();
    assertEquals(knot.visited.size(), 1);

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

  @Test
  public void shouldReturnDistanceToTail() {
    Knot knot = new Knot(2);
    assertEquals(knot.distanceToTail(), 0);

    knot.setPosition(Arrays.asList(1, 0));
    assertEquals(knot.distanceToTail(), 1);

    knot.setPosition(Arrays.asList(2, 0));
    assertEquals(knot.distanceToTail(), 2);

    knot.setPosition(Arrays.asList(-2, 0));
    assertEquals(knot.distanceToTail(), 2);

    knot.setPosition(Arrays.asList(-2, -2));
    assertEquals(knot.distanceToTail(), 2);

    knot.setPosition(Arrays.asList(0, -2));
    assertEquals(knot.distanceToTail(), 2);

    knot.setPosition(Arrays.asList(0, 2));
    assertEquals(knot.distanceToTail(), 2);
  }

  @Test
  public void shouldMoveUp() {
    Knot knot = new Knot();
    assertEquals(knot.getX(), 0);
    assertEquals(knot.getY(), 0);
    knot.up();
    assertEquals(knot.getX(), 0);
    assertEquals(knot.getY(), 1);
    knot.up();
    assertEquals(knot.getY(), 2);

  }

  @Test
  public void shouldMoveDown() {
    Knot knot = new Knot();
    assertEquals(knot.getX(), 0);
    assertEquals(knot.getY(), 0);
    knot.down();
    assertEquals(knot.getX(), 0);
    assertEquals(knot.getY(), -1);
    knot.down();
    assertEquals(knot.getY(), -2);

  }

  @Test
  public void shouldMoveRight() {
    Knot knot = new Knot();
    assertEquals(knot.getY(), 0);
    assertEquals(knot.getX(), 0);
    knot.right();
    assertEquals(knot.getY(), 0);
    assertEquals(knot.getX(), 1);
    knot.right();
    assertEquals(knot.getX(), 2);
  }

  @Test
  public void shouldMoveLeft() {
    Knot knot = new Knot();
    assertEquals(knot.getY(), 0);
    assertEquals(knot.getX(), 0);
    knot.left();
    assertEquals(knot.getY(), 0);
    assertEquals(knot.getX(), -1);
    knot.left();
    assertEquals(knot.getX(), -2);
  }

  @Test
  public void shouldMoveUpLeft() {
    Knot knot = new Knot();
    assertEquals(knot.getY(), 0);
    assertEquals(knot.getX(), 0);
    knot.upLeft();
    assertEquals(knot.getY(), 1);
    assertEquals(knot.getX(), -1);
  }

  @Test
  public void shouldMoveUpRight() {
    Knot knot = new Knot();
    assertEquals(knot.getY(), 0);
    assertEquals(knot.getX(), 0);
    knot.upRight();
    assertEquals(knot.getY(), 1);
    assertEquals(knot.getX(), 1);
  }

  @Test
  public void shouldMoveDownRight() {
    Knot knot = new Knot();
    assertEquals(knot.getY(), 0);
    assertEquals(knot.getX(), 0);
    knot.downRight();
    assertEquals(knot.getY(), -1);
    assertEquals(knot.getX(), 1);
  }

  @Test
  public void shouldMoveDownLeft() {
    Knot knot = new Knot();
    assertEquals(knot.getY(), 0);
    assertEquals(knot.getX(), 0);
    knot.downLeft();
    assertEquals(knot.getY(), -1);
    assertEquals(knot.getX(), -1);
  }

  @Test
  public void headShouldMoveWhenGivenCommand() {
    Knot head = new Knot();
    head.move("R 4");
    assertEquals(head.getX(), 4);
    assertEquals(head.getY(), 0);
    head.move("L 4");
    assertEquals(head.getX(), 0);
    assertEquals(head.getY(), 0);
    head.move("U 4");
    assertEquals(head.getY(), 4);
    assertEquals(head.getX(), 0);
    head.move("D 4");
    assertEquals(head.getY(), 0);
    assertEquals(head.getX(), 0);
  }

  @Test
  public void tailShouldFollowHeadMovingLeftAndRight() {
    Knot head = new Knot(1);

    head.move("R 2");
    assertEquals(head.getX(), 2);
    assertEquals(head.getY(), 0);
    assertEquals(head.getTail().getX(), 1);
    assertEquals(head.getTail().getY(), 0);

    head.move("L 2");
    assertEquals(head.getX(), 0);
    assertEquals(head.getY(), 0);
    assertEquals(head.getTail().getX(), 1);
    assertEquals(head.getTail().getY(), 0);

    head.move("L 2");
    assertEquals(head.getX(), -2);
    assertEquals(head.getY(), 0);
    assertEquals(head.getTail().getX(), -1);
    assertEquals(head.getTail().getY(), 0);
  }

  @Test
  public void tailShouldFollowHeadMovingUpAndDown() {
    Knot head = new Knot(1);

    head.move("U 2");
    assertEquals(head.getX(), 0);
    assertEquals(head.getY(), 2);
    assertEquals(head.getTail().getX(), 0);
    assertEquals(head.getTail().getY(), 1);

    head.move("D 3");
    assertEquals(head.getX(), 0);
    assertEquals(head.getY(), -1);
    assertEquals(head.getTail().getX(), 0);
    assertEquals(head.getTail().getY(), 0);

    head.move("D 1");
    assertEquals(head.getX(), 0);
    assertEquals(head.getY(), -2);
    assertEquals(head.getTail().getX(), 0);
    assertEquals(head.getTail().getY(), -1);
  }

  @Test
  public void tailShouldFollowHeadMovingDiagonallyUpRight() {
    Knot head = new Knot(1);
    head.move("U 1");
    assertEquals(head.getX(), 0);
    assertEquals(head.getY(), 1);
    assertEquals(head.getTail().getX(), 0);
    assertEquals(head.getTail().getY(), 0);

    head.move("R 2");
    assertEquals(head.getX(), 2);
    assertEquals(head.getY(), 1);
    assertEquals(head.getTail().getX(), 1);
    assertEquals(head.getTail().getY(), 1);
  }

  @Test
  public void tailShouldFollowHeadMovingDiagonallyUpLeft() {
    Knot head = new Knot(1);
    head.move("U 1");
    assertEquals(head.getX(), 0);
    assertEquals(head.getY(), 1);
    assertEquals(head.getTail().getX(), 0);
    assertEquals(head.getTail().getY(), 0);

    head.move("L 2");
    assertEquals(head.getX(), -2);
    assertEquals(head.getY(), 1);
    assertEquals(head.getTail().getX(), -1);
    assertEquals(head.getTail().getY(), 1);
  }

  @Test
  public void tailShouldFollowHeadMovingDiagonallyDownLeft() {
    Knot head = new Knot(1);
    head.move("D 1");
    assertEquals(head.getX(), 0);
    assertEquals(head.getY(), -1);
    assertEquals(head.getTail().getX(), 0);
    assertEquals(head.getTail().getY(), 0);

    head.move("L 2");
    assertEquals(head.getX(), -2);
    assertEquals(head.getY(), -1);
    assertEquals(head.getTail().getX(), -1);
    assertEquals(head.getTail().getY(), -1);
  }

  @Test
  public void tailShouldFollowHeadMovingDiagonallyDownRight() {
    Knot head = new Knot(1);
    head.move("D 1");
    assertEquals(head.getX(), 0);
    assertEquals(head.getY(), -1);
    assertEquals(head.getTail().getX(), 0);
    assertEquals(head.getTail().getY(), 0);

    head.move("R 2");
    assertEquals(head.getX(), 2);
    assertEquals(head.getY(), -1);
    assertEquals(head.getTail().getX(), 1);
    assertEquals(head.getTail().getY(), -1);
  }
}
