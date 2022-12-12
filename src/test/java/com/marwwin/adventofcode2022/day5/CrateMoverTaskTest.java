package com.marwwin.adventofcode2022.day5;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CrateMoverTaskTest {
  @Test
  public void shouldCreateAMove() {
    CrateMoverTask move = new CrateMoverTask("move 3 from 2 to 1");    
    assertEquals(move.amount(), 3);
    assertEquals(move.from(), 2 - 1);
    assertEquals(move.to(), 1 - 1);

  }
}
