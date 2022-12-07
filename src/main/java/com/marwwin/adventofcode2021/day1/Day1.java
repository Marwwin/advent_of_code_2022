package com.marwwin.adventofcode2021.day1;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;

import com.marwwin.aoc.AoC;
import com.marwwin.aoc.Day;

public class Day1 extends Day {

  List<String> input;

  public Day1(boolean test) {
    super("Day 1");
    input = AoC.getInputAsString("day1", test);
  }

  @Override
  public Object part1() {
    int count = 0;
    int previous = Integer.parseInt(input.get(0));
    for (int i = 1; i < input.size(); i++) {
      int current = Integer.parseInt(input.get(i));
      int temp = current;
      while ((previous > 0)) {
        previous >>= 1;
        temp >>= 1;
      }
      if (temp > 0)
        count += 1;
      previous = current;
    }
    return count;
  }

  public Object part1Easy() {
    int count = 0;
    int previous = Integer.parseInt(input.get(0));
    for (int i = 1; i < input.size(); i++) {
      int current = Integer.parseInt(input.get(i));
      if (current > previous)
        count += 1;
      previous = current;
    }
    return count;
  }

  @Override
  public Object part2() {
    // TODO Auto-generated method stub
    return null;
  }

}
