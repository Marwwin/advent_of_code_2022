package com.marwwin.adventofcode2022.day10;

public class Instruction {
  int value;
  int cycles;

  public Instruction(String string) {
    String[] instruction = string.split(" ");

    if (instruction[0].equals("noop")) {
      this.cycles = 1;
      this.value = 0;
      return;
    }
    if (instruction[0].equals("addx")) {
      this.cycles = 2;
      this.value = Integer.parseInt(instruction[1]);
      return;
    }
  }

  public int getValue() {
    return value;
  }

  public boolean cycle() {
    return cycles-- > 0;
  }

  public int getCycles() {
    return cycles;
  }
}
