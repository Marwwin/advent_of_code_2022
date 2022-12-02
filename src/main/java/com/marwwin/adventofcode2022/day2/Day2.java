package com.marwwin.adventofcode2022.day2;

import java.util.List;

import com.marwwin.adventofcode2022.aoc.Day;
import com.marwwin.adventofcode2022.aoc.Utils;

public class Day2 extends Day {
  List<String> input;

  public Day2(boolean test) {
    super("Day 2");
    input = Utils.getInputAsString("day2", test);
  }

  @Override
  public int part1() {
    RockPaperScissorsCalculator rps = new RockPaperScissorsCalculator();
    for (String hand : input)
      rps.play(new RockPaperScissorsGamePart1(hand));
    return rps.getPoints();
  }

  @Override
  public int part2() {
    RockPaperScissorsCalculator rps = new RockPaperScissorsCalculator();
    for (String hand : input)
      rps.play(new RockPaperScissorsGamePart2(hand));
    return rps.getPoints();
  }

}
