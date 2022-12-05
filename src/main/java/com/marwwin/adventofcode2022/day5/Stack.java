package com.marwwin.adventofcode2022.day5;

import java.util.ArrayList;
import java.util.List;

public class Stack {
  List<Character> stack = new ArrayList<Character>();;

  public Stack() {
  }

  public boolean isEmpty() {
    return stack.size() == 0;
  }

  public void add(Character element) {
    stack.add(element);
  }

  public Character remove() {
    return stack.remove(stack.size() - 1);
  }

  public char getTop() {
    //System.out.println(stack.get(0));
    //System.out.println(stack.size() - 1);
//
    if (stack.size() == 0)
      return ' ';
    return stack.get(stack.size() - 1);
  }
}
