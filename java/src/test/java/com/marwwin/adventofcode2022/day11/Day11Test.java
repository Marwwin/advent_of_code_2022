package com.marwwin.adventofcode2022.day11;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;


public class Day11Test {
  @Test
  public void testPart1TestData() {
    Day11 day11 = new Day11(true);
    assertEquals(day11.part1(), new BigDecimal("10605"));
  }

  @Test
  public void testPart1RealData() {
    Day11 day11 = new Day11(false);
    assertEquals(day11.part1(),  new BigDecimal("151312"));
  }

  @Test
  public void testPart2() {
    Day11 day11 = new Day11(true);
    assertEquals(day11.part2(), new BigDecimal("2713310158"));
  }

  @Test
  public void testPart2Real() {
    Day11 day11 = new Day11(false);
    assertEquals(day11.part2(), new BigDecimal("51382025916"));
  }
}
