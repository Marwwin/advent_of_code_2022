package com.marwwin.adventofcode2022.aoc;

import java.util.Arrays;

public class LeaderBoard {
  int[] list;

  public LeaderBoard(int length) {
    list = new int[length];
  }

  public int[] get() {
    return list;
  }

  public int get(int n) {
    return list[n];
  }

  public int sum() {
    return Arrays.stream(list).sum();
  }

  public void add(int value) {
    if (isValueTooSmall(value))
      return;
    insertValue(value);
  }

  private boolean isValueTooSmall(int n) {
    return n < list[list.length - 1];
  }

  private void insertValue(int value) {
    int insertionIndex = getInsertionIndex(value);
    for (int i = list.length - 1; i >= 0; i--) {
      if (i == insertionIndex)
        list[i] = value;
      if (i < insertionIndex)
        list[i] = list[i];
      if (i > insertionIndex)
        list[i] = list[i - 1];
    }
  }

  private int getInsertionIndex(int n) {
    for (int i = 0; i < list.length; i++) {
      if (n > list[i]) {
        return i;
      }
    }
    return 0;
  }
}
