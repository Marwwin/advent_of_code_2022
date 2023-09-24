package com.marwwin.adventofcode2022.day5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CrateStackTest {
  @Test 
  public void shouldCreateCreateStack() {
    CrateStack stack = new CrateStack();
  }
  @Test
  public void shouldCreateAStack() {
    CrateStack stack = new CrateStack();
    assertTrue(stack.isEmpty());
  }

  @Test
  public void shouldAddElementToStack() {
    CrateStack stack = new CrateStack();
    stack.push('A');
    assertFalse(stack.isEmpty());
  }

  @Test
  public void shouldReturnTopElement() {
    CrateStack stack = new CrateStack();
    stack.push('A');
    stack.push('B');
    assertEquals((char) stack.top(), 'B');
  }

  @Test
  public void shouldRemoveTopElement() {
    CrateStack stack = new CrateStack();
    stack.push('A');
    stack.push('B');
    assertEquals((char) stack.pop(), 'B');
    assertEquals((char) stack.top(), 'A');

  }
}
