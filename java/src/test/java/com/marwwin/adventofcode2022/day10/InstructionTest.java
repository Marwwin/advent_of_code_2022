package com.marwwin.adventofcode2022.day10;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class InstructionTest {
  @Test
  public void shouldCreateNoopCommand() {
    Instruction noop = new Instruction("noop");
    assertEquals(noop.getCycles(), 1);
    assertEquals(noop.getValue(), 0);
  }

  @Test
  public void shouldCreateAddXCommand() {
    Instruction addx = new Instruction("addx 2");
    assertEquals(addx.getCycles(), 2);
    assertEquals(addx.getValue(), 2);
  }

  @Test
  public void cycleShouldDecrementCycles() {
    Instruction noop = new Instruction("noop");
    assertEquals(noop.getCycles(), 1);
    noop.cycle();
    assertEquals(noop.getCycles(), 0);
    assertFalse(noop.cycle());
  }
}
