package com.marwwin.adventofcode2022.day2;

import java.util.List;

import com.marwwin.aoc.AoC;
import com.marwwin.aoc.Day;

public class Day2 extends Day {
  List<String> input;

  public Day2(boolean test) {
    super("Day 2");
    input = AoC.getInputAsString("day2", test);
  }

  @Override
  public Integer part1() {
    RockPaperScissorsCalculator rps = new RockPaperScissorsCalculator();
    for (String hand : input)
      rps.play(new RockPaperScissorsGamePart1(hand));
    return rps.getPoints();
  }

  @Override
  public Integer part2() {
    RockPaperScissorsCalculator rps = new RockPaperScissorsCalculator();
    for (String hand : input)
      rps.play(new RockPaperScissorsGamePart2(hand));
    return rps.getPoints();
  }
}
