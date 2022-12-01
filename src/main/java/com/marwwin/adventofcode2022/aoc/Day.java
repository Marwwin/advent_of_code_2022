package com.marwwin.adventofcode2022.aoc;

public abstract class Day {
  String day;
  long startTime;

  public Day(String day) {
    this.day = day;
    this.startTime = System.currentTimeMillis();
  }

  public void printResults() {
    System.out.println(this.day);
    System.out.print("Part 1: ");
    System.out.println(this.part1());
    System.out.print("Part 2: ");
    System.out.println(this.part2());

    long endTime = System.currentTimeMillis();
    System.out.println("Took " + (endTime - startTime) + "ms");
  }

  abstract public int part1();

  abstract public int part2();
}
