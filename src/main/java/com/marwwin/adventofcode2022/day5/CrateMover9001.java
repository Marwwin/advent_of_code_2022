package com.marwwin.adventofcode2022.day5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.marwwin.aoc.Stack;

public class CrateMover9001 {
  private static final int WHITE_SPACE_BETWEEN_STACKS = 4;
  List<Stack<Crate>> stacks = new ArrayList<>();

  public CrateMover9001(List<String> input) {
    createCrateStacks(input);
    fillStacks(input);
  }

  private void createCrateStacks(List<String> input) {
    for (int i = 0; i < amountOfStacks(input); i++) {
      stacks.add(new Stack<Crate>());
    }
  }

  private int amountOfStacks(List<String> input) {
    int rowLength = input.get(0).length();
    return input.size() > 0
        ? (rowLength + 1) / WHITE_SPACE_BETWEEN_STACKS
        : 0;
  }

  private void fillStacks(List<String> input) {
    if (this.isEmpty())
      return;
    input.stream()
        .filter(row -> row.contains("["))
        .sorted(Collections.reverseOrder())
        .forEach(row -> fill(row));
  }

  public void fill(String string) {
    System.out.println(string);
    List<Crate> crates = new ArrayList<>();
    int stackIndex = 0;
    for (String ch : string.split("")) {
      if (!ch.equals("[") && !ch.equals("]") && !ch.equals(" ")) {
        crates.add(new Crate(ch, stackIndex));
        stackIndex += 1;
      }
    }

    for (Crate crate : crates) {
      stacks.get(crate.index).push(crate);
    }

    // for (int i = 1; i < string.length(); i += WHITE_SPACE_BETWEEN_STACKS) {
    // if (string.charAt(i) != ' ')
    // stacks.get(indexToStack(i)).push(new Crate(string.charAt(i)));
    // }
  }

  public String getTopItems() {
    return stacks.stream()
        .map(stack -> stack.top().getContent())
        .collect(Collector.of(
            StringBuilder::new,
            StringBuilder::append,
            StringBuilder::append,
            StringBuilder::toString));
  }

  public void move(String string) {
    if (string.isEmpty())
      return;
    CrateMoverTask task = new CrateMoverTask(string);
    execute(task);
  }

  private void execute(CrateMoverTask task) {
    for (int i = 0; i < task.amount(); i++) {
      Crate crate = grabCrate(task);
      drop(crate);
    }
  }

  private void drop(Crate crate) {
    stacks.get(crate.destination()).push(crate);
  }

  private Crate grabCrate(CrateMoverTask task) {
    Crate crate = stacks.get(task.from()).pop();
    crate.attachTask(task);
    return crate;
  }

  public void moveAll(String string) {
    // if (string.isEmpty())
    // return;
    // CrateMoverTask crateMover = new CrateMoverTask(string);
    // System.out.println(crateMover.amount());
    // System.out.println(crateMover.amount());
    //
    // char[] itemsToMove = new char[crateMover.amount()];
    // for (int i = 0; i < crateMover.amount(); i++) {
    // itemsToMove[i] = stacks.get(crateMover.to()).pop();
    // }
    // for (int i = itemsToMove.length - 1; i >= 0; i--) {
    // stacks.get(crateMover.to()).push(itemsToMove[i]);
    // }
  }

  public boolean isEmpty() {
    return amountOfStacks() == 0;
  }

  public int amountOfStacks() {
    return stacks.size();
  }
}
