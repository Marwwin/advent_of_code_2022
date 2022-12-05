package com.marwwin.adventofcode2022.day5;

import java.util.ArrayList;
import java.util.List;

public class Stack {
  private List<Character> stack = new ArrayList<Character>();;

  public void push(char element) {
    stack.add(element);
  }

  public char pop() {
    return stack.remove(stack.size() - 1);
  }

  public char peek() {
    return this.isEmpty()
        ? ' '
        : stack.get(stack.size() - 1);
  }

  public boolean isEmpty() {
    return stack.size() == 0;
  }
}
