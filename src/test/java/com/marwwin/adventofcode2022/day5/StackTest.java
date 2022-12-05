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
    stack.push('A');
    assertFalse(stack.isEmpty());
  }

  @Test
  public void shouldReturnTopElement() {
    Stack stack = new Stack();
    stack.push('A');
    stack.push('B');
    assertEquals(stack.peek(), 'B');
  }
  @Test
  public void shouldRemoveTopElement() {
    Stack stack = new Stack();
    stack.push('A');
    stack.push('B');
    assertEquals(stack.pop(), 'B');
    assertEquals(stack.peek(), 'A');

  }
}
