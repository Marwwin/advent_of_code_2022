package com.marwwin.adventofcode2022.day18;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.marwwin.aoc.Directions;

public class CubeTest {
  @Test
  public void shouldCreateCube() {
    Cube cube = new Cube(0, 0, 0);
    assertEquals(cube.getX(), 0);
    assertEquals(cube.getY(), 0);
    assertEquals(cube.getZ(), 0);

    Cube cube2 = new Cube(42, 69, 420);
    assertEquals(cube2.getX(), 42);
    assertEquals(cube2.getY(), 69);
    assertEquals(cube2.getZ(), 420);
  }

  @Test
  public void shouldCreateCubeFromString() {
    Cube cube = new Cube("2,2,2");
    assertEquals(cube.getX(), 2);
    assertEquals(cube.getY(), 2);
    assertEquals(cube.getZ(), 2);
  
  }


  @Test
  public void shouldBeAbleToSetSides() {
    Cube cube = new Cube(0, 0, 0);

    assertFalse(cube.isRight());
    assertFalse(cube.isLeft());
    assertFalse(cube.isUp());
    assertFalse(cube.isDown());
    assertFalse(cube.isAbove());
    assertFalse(cube.isBelow());
    assertEquals(cube.exposedSides(), 6);

    cube.setRight(true);
    assertEquals(cube.exposedSides(), 5);

    cube.setLeft(true);
    assertEquals(cube.exposedSides(), 4);

    cube.setUp(true);
    assertEquals(cube.exposedSides(), 3);

    cube.setDown(true);
    assertEquals(cube.exposedSides(), 2);

    cube.setBelow(true);
    assertEquals(cube.exposedSides(), 1);

    cube.setAbove(true);
    assertEquals(cube.exposedSides(), 0);

    assertTrue(cube.isRight());
    assertTrue(cube.isLeft());
    assertTrue(cube.isUp());
    assertTrue(cube.isDown());
    assertTrue(cube.isAbove());
    assertTrue(cube.isBelow());
  }
  @Test
  public void shouldTestToWhichXDirectionIsConnected() {
    Cube cube = new Cube(0, 0, 0);
    assertEquals(cube.isConnected(new Cube(1, 0, 0)), Directions.RIGHT);
    assertEquals(cube.isConnected(new Cube(-1, 0, 0)), Directions.LEFT);
  }

  @Test
  public void shouldTestToWhichYDirectionIsConnected() {
    Cube cube = new Cube(0, 0, 0);
    assertEquals(cube.isConnected(new Cube(0, 1, 0)), Directions.UP);
    assertEquals(cube.isConnected(new Cube(0, -1, 0)), Directions.DOWN);
  }

  @Test
  public void shouldTestToWhichZDirectionIsConnected() {
    Cube cube = new Cube(0, 0, 0);
    assertEquals(cube.isConnected(new Cube(0, 0, 1)), Directions.FORWARD);
    assertEquals(cube.isConnected(new Cube(0, 0, -1)), Directions.BACKWARD);
  }

  @Test
  public void shouldNotBeConnected() {
    Cube cube = new Cube(0, 0, 0);
    assertEquals(cube.isConnected(new Cube(0, 1, 1)), null);
    assertEquals(cube.isConnected(new Cube(1, 1, 1)), null);
    assertEquals(cube.isConnected(new Cube(-1, 1, 0)), null);
    assertEquals(cube.isConnected(new Cube(-1, 0, -1)), null);
    assertEquals(cube.isConnected(new Cube(0, -1, -1)), null);
  }
}
