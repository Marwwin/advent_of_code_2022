package com.marwwin.adventofcode2022.day5;

import java.util.ArrayList;
import java.util.List;

import com.marwwin.adventofcode2022.aoc.AoC;
import com.marwwin.adventofcode2022.aoc.Day;

public class Day5 extends Day {
  List<String> input;

  public Day5(boolean test) {
    super("Day 5");
    input = AoC.getInputAsString("day5", test);
  }

  @Override
  public String part1() {
    List<String>[] inputs = splitInput();
    CargoCrane crane = new CargoCrane(inputs[0]);
    inputs[1].forEach(crane::move);
    return crane.getTopItems();
  }

  @Override
  public String part2() {
    List<String>[] inputs = splitInput();
    CargoCrane crane = new CargoCrane(inputs[0]);
    inputs[1].forEach(crane::moveAll);
    return crane.getTopItems();
  }

  public List<String>[] splitInput() {
    List<String> first = new ArrayList<>(input.subList(0, emptyRow()));
    List<String> second = new ArrayList<>(input.subList(emptyRow(), input.size()));
    return new List[] { first, second };
  }

  public int emptyRow() {
    return input.indexOf("");
  }
}
