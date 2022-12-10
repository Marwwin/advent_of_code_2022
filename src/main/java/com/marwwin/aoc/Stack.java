package com.marwwin.aoc;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
  List<T> stack;

  public Stack() {
    stack = new ArrayList<>();
  }

  public void push(T value) {
    stack.add(value);
  }

  public T pop() {
    return stack.remove(stack.size() - 1);
  }

  public T top() {
    return this.isEmpty()
        ? null
        : stack.get(stack.size() - 1);
  }

  public boolean isEmpty() {
    return stack.size() == 0;
  }
}
