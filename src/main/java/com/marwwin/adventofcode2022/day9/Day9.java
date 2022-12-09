package com.marwwin.adventofcode2022.day9;

import java.util.List;

import com.marwwin.aoc.AoC;
import com.marwwin.aoc.Day;

public class Day9 extends Day{

  List<String> input;

  public Day9(boolean test) {
    super("Day 9");
    input = AoC.getInputAsString("day9", test);
    //TODO Auto-generated constructor stub
  }

  @Override
  public Object part1() {
    RopeBridge bridge = new RopeBridge();
    input.forEach(bridge::move);
    return bridge.visited();
  }

  @Override
  public Object part2() {
    // TODO Auto-generated method stub
    return null;
  }
  
}
