package com.marwwin.adventofcode2022.day15;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Test;

public class Day15Test {
  @Test
  public void testPart1() {
    Day15 day15 = new Day15(true);
    assertEquals(day15.part1(), 26);
  }

  @Test
  public void realPart1() {
    Day15 day15 = new Day15(false);
    assertEquals(day15.part1RealData(2000000), 4961647);
  }

  @Test
  public void testPart2() {
    Day15 day15 = new Day15(false);
    assertEquals(day15.part2(), new BigInteger("12274327017867"));
  }
}
