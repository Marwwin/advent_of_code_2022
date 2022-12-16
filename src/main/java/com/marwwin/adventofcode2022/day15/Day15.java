package com.marwwin.adventofcode2022.day15;

import java.util.List;

import com.marwwin.aoc.AoC;
import com.marwwin.aoc.Day;

public class Day15 extends Day {
  List<String> input;

  public Day15(boolean test) {
    super("Day 15");
    input = AoC.getInputAsString("day15", test);
  }

  @Override
  public Object part1() {
    BeaconExlusionZone bez = new BeaconExlusionZone(input);
    return bez.coverageOnRow(10).size();
  }

  public Object part1RealData(int y) {
    BeaconExlusionZone bez = new BeaconExlusionZone(input);
    return bez.coverageOnRow(y).size();
  }

  @Override
  public Object part2() {
    BeaconExlusionZone bez = new BeaconExlusionZone(input);
    return bez.getTuningFrequency(0, 4000000);
  }

}
