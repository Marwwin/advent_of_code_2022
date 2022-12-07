package com.marwwin.adventofcode2022.day7;

import java.util.HashMap;
import java.util.List;

import com.marwwin.aoc.AoC;
import com.marwwin.aoc.Day;

public class Day7 extends Day {

  List<String> input;

  public Day7(boolean test) {
    super("Day 7");
    input = AoC.getInputAsString("day7", test);
  }

  @Override
  public Object part1() {
    FileSystem fs = new FileSystem();
    input.forEach(e-> fs.parse(new Command(e)));
    HashMap<String, Integer> result = fs.calculateSize();
    return result.get("part1");
  }

  @Override
  public Object part2() {
    FileSystem fs = new FileSystem();
    input.forEach(e-> fs.parse(new Command(e)));
    HashMap<String, Integer> result = fs.calculateSize();
    return result.get("part2");
  }
}
