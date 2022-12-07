package com.marwwin.adventofcode2022.day4;

import java.util.List;

import com.marwwin.aoc.AoC;
import com.marwwin.aoc.Day;

public class Day4 extends Day {

  List<String> input;

  public Day4(boolean test) {
    super("Day 4");
    input = AoC.getInputAsString("day4", test);
  }

  @Override
  public Integer part1() {
    int count = 0;
    for (String pair : input) {
      count += new Assignment(pair).isOneSectionFullyContainedInTheOther() ? 1 : 0;
    }
    return count;
  }

  @Override
  public Integer part2() {
    int count = 0;
    for (String pair : input) {
      count += new Assignment(pair).hasOverlap() ? 1 : 0;
    }
    return count;
  }
}
