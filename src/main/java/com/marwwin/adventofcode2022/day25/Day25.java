package com.marwwin.adventofcode2022.day25;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.marwwin.aoc.AoC;
import com.marwwin.aoc.Day;

public class Day25 extends Day {

  List<String> input;

  public Day25(boolean test) {
    super("Day25");
    input = AoC.getInputAsString("day25", test);
  }

  @Override
  public Object part1() {
    BigInteger sum = BigInteger.ZERO;
    for (String str : input) {
      sum = sum.add(new SNAFU(str).getDecimal());
    }
    return new SNAFU(sum).getSNAFU();
  }

  @Override
  public Object part2() {
    // TODO Auto-generated method stub
    return null;
  }

}
