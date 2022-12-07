package com.marwwin.adventofcode2022.day6;

import com.marwwin.adventofcode2022.aoc.AoC;
import com.marwwin.adventofcode2022.aoc.Day;

public class Day6 extends Day {

  String input;

  public Day6(boolean test) {
    super("Day 6");
    input = AoC.getInputAsString("day6", test).get(0);
  }

  @Override
  public Integer part1() {
    PacketFinder finder = new PacketFinder();
    return finder.solve(input, 4);
  }

  @Override
  public Integer part2() {
    PacketFinder finder = new PacketFinder();
    return finder.solve(input, 14);
  }

}
