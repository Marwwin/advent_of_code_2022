package com.marwwin.adventofcode2022.day1;

import java.util.ArrayList;
import java.util.List;

import com.marwwin.aoc.AoC;
import com.marwwin.aoc.Day;
import com.marwwin.aoc.LeaderBoard;

public class Day1 extends Day{
  List<Integer> input;
  LeaderBoard leaderBoard = new LeaderBoard(3);

  public Day1(boolean test) {
    super("Day 1");
    input = AoC.getInputAsInteger("day1", test);
    createListOfElves(input).forEach(leaderBoard::add);
  }
  public Integer part1() {
    return leaderBoard.get(0);
  }
  public Integer part2() {
    return leaderBoard.sum();
  }
  public static List<Integer> createListOfElves(List<Integer> input) {
    List<Integer> result = new ArrayList<>();
    int current = 0;
    for (Integer i : input) {
      if (i == 0) {
        result.add(current);
        current = 0;
      } else {
        current += i;
      }
    }
    result.add(current);
    return result;
  }
}
