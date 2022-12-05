package com.marwwin.adventofcode2022.day1;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Day1Test {
  @Test
  public void part1TestData() {
    Day1 day1 = new Day1(true);
    assertEquals((int) day1.part1(), 24000);
  }

  @Test
  public void part1RealData() {
    Day1 day1 = new Day1(false);
    assertEquals((int) day1.part1(), 72070);
  }

  @Test
  public void part2TestData() {
    Day1 day1 = new Day1(true);
    assertEquals((int) day1.part2(), 45000);
  }

  @Test
  public void part2RealData() {
    Day1 day1 = new Day1(false);
    assertEquals((int) day1.part2(), 211805);
  }
}
