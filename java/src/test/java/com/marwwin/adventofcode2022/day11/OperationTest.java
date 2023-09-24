package com.marwwin.adventofcode2022.day11;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OperationTest {

  @Test
  public void shouldCreateOperation() {
    Operation op = new Operation("old + 2");
    assertEquals(op.getValue(), 2);
    assertEquals(op.getOperation(), "+");
  }

  @Test
  public void shouldCalculateAddition() {
    Operation op = new Operation("old + 2");
    assertEquals((long) op.calculate(2), 4);
  }

  @Test
  public void shouldCalculateMultiplication() {
    Operation op = new Operation("old * 3");
    assertEquals((long) op.calculate(2), 6);
  }
}
