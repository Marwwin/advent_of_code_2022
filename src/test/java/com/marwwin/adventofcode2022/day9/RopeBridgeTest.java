package com.marwwin.adventofcode2022.day9;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class RopeBridgeTest {
  @Test
  public void testHeadIsInitialized() {
    RopeBridge bridge = new RopeBridge();
    assertEquals(bridge.head.x(), 0);
    assertEquals(bridge.head.y(), 0);
  }

  @Test
  public void testTailIsInitialized() {
    RopeBridge bridge = new RopeBridge();
    assertEquals(bridge.tail.x(), 0);
    assertEquals(bridge.tail.y(), 0);
  }

  //@Test
  //public void testIsTailTooFarAwayFromHeadRight() {
  //  RopeBridge bridge = new RopeBridge();
  //  bridge.move("R 2");
  //  assertTrue(bridge.isTailTooFarAway());
  //}
//
  //@Test
  //public void testIsTailTooFarAwayFromHeadUp() {
  //  RopeBridge bridge = new RopeBridge();
  //  bridge.move("U 2");
  //  assertTrue(bridge.isTailTooFarAway());
  //}
//
  //@Test
  //public void testIsTailTooFarAwayFromHeadDown() {
  //  RopeBridge bridge = new RopeBridge();
  //  bridge.move("D 2");
  //  assertTrue(bridge.isTailTooFarAway());
  //}
//
  //@Test
  //public void testIsTailTooFarAwayFromHeadLeft() {
  //  RopeBridge bridge = new RopeBridge();
  //  bridge.move("L 2");
  //  assertTrue(bridge.isTailTooFarAway());
  //}

  @Test
  public void testHeadMovesWhenGivenCommand() {
    RopeBridge bridge = new RopeBridge();
    bridge.move("R 4");
    assertEquals(bridge.head.x(), 4);
    assertEquals(bridge.head.y(), 0);
    bridge.move("L 4");
    assertEquals(bridge.head.x(), 0);
    assertEquals(bridge.head.y(), 0);
    bridge.move("U 4");
    assertEquals(bridge.head.y(), 4);
    assertEquals(bridge.head.x(), 0);
    bridge.move("D 4");
    assertEquals(bridge.head.y(), 0);
    assertEquals(bridge.head.x(), 0);
  }

  @Test
  public void testTailFollowHeadMovingLeftAndRight() {
    RopeBridge bridge = new RopeBridge();
    bridge.move("R 1");
    assertEquals(bridge.head.x(), 1);
    assertEquals(bridge.head.y(), 0);
    assertEquals(bridge.tail.x(), 0);
    assertEquals(bridge.tail.y(), 0);

    bridge.move("R 1");
    assertEquals(bridge.head.x(), 2);
    assertEquals(bridge.head.y(), 0);
    assertEquals(bridge.tail.x(), 1);
    assertEquals(bridge.tail.y(), 0);

    bridge.move("L 1");
    assertEquals(bridge.head.x(), 1);
    assertEquals(bridge.head.y(), 0);
    assertEquals(bridge.tail.x(), 1);
    assertEquals(bridge.tail.y(), 0);

    bridge.move("L 1");
    assertEquals(bridge.head.x(), 0);
    assertEquals(bridge.head.y(), 0);
    assertEquals(bridge.tail.x(), 1);
    assertEquals(bridge.tail.y(), 0);

    bridge.move("L 1");
    assertEquals(bridge.head.x(), -1);
    assertEquals(bridge.head.y(), 0);
    assertEquals(bridge.tail.x(), 0);
    assertEquals(bridge.tail.y(), 0);

    bridge.move("L 1");
    assertEquals(bridge.head.x(), -2);
    assertEquals(bridge.head.y(), 0);
    assertEquals(bridge.tail.x(), -1);
    assertEquals(bridge.tail.y(), 0);
  }

  @Test
  public void testTailFollowHeadMovingUpAndDown() {
    RopeBridge bridge = new RopeBridge();
    bridge.move("U 1");
    assertEquals(bridge.head.x(), 0);
    assertEquals(bridge.head.y(), 1);
    assertEquals(bridge.tail.x(), 0);
    assertEquals(bridge.tail.y(), 0);

    bridge.move("U 1");
    assertEquals(bridge.head.x(), 0);
    assertEquals(bridge.head.y(), 2);
    assertEquals(bridge.tail.x(), 0);
    assertEquals(bridge.tail.y(), 1);

    bridge.move("D 1");
    assertEquals(bridge.head.x(), 0);
    assertEquals(bridge.head.y(), 1);
    assertEquals(bridge.tail.x(), 0);
    assertEquals(bridge.tail.y(), 1);

    bridge.move("D 1");
    assertEquals(bridge.head.x(), 0);
    assertEquals(bridge.head.y(), 0);
    assertEquals(bridge.tail.x(), 0);
    assertEquals(bridge.tail.y(), 1);

    bridge.move("D 1");
    assertEquals(bridge.head.x(), 0);
    assertEquals(bridge.head.y(), -1);
    assertEquals(bridge.tail.x(), 0);
    assertEquals(bridge.tail.y(), 0);

    bridge.move("D 1");
    assertEquals(bridge.head.x(), 0);
    assertEquals(bridge.head.y(), -2);
    assertEquals(bridge.tail.x(), 0);
    assertEquals(bridge.tail.y(), -1);
  }

  @Test
  public void testTailFollowHeadMovingDiagonallyUpRight() {
    RopeBridge bridge = new RopeBridge();
    bridge.move("U 1");
    assertEquals(bridge.head.x(), 0);
    assertEquals(bridge.head.y(), 1);
    assertEquals(bridge.tail.x(), 0);
    assertEquals(bridge.tail.y(), 0);

    bridge.move("R 1");
    assertEquals(bridge.head.x(), 1);
    assertEquals(bridge.head.y(), 1);
    assertEquals(bridge.tail.x(), 0);
    assertEquals(bridge.tail.y(), 0);

    bridge.move("R 1");
    assertEquals(bridge.head.x(), 2);
    assertEquals(bridge.head.y(), 1);
    assertEquals(bridge.tail.x(), 1);
    assertEquals(bridge.tail.y(), 1);
  }

  @Test
  public void testTailFollowHeadMovingDiagonallyUpLeft() {
    RopeBridge bridge = new RopeBridge();
    bridge.move("U 1");
    assertEquals(bridge.head.x(), 0);
    assertEquals(bridge.head.y(), 1);
    assertEquals(bridge.tail.x(), 0);
    assertEquals(bridge.tail.y(), 0);

    bridge.move("L 1");
    assertEquals(bridge.head.x(), -1);
    assertEquals(bridge.head.y(), 1);
    assertEquals(bridge.tail.x(), 0);
    assertEquals(bridge.tail.y(), 0);

    bridge.move("L 1");
    assertEquals(bridge.head.x(), -2);
    assertEquals(bridge.head.y(), 1);
    assertEquals(bridge.tail.x(), -1);
    assertEquals(bridge.tail.y(), 1);
  }

  @Test
  public void testTailFollowHeadMovingDiagonallyDownLeft() {
    RopeBridge bridge = new RopeBridge();
    bridge.move("D 1");
    assertEquals(bridge.head.x(), 0);
    assertEquals(bridge.head.y(), -1);
    assertEquals(bridge.tail.x(), 0);
    assertEquals(bridge.tail.y(), 0);

    bridge.move("L 1");
    assertEquals(bridge.head.x(), -1);
    assertEquals(bridge.head.y(), -1);
    assertEquals(bridge.tail.x(), 0);
    assertEquals(bridge.tail.y(), 0);

    bridge.move("L 1");
    assertEquals(bridge.head.x(), -2);
    assertEquals(bridge.head.y(), -1);
    assertEquals(bridge.tail.x(), -1);
    assertEquals(bridge.tail.y(), -1);
  }

  @Test
  public void testTailFollowHeadMovingDiagonallyDownRight() {
    RopeBridge bridge = new RopeBridge();
    bridge.move("D 1");
    assertEquals(bridge.head.x(), 0);
    assertEquals(bridge.head.y(), -1);
    assertEquals(bridge.tail.x(), 0);
    assertEquals(bridge.tail.y(), 0);

    bridge.move("R 1");
    assertEquals(bridge.head.x(), 1);
    assertEquals(bridge.head.y(), -1);
    assertEquals(bridge.tail.x(), 0);
    assertEquals(bridge.tail.y(), 0);

    bridge.move("R 1");
    assertEquals(bridge.head.x(), 2);
    assertEquals(bridge.head.y(), -1);
    assertEquals(bridge.tail.x(), 1);
    assertEquals(bridge.tail.y(), -1);
  }

  @Test
  public void testKnotShouldRememberVisited(){
    RopeBridge bridge = new RopeBridge();
    bridge.head.setX(2);
    bridge.head.setY(-2);
    bridge.tail.setX(3);
    bridge.tail.setY(-3);
    bridge.move("U 1");
    assertEquals(bridge.tail.x(), 2);
    assertEquals(bridge.tail.y(), -2);

  }


}
