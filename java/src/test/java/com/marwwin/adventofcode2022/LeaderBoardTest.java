package com.marwwin.adventofcode2022;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.marwwin.aoc.LeaderBoard;

public class LeaderBoardTest {
  @Test
  public void shouldBeAbleToAddToList(){
    LeaderBoard result = new LeaderBoard(3);
    result.add(1);
    int[] expected = {1,0,0};
    assertArrayEquals(result.get(), expected);
  }

  @Test 
  public void shouldOnlyAllow3HighestElementsInList(){
    LeaderBoard result = new LeaderBoard(3);
    result.add(1);
    result.add(2);
    result.add(3);
    result.add(4);

    int[] expected = {4,3,2};
    assertArrayEquals(result.get(), expected);
  }

  @Test 
  public void shouldReturnSumOfElements(){
    LeaderBoard result = new LeaderBoard(3);
    result.add(1);
    result.add(2);
    result.add(3);
    result.add(4);
    assertEquals(result.sum(), 9);
  }
}
