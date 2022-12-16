package com.marwwin.adventofcode2022.day12;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.marwwin.aoc.AoC;

public class HillTest {

  Hill realDataHill = new Hill(AoC.getInputAsString("day12", false));
  Hill testDataHill = new Hill(AoC.getInputAsString("day12", true));

  @Test
  public void shouldCreateGraph() {
    assertEquals(testDataHill.getStart().getX(), 0);
    assertEquals(testDataHill.getStart().getY(), 0);

    assertEquals(testDataHill.getStart().getRight().getX(), 1);
    assertEquals(testDataHill.getStart().getRight().getRight().getX(), 2);
    assertEquals(testDataHill.getStart().getRight().getRight().getDown().getY(), 1);
    assertEquals(testDataHill.getStart().getRight().getRight().getDown().getDown().getUp().getY(), 1);
  }

  @Test
  public void shouldFindEnd() {
    HillNode end = testDataHill.findShortest(testDataHill.getStart());
    assertEquals(end.getX(), 5);
    assertEquals(end.getY(), 2);
  }

  @Test
  public void shouldGetLength() {
    HillNode end = testDataHill.findShortest(testDataHill.getStart());
    assertEquals(testDataHill.getRouteLength(end), 31);
  }

  @Test
  public void shouldGetPart1RealData() {
    HillNode end = realDataHill.findShortest(realDataHill.getStart());
    assertEquals(realDataHill.getRouteLength(end), 361);
  }

  @Test
  public void shouldGetPart2TestData() {
    assertEquals(testDataHill.findShortestFroma(), 29);
  }

  @Test
  public void shouldGetPart2RealData() {
    assertEquals(realDataHill.findShortestFroma(), 354);
  }
}
