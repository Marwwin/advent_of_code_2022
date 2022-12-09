package com.marwwin.adventofcode2022.day9;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Day9Test {
  @Test
  public void testPart1() {
    Day9 day9 = new Day9(true);
    assertEquals(day9.part1(), 13);
  }
  @Test
  public void testPart1real() {
    Day9 day9 = new Day9(false);
    assertEquals(day9.part1(), 6745);
  }

  @Test
  public void testPart2() {

  }
}
