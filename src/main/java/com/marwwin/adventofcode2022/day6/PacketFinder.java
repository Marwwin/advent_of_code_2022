package com.marwwin.adventofcode2022.day6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PacketFinder {
  private List<Integer> memory;
  private int target;

  public PacketFinder(int length) {
    memory = new ArrayList<Integer>();
    target = length;
  }

  public void add(int c) {
    if (this.isFull()) {
      memory.remove(0);
    }
    memory.add(c);
  }

  public boolean isFull() {
    return memory.size() == target;
  }

  public boolean isFound() {
    Set<Integer> result = new HashSet<Integer>(memory);
    return result.size() == target;
  }

  public int size() {
    return memory.size();
  }

  public void print() {
    memory.forEach(System.out::println);
  }
}
