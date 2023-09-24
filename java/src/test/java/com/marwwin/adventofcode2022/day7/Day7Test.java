package com.marwwin.adventofcode2022.day7;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Day7Test {
  @Test
  public void shouldSolveTestDataPart1(){
    Day7 day7 = new Day7(false);
    assertEquals(day7.part1(), 1477771);
  }
  @Test
  public void shouldSolveTestDataPart2(){
    Day7 day7 = new Day7(false);
    assertEquals(day7.part2(), 3579501);
  }
}
