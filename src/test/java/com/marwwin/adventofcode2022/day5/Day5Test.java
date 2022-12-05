package com.marwwin.adventofcode2022.day5;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class Day5Test {
  @Test
  public void shouldSplitInput() {
    Day5 day5 = new Day5(true);
    List[] result = day5.splitInput();
    assertEquals(result[0].size(), 4);
    assertEquals(result[1].size(), 5);
  }

  @Test
  public void shouldReturnIndexOfEmptyElement(){
  Day5 day5 = new Day5(true);
  assertEquals(4,   day5.indexOfEmptyElement());
  }
  @Test
  public void shouldSolvePart1TestData(){
    Day5 day5 = new Day5(true);
    assertEquals(day5.part1Str(), "CMZ");
  }
  @Test
  public void shouldSolvePart1RealData(){
    Day5 day5 = new Day5(false);
    assertEquals(day5.part1Str(), "LJSVLTWQM");
  }
  @Test
  public void shouldSolvePart2TestData(){
    Day5 day5 = new Day5(true);
    assertEquals(day5.part2Str(), "MCD");
  }
  @Test
  public void shouldSolvePart2RealData(){
    Day5 day5 = new Day5(false);
    assertEquals(day5.part2Str(), "LJSVLTWQM");
  }
}
