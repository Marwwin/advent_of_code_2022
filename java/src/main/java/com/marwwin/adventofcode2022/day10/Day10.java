package com.marwwin.adventofcode2022.day10;

import java.util.List;

import com.marwwin.aoc.AoC;
import com.marwwin.aoc.Day;

public class Day10 extends Day{

  List<String> input;

  public Day10(boolean test) {
    super("Day 10");
    input = AoC.getInputAsString("day10", test);
  }

  @Override
  public Object part1() {
    Computer comp = new Computer(input, 240);
    return comp.play();
  }

  @Override
  public Object part2() {
    Computer comp = new Computer(input, 240);
    return comp.play();
  }
  
}
