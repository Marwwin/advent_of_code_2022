package com.marwwin.adventofcode2022.day5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StackTest {
  @Test
  public void shouldCreateAStack() {
    Stack stack = new Stack();
    assertTrue(stack.isEmpty());
  }

  @Test
  public void shouldAddElementToStack() {
    Stack stack = new Stack();
    stack.add('A');
    assertFalse(stack.isEmpty());
  }

  @Test
  public void shouldReturnTopElement() {
    Stack stack = new Stack();
    stack.add('A');
    stack.add('B');
    assertEquals(stack.getTop(), 'B');
  }
}
