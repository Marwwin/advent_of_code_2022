package com.marwwin.adventofcode2022.day8;

import java.util.Arrays;

import com.marwwin.aoc.AoC;
import com.marwwin.aoc.Day;

public class Day8 extends Day {

  ElfForest forest;

  public Day8(boolean test) {
    super("Day 8");
    forest = new ElfForest(AoC.getInputAsString("day8", test));
  }

  @Override
  public Object part1() {
    return forest.solvePart1();
  }

  @Override
  public Object part2() {
    return forest.solvePart2();
  }
}
