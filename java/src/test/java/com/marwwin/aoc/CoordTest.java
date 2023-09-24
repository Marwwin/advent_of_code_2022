package com.marwwin.aoc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CoordTest {
  @Test
  public void testEquals2D() {
    Coord coord = new Coord(0, 0);
    assertTrue(coord.equals(new Coord(0, 0)));
    assertFalse(coord.equals(new Coord(1, 0)));
    assertFalse(coord.equals(new Coord(0, 1)));
    assertFalse(coord.equals(new Coord(-1, -1)));
    assertTrue(new Coord(-42, -12).equals(new Coord(-42, -12)));

  }

  @Test
  public void testEquals3D() {
    Coord coord = new Coord(0, 0, 0);
    assertTrue(coord.equals(new Coord(0, 0, 0)));
    assertFalse(coord.equals(new Coord(1, 0, 0)));
    assertFalse(coord.equals(new Coord(0, 1, 0)));
    assertFalse(coord.equals(new Coord(0, 0)));
    assertTrue(new Coord(-42, -12, 6).equals(new Coord(-42, -12, 6)));

  }

  @Test
  public void testGetX() {
    Coord coord = new Coord(42, 21, 7);
    assertEquals((int) coord.getX(), 42);
    coord.setX(11);
    assertEquals((int) coord.getX(), 11);

  }

  @Test
  public void testGetY() {
    Coord coord = new Coord(42, 21, 7);
    assertEquals((int) coord.getY(), 21);
    coord.setY(11);
    assertEquals((int) coord.getY(), 11);
  }

  @Test
  public void testGetZ() {
    Coord coord = new Coord(42, 21, 7);
    assertEquals((int) coord.getZ(), 7);
    coord.setZ(11);
    assertEquals((int) coord.getZ(), 11);
  }

  @Test
  public void testUndefinedZ() {
    Coord coord = new Coord(42, 21);
    assertEquals(coord.getZ(), null);
    coord.setZ(11);
    assertEquals((int) coord.getZ(), 11);
  }
}
