package com.marwwin.adventofcode2022.day6;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Day6Test {
  @Test
  public void shouldWorkForTestDataPart1() {
    Day6 day6 = new Day6(true);
    assertEquals((int) day6.part1(), 7);
  }

 // @Test
 // public void shouldWorkForTest1() {
 //   Day6 day6 = new Day6(true);
 //   assertEquals(day6.solvePart1("bvwbjplbgvbhsrlpgdmjqwftvncz"), 5);
 // }
//
 // @Test
 // public void shouldWorkForTest2() {
 //   Day6 day6 = new Day6(true);
 //   assertEquals(day6.solvePart1("nppdvjthqldpwncqszvftbrmjlhg"), 6);
 // }

  @Test
  public void shouldWorkForRealDataPart1() {
    Day6 day6 = new Day6(false);
    assertEquals((int)day6.part1(), 1625);
  }

  @Test
  public void shouldWorkForRealDataPart2() {
    Day6 day6 = new Day6(false);
    assertEquals((int)day6.part2(), 2250);
  }
}
