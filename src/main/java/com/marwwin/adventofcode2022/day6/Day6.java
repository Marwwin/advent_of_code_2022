package com.marwwin.adventofcode2022.day6;

import java.util.stream.IntStream;

import com.marwwin.adventofcode2022.aoc.AoC;
import com.marwwin.adventofcode2022.aoc.Day;

public class Day6 extends Day {

  String input;

  public Day6(boolean test) {
    super("Day 6");
    input = AoC.getInputAsString("day6", test).get(0);
  }

  @Override
  public int part1() {
   return solvePart1(input);
  }

  public int solvePart1(String string){
    PacketFinder finder = new PacketFinder(4);
    int[] chs = string.chars().toArray();
    for (int i = 0; i < string.length(); i++) {
      finder.add(chs[i]);
      if (finder.isFound()) return ++i;
    }
    return 0;
  }

  @Override
  public int part2() {
    return solvePart2(input);
  }
  
  public int solvePart2(String string){
    PacketFinder finder = new PacketFinder(14);
    int[] chs = string.chars().toArray();
    for (int i = 0; i < string.length(); i++) {
      finder.add(chs[i]);
      if (finder.isFound()) return ++i;
    }
    return 0;
  }

}
