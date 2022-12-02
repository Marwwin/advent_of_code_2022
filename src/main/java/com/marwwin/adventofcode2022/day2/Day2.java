package com.marwwin.adventofcode2022.day2;
import java.util.List;

import com.marwwin.adventofcode2022.aoc.Day;
import com.marwwin.adventofcode2022.aoc.Utils;

public class Day2 extends Day{
  List<String> input;

  public Day2(boolean test) {
    super("Day 2");
    input = Utils.getInputAsString("day2", test);
  }

  @Override
  public int part1() {
    RockPaperScissorsPart1 rps = new RockPaperScissorsPart1();
    for (String hand : input) rps.play(hand);
    return rps.getPoints();
  }

  @Override
  public int part2() {
    RockPaperScissorsPart2 rps = new RockPaperScissorsPart2();
    for (String hand : input) rps.play(hand);
    return rps.getPoints();
  }
  
}
