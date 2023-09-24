package com.marwwin.adventofcode2022.day6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PacketFinder {
  private List<Integer> memory = new ArrayList<Integer>();
  private int targetLength;

  public int solve(String input, int length) {
    clearMemory();
    setTargetLength(length);
    for (int i = 0; i < input.length(); i++) {
      add(input.charAt(i));
      if (isFound())
        return i + 1;
    }
    return 0;
  }

  public void add(int c) {
    if (this.isFull()) {
      memory.remove(0);
    }
    memory.add(c);
  }

  public boolean isFull() {
    return memory.size() == targetLength;
  }

  public boolean isFound() {
    return new HashSet<Integer>(memory).size() == targetLength;
  }

  public int size() {
    return memory.size();
  }

  public void setTargetLength(int targetLength) {
    this.targetLength = targetLength;
  }

  public void clearMemory(){
    memory = new ArrayList<Integer>();
  }

  public void print() {
    memory.forEach(System.out::println);
  }
}
