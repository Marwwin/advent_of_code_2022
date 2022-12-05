package com.marwwin.adventofcode2022.day2;

import java.util.HashMap;
import java.util.List;

import com.marwwin.adventofcode2022.aoc.AoC;

public class Day2Functional {

  public static void solve() {
    HashMap<String, Integer> part1Table = new HashMap<>();
    part1Table.put("A X", 1 + 3);
    part1Table.put("A Y", 2 + 6);
    part1Table.put("A Z", 3 + 0);
    part1Table.put("B X", 1 + 0);
    part1Table.put("B Y", 2 + 3);
    part1Table.put("B Z", 3 + 6);
    part1Table.put("C X", 1 + 6);
    part1Table.put("C Y", 2 + 0);
    part1Table.put("C Z", 3 + 3);

    HashMap<String, Integer> part2Table = new HashMap<>();
    part2Table.put("A X", 3 + 0);
    part2Table.put("B X", 1 + 0);
    part2Table.put("C X", 2 + 0);
    part2Table.put("A Y", 1 + 3);
    part2Table.put("B Y", 2 + 3);
    part2Table.put("C Y", 3 + 3);
    part2Table.put("A Z", 2 + 6);
    part2Table.put("B Z", 3 + 6);
    part2Table.put("C Z", 1 + 6);

    RPS rps = (table) -> {
      List<String> input = AoC.getInputAsString("day2", false);
      int result = input.stream()
          .map(e -> table.get(e))
          .reduce(0, (a, c) -> a + c);
      System.out.println(result);
    };
    rps.solve(part1Table);
    rps.solve(part2Table);
  }
}

