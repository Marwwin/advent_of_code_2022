package com.marwwin.adventofcode2022.day10;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class CommandTest {
  @Test
  public void shouldCreateNoopCommand() {
    Command noop = new Command("noop");
    assertEquals(noop.getCycles(), 1);
    assertEquals(noop.getValue(), null);
  }

  @Test
  public void shouldCreateAddXCommand() {
    Command noop = new Command("addx 2");
    assertEquals(noop.getCycles(), 2);
    assertEquals((int) noop.getValue(), 2);
  }

  @Test
  public void cycleShodDecrementCycles() {
    Command noop = new Command("noop");
    assertEquals(noop.getCycles(), 1);
    noop.cycle();
    assertEquals(noop.getCycles(), 0);
    assertFalse(noop.cycle());
  }
}
