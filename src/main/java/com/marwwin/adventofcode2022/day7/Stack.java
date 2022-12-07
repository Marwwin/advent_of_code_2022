package com.marwwin.adventofcode2022.day7;

import java.util.ArrayList;
import java.util.List;

public class Stack {
  List<Folder> stack;

  public Stack() {
    stack = new ArrayList<>();
  }

  public void push(Folder folder) {
    stack.add(folder);
  }

  public Folder pop() {
    return stack.remove(stack.size() - 1);
  }

  public Folder peek() {
    return this.isEmpty()
        ? null
        : stack.get(stack.size() - 1);
  }

  public boolean isEmpty() {
    return stack.size() == 0;
  }
}
