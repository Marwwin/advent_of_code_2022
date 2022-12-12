package com.marwwin.adventofcode2022.day10;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Day10Test {
  @Test
  public void testPart1() {
    Day10 day10 = new Day10(true);
    assertEquals(day10.part1(), 13140);

  }
  @Test
  public void testPart1RealData() {
    Day10 day10 = new Day10(false);
    assertEquals(day10.part1(), 17180);
  }

  @Test
  public void testPart2() {
    Day10 day10 = new Day10(true);
    assertEquals(day10.part2(), 13140);
  }
  @Test
  public void testPart2RealData() {
    Day10 day10 = new Day10(false);
    assertEquals(day10.part2(), 17180);
  }
}
