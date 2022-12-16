package com.marwwin.adventofcode2022.day15;

import com.marwwin.adventofcode2022.aoc.Position;

public class Beacon extends Position {

  public Beacon(int x, int y) {
    super(x, y);
  }

  public Beacon(int[] coordinates) {
    super(coordinates);
  }

  public boolean isAt(int x, int y) {
    return this.getX() == x && this.getY() == y;
  }
}
