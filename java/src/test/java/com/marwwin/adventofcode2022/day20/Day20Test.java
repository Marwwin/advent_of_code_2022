package com.marwwin.adventofcode2022.day20;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Day20Test {
  @Test
  public void testPart1() {
    Day20 day = new Day20(true);
    assertEquals(3, day.part1());
  }

  @Test
  public void realPart1() {
    Day20 day = new Day20(false);
    assertEquals(6387, day.part1());
  }
}
