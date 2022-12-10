package com.marwwin.adventofcode2022.day5;

import java.util.ArrayList;
import java.util.List;

import com.marwwin.aoc.Stack;

public class CargoCrane {
  List<Stack<Character>> stacks = new ArrayList<>();

  public CargoCrane(List<String> input) {
    initializeStacks(input);
    populateStacks(input);
  }

  private void initializeStacks(List<String> input) {
    int lengthOfOneRow = input.get(0).length();
    int numberOfStacks = input.size() > 0
        ? (lengthOfOneRow + 1) / 4
        : 0;
    for (int i = 0; i < numberOfStacks; i++) {
      stacks.add(new Stack<Character>());
    }
  }

  private void populateStacks(List<String> input) {
    if (this.isEmpty())
      return;

    // We need to populate the stacks from the bottom up to get the order right
    // Input.size() - 2 since we don't want the last 2 lines of the input
    // Since they contain an empty line and the number of the stacks
    for (int i = input.size() - 2; i >= 0; i--) {
      populateStackFromRow(input.get(i));
    }
  }

  public void populateStackFromRow(String string) {
    for (int i = 1; i < string.length(); i += 4) {
      if (string.charAt(i) != ' ')
        stacks.get(stackIndex(i)).push(string.charAt(i));
    }
  }

  private int stackIndex(int i) {
    return (i - 1) / 4;
  }

  public String getTopItems() {
    String result = "";
    for (Stack<Character> s : stacks) {
      result += s.top();
    }
    return result;
  }

  public void move(String string) {
    if (string.isEmpty())
      return;
    Move move = new Move(string);
    for (int i = 0; i < move.amount(); i++) {
      char itemToMove = stacks.get(move.from()).pop();
      stacks.get(move.to()).push(itemToMove);
    }
  }

  public void moveAll(String string) {
    if (string.isEmpty())
      return;
    Move move = new Move(string);
    char[] itemsToMove = new char[move.amount()];
    for (int i = 0; i < move.amount(); i++) {
      itemsToMove[i] = stacks.get(move.to()).pop();
    }
    for (int i = itemsToMove.length - 1; i >= 0; i--) {
      stacks.get(move.to()).push(itemsToMove[i]);
    }
  }

  public boolean isEmpty() {
    return amountOfStacks() == 0;
  }

  public int amountOfStacks() {
    return stacks.size();
  }
}
