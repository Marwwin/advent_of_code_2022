package com.marwwin.adventofcode2022.day12;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.marwwin.aoc.AoC;

public class HillV2BFSTest {

  @Test
  public void shouldCreateGraph() {
    HillV2BFS hill = new HillV2BFS(AoC.getInputAsString("day12", true));
    assertEquals(hill.getStart().getX(), 0);
    assertEquals(hill.getStart().getY(), 0);

    assertEquals(hill.getStart().getRight().getX(), 1);
    assertEquals(hill.getStart().getRight().getRight().getX(), 2);
    assertEquals(hill.getStart().getRight().getRight().getDown().getY(), 1);
    assertEquals(hill.getStart().getRight().getRight().getDown().getDown().getUp().getY(), 1);
  }

  @Test
  public void shouldFindEnd() {
    HillV2BFS hill = new HillV2BFS(AoC.getInputAsString("day12", true));
    HillNode end = hill.findShortest(hill.getStart());
    assertEquals(end.getX(), 5);
    assertEquals(end.getY(), 2);
  }

  @Test
  public void shouldGetLength() {
    HillV2BFS hill = new HillV2BFS(AoC.getInputAsString("day12", true));
    HillNode end = hill.findShortest(hill.getStart());
    assertEquals(hill.getRouteLength(end), 31);
  }

  @Test
  public void shouldGetPart1RealData() {
    HillV2BFS hill = new HillV2BFS(AoC.getInputAsString("day12", false));
    HillNode end = hill.findShortest(hill.getStart());
    assertEquals(hill.getRouteLength(end), 361);
  }

  @Test
  public void shouldGetPart2TestData() {
    HillV2BFS hill = new HillV2BFS(AoC.getInputAsString("day12", true));
    assertEquals(hill.findShortestFroma(), 29);
  }

  @Test
  public void shouldGetPart2RealData() {
    HillV2BFS hill = new HillV2BFS(AoC.getInputAsString("day12", false));
    assertEquals(hill.findShortestFroma(), 354);
  }
}
