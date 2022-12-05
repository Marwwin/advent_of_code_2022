package com.marwwin.adventofcode2022.day2Functional;

import java.util.HashMap;

@FunctionalInterface
public interface RPS {
  void solve(HashMap<String, Integer> table);
}
