package com.marwwin.adventofcode2022.day5;

import java.util.ArrayList;
import java.util.List;

import com.marwwin.aoc.AoC;
import com.marwwin.aoc.Day;

public class Day5 extends Day {
  List<String> initialState;
  List<String> moves;

  public Day5(boolean test) {
    super("Day 5");
    List<String> input = AoC.getInputAsString("day5", test);
    parseInput(input);
  }

  public void parseInput(List<String> input) {
    initialState = new ArrayList<>(input.subList(0, emptyRow(input)));
    moves = new ArrayList<>(input.subList(emptyRow(input), input.size()));
  }

  public int emptyRow(List<String> input) {
    return input.indexOf("");
  }

  @Override
  public String part1() {
    CargoCrane crane = new CargoCrane(initialState);
    moves.forEach(crane::move);
    return crane.getTopItems();
  }

  @Override
  public String part2() {
    CargoCrane crane = new CargoCrane(initialState);
    moves.forEach(crane::moveAll);
    return crane.getTopItems();
  }
}
