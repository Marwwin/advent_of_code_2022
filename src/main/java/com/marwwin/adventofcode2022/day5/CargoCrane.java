package com.marwwin.adventofcode2022.day5;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CargoCrane {
  Stack[] stacks;

  public CargoCrane(List<String> input) {
    if (input.size() > 0) {
      stacks = new Stack[(input.get(0).length() + 1) / 4];
      for (int i = 0; i < (input.get(0).length() + 1) / 4; i++) {
        stacks[i] = new Stack();
      }
    } else
      stacks = new Stack[0];
    if (amountOfStack() > 0) {
      for (int i = input.size() - 2; i >= 0; i--) {
        parseStringToStack(input.get(i));
      }
    }
  }

  public int amountOfStack() {
    return stacks.length;
  }

  public void parseStringToStack(String string) {
    for (int i = 1; i < string.length(); i += 4) {
      if (string.charAt(i) != ' ')
        stacks[(i - 1) / 4].add(string.charAt(i));
    }
  }

  public String getTopItems() {
    String result = "";
    for (Stack s : stacks) {
      result += s.getTop();
    }
    return result;
  }

  public void move(String string) {
    Move move = new Move(string);
    for (int i = 0; i < move.getAmount(); i++) {
      char itemToMove = stacks[move.getFrom()].remove();
      stacks[move.getTo()].add(itemToMove);
    }
  }

  public void moveAll(String string) {
    if (string.isEmpty())
      return;
    Move move = new Move(string);
    System.out.println(string);
    System.out.println(move.getAmount());
    System.out.println(move.getFrom());
    System.out.println(move.getTo());
    System.out.println();

    char[] itemsToMove = new char[move.getAmount()];
    for (int i = 0; i < move.getAmount(); i++) {
      itemsToMove[i] = stacks[move.getFrom()].remove();
    }
    System.out.println();

    System.out.println(move.getTo());
    System.out.println(itemsToMove.length);
    System.out.println();

    for (int i = itemsToMove.length - 1; i >= 0; i--) {

      stacks[move.getTo()].add(itemsToMove[i]);
    }
  }
}
