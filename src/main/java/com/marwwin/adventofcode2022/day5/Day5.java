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

  public String part1Str() {
    List<String>[] inputs = splitInput();
    CargoCrane crane = new CargoCrane(inputs[0]);
    for (String s : inputs[1]){
      crane.move(s);
    }
    return crane.getTopItems();
  }

  public String part2Str() {
    List<String>[] inputs = splitInput();
    CargoCrane crane = new CargoCrane(inputs[0]);
    for (String s : inputs[1]){
      crane.moveAll(s);
    }
    return crane.getTopItems();
  }
  @Override
  public int part2() {
    // TODO Auto-generated method stub
    return 0;
  }

  public List[] splitInput() {
    List<String> first = new ArrayList<>(input.subList(0, (indexOfEmptyElement())));
    List<String> second = new ArrayList<>(
        input.subList(indexOfEmptyElement(), input.size()));
    return new List[] { first, second };
  }

  public int indexOfEmptyElement() {
    return input.indexOf("");
  }

  @Override
  public int part1() {
    // TODO Auto-generated method stub
    return 0;
  }

}
