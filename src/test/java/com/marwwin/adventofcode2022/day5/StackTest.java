package com.marwwin.adventofcode2022.day5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.marwwin.aoc.Stack;

public class StackTest {
  @Test
  public void shouldCreateAStack() {
    Stack<Character> stack = new Stack<Character>();
    assertTrue(stack.isEmpty());
  }

  @Test
  public void shouldAddElementToStack() {
    Stack<Character> stack = new Stack<Character>();
    stack.push('A');
    assertFalse(stack.isEmpty());
  }

  @Test
  public void shouldReturnTopElement() {
    Stack<Character> stack = new Stack<Character>();
    stack.push('A');
    stack.push('B');
    assertEquals((char) stack.top(), 'B');
  }

  @Test
  public void shouldRemoveTopElement() {
    Stack<Character> stack = new Stack<Character>();
    stack.push('A');
    stack.push('B');
    assertEquals((char) stack.pop(), 'B');
    assertEquals((char) stack.top(), 'A');

  }
}
