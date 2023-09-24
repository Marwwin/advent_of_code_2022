package com.marwwin.adventofcode2022.day14;

import java.util.List;

import com.marwwin.aoc.AoC;
import com.marwwin.aoc.Day;

public class Day14 extends Day {

  List<String> input;

  public Day14(boolean test) {
    super("Day 14");
    input = AoC.getInputAsString("day14", test);
  }

  @Override
  public Object part1() {
    RegolithReservoir reservoir = new RegolithReservoir(input);
    for (int i = 0; i < 93; i++)
      reservoir.dropSandPart2();
    System.out.println(reservoir.getAmountOfSand());
    reservoir.print();
    return null;
  }

  @Override
  public Object part2() {
    // TODO Auto-generated method stub
    return null;
  }

}
