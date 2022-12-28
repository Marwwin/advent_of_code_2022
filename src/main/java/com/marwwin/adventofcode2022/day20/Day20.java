package com.marwwin.adventofcode2022.day20;

import java.util.List;

import com.marwwin.aoc.AoC;
import com.marwwin.aoc.Day;

public class Day20 extends Day {

  List<String> input;

  public Day20(boolean test) {
    super("Day 20");
    input = AoC.getInputAsString("day20", test);
  }

  @Override
  public Object part1() {
    CircularIntegerList list = new CircularIntegerList(input);
    System.out.println("root:" + list.getRoot());
    list.mix();
    return list.at(999 % list.size()).getValue() + list.at(1999 % list.size()).getValue() + list.at(2999 % list.size()).getValue() ;
  }

  @Override
  public Object part2() {
    // TODO Auto-generated method stub
    return null;
  }

}
