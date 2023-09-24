package com.marwwin.adventofcode2022.day10;

import java.util.ArrayList;
import java.util.List;

import com.marwwin.aoc.Stack;

public class Computer {
  int cycle = 0;
  int registerX = 1;
  int signalStrength = 0;
  int maxCycles = 0;
  Stack<Instruction> stack = new Stack<Instruction>();
  List<String> instructions = new ArrayList<String>();

  public Computer(List<String> input, int maxCycles) {
    instructions = input;
    this.maxCycles = maxCycles;
  }

  public int play() {
    if (stack.isEmpty())
      pushNextInstructionToStack();
    for (; cycle <= maxCycles; cycle++) {
      countSignalStrength();
      print();
      cycle();
    }
    return signalStrength;
  }

  private void countSignalStrength() {
    if (cycle == 20 || cycle == 60 || cycle == 100 || cycle == 140 || cycle == 180 || cycle == 220)
      signalStrength += registerX * cycle;
  }

  private void print() {
    if (cycle == 0)
      return;

    int linePosition = cycle % 40;
    if (cycle > 1 && linePosition == 1)
      System.out.println();
    if (linePosition >= registerX && linePosition <= registerX + 2) {
      System.out.print("■");
      return;
    }
    System.out.print(" ");
  }

  private void cycle() {
    if (instructionComplete()) {
      registerX += stack.pop().getValue();
      if (instructions.size() > 0) {
        pushNextInstructionToStack();
        executeInstructionCycle();
      }
    }
  }

  private boolean instructionComplete() {
    return !executeInstructionCycle();
  }

  private boolean executeInstructionCycle() {
    return stack.top().cycle();
  }

  private void pushNextInstructionToStack() {
    stack.push(new Instruction(instructions.remove(0)));
  }
}
