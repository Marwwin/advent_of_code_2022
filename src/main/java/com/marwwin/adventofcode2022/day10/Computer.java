package com.marwwin.adventofcode2022.day10;

import java.util.ArrayList;
import java.util.List;

import com.marwwin.aoc.Stack;

public class Computer {
  int cycle = 0;
  int value = 1;
  int signalStrength = 0;
  int maxCycles = 0;
  Stack<Command> stack = new Stack<Command>();
  List<String> instructions = new ArrayList<String>();

  public Computer(List<String> input, int maxCycles) {
    instructions = input;
    this.maxCycles = maxCycles;
  }

  public int play() {
    if (stack.isEmpty())
      stack.push(new Command(instructions.remove(0)));
    for (; cycle <= maxCycles; cycle++) {
      countSignalStrength();
      print();
      cycle();
    }
    return signalStrength;
  }

  private void countSignalStrength() {
    if (cycle == 20 || cycle == 60 || cycle == 100 || cycle == 140 || cycle == 180 || cycle == 220)
      signalStrength += value * cycle;
  }

  private void print() {
    if (cycle == 0)
      return;
    if (cycle > 1 && cycle % 40 == 1)
      System.out.println();
    int pixel = cycle % 40;
    if (pixel == value || pixel == value + 1 || pixel == value + 2) {
      System.out.print("#");
      return;
    }
    System.out.print(".");
  }

  private void cycle() {
    if (!stack.top().cycle()) {
      value += stack.pop().getValue();
      if (instructions.size() > 0) {
        stack.push(new Command(instructions.remove(0)));
        stack.top().cycle();
      }
    }
  }
}
