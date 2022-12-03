package com.marwwin.adventofcode2022.day3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.marwwin.adventofcode2022.aoc.Day;

public class Day3Test {
  @Test
  public void shouldSolveTestDataPart1(){
    Day day3 = new Day3(true);
    assertEquals(day3.part1(), 157);
  }
  @Test
  public void shouldSolveRealDataPart1(){
    Day day3 = new Day3(false);
    assertEquals(day3.part1(), 8401);
  }
  @Test
  public void binTreeShouldSolveTestDataPart1(){
    Day3 day3 = new Day3(true);
    assertEquals(day3.part1BT(), 157);
  }
  @Test
  public void binTreeShouldSolveRealDataPart1(){
    Day3 day3 = new Day3(false);
    assertEquals(day3.part1BT(), 8401);
  }
  @Test
  public void shouldSolveTestDataPart2(){
    Day day3 = new Day3(true);
    assertEquals(day3.part2(), 70);
  }
  @Test
  public void shouldSolveTestRealPart2(){
    Day day3 = new Day3(false);
    assertEquals(day3.part2(), 2641);
  }
  @Test
  public void binTreeShouldSolveTestDataPart2(){
    Day3 day3 = new Day3(true);
    assertEquals(day3.part2BT(), 70);
  }
  @Test
  public void binTreeShouldSolveTestRealPart2(){
    Day3 day3 = new Day3(false);
    assertEquals(day3.part2BT(), 2641);
  }
}
