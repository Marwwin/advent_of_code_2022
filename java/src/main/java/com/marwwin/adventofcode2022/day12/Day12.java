package com.marwwin.adventofcode2022.day12;

import com.marwwin.aoc.AoC;
import com.marwwin.aoc.Day;
import com.marwwin.aoc.Matrix;

public class Day12 extends Day{

  Matrix matrix;

  public Day12(boolean test) {
    super("Day 12");
    matrix = AoC.getInputAsMatrix("day12", test);
  }

  @Override
  public Object part1() {
    matrix.print();
    return null;
  }

  @Override
  public Object part2() {
    // TODO Auto-generated method stub
    return null;
  }
  
}
