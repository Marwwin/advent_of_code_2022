package com.marwwin.adventofcode2022.day25;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Day25Test {
  @Test
  public void shouldWorkForTestPart1() {
    Day25 day = new Day25(true);
    assertEquals("2=-1=0", day.part1());
  }
  @Test
  public void shouldWorkForRealPart1() {
    Day25 day = new Day25(false);
    assertEquals("2-212-2---=00-1--102", day.part1());
  }
}
