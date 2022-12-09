package com.marwwin.adventofcode2022.day9;

import java.util.List;

import com.marwwin.aoc.AoC;
import com.marwwin.aoc.Day;

public class Day9 extends Day {

  List<String> input;

  public Day9(boolean test) {
    super("Day 9");
    input = AoC.getInputAsString("day9", test);
  }

  @Override
  public Object part1() {
    Knot head = new Knot(1);
    input.forEach(head::move);
    return head.getTail().visited();
  }

  @Override
  public Object part2() {
    Knot head = new Knot(9);
    input.forEach(head::move);
    return head.getTail()
        .getTail()
        .getTail()
        .getTail()
        .getTail()
        .getTail()
        .getTail()
        .getTail()
        .getTail()
        .visited();
  }

}
