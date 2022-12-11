package com.marwwin.adventofcode2022.day11;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.marwwin.aoc.AoC;
import com.marwwin.aoc.Day;

public class Day11 extends Day {

  MonkeyHouse monkeyHouse;

  public Day11(boolean test) {
    super("Day 11");
    monkeyHouse = new MonkeyHouse(AoC.getInputAsString("day11", test));
  }

  @Override
  public Object part1() {
    monkeyHouse.setWorryLevelDivisor(3);
    for (int i = 0; i < 20; i++) {
      monkeyHouse.doRound();
    }
    List<Integer> results = monkeyHouse.getMonkies()
        .values()
        .stream()
        .map(monkey -> monkey.getInspectedItems())
        .sorted(Comparator.reverseOrder())
        .collect(Collectors.toList());
    return new BigDecimal(results.get(0) * results.get(1));
  }

  @Override
  public Object part2() {
    monkeyHouse.setWorryLevelDivisor(monkeyHouse.getLCM());
    for (int i = 0; i < 10000; i++) {
      monkeyHouse.doRound();
    }
    List<Long> results = monkeyHouse.getMonkies()
        .values()
        .stream()
        .map(monkey -> (long) monkey.getInspectedItems())
        .sorted(Comparator.reverseOrder())
        .collect(Collectors.toList());
    return new BigDecimal(results.get(0) * results.get(1));
  }
}
