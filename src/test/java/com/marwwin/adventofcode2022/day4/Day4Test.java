package com.marwwin.adventofcode2022.day4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Day4Test {
  @Test
  public void shouldSolvePart1TrainData(){
    Day4 day4 = new Day4(true);
    assertEquals(day4.part1(), 2);
  }
  @Test
  public void shouldSolvePart1RealData(){
    Day4 day4 = new Day4(false);
    assertEquals(day4.part1(), 547);
  }
  @Test
  public void shouldSolvePart2TrainData(){
    Day4 day4 = new Day4(true);
    assertEquals(day4.part2(), 4);
  }
  @Test
  public void shouldSolvePart2RealData(){
    Day4 day4 = new Day4(false);
    assertEquals(day4.part2(), 843);
  }
  @Test
  public void shouldCreateSection(){
    Section result = new Section("1-2");
    assertEquals(result.start(), 1);
    assertEquals(result.end(), 2);
  }
  @Test
  public void shouldCreateSectionWithLargerNumbers(){
    Section result = new Section("10-22");
    assertEquals(result.start(), 10);
    assertEquals(result.end(), 22);
  }

  @Test
  public void shouldCreateASectionAssignment(){
    Assignment result = new Assignment("1-2,3-4");
    assertEquals(result.first().start(), 1);
    assertEquals(result.first().end(), 2);
    assertEquals(result.second().start(), 3);
    assertEquals(result.second().end(), 4);
  }
  @Test
  public void shouldReturnTrueIfOneSectionIsContainedInTheOther(){
    Assignment result = new Assignment("1-4,2-3");
    assertTrue(result.isOneSectionFullyContainedInTheOther());
  }
  @Test
  public void shouldReturnFalseIfOneSectionIsNotContainedInTheOther(){
    Assignment result = new Assignment("1-2,2-3");
    assertFalse(result.isOneSectionFullyContainedInTheOther());
  }
  @Test
  public void shouldReturnTrueIfOverlap(){
    Assignment result = new Assignment("1-2,2-3");
    assertTrue(result.hasOverlap());
  }
  @Test
  public void shouldReturnTrueIfOverlapSEcond(){
    Assignment result = new Assignment("4-6,1-4");
    assertTrue(result.hasOverlap());
  }
  @Test
  public void shouldReturnFalseIfNoOverlap(){
    Assignment result = new Assignment("1-2,3-5");
    assertFalse(result.hasOverlap());
  }
  @Test
  public void shouldReturnFalseIfNoOverlapSwapped(){
    Assignment result = new Assignment("3-5,1-2");
    assertFalse(result.hasOverlap());
  }
}
