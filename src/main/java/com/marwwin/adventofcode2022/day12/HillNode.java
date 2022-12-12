package com.marwwin.adventofcode2022.day12;

import com.marwwin.adventofcode2022.aoc.Cell;

public class HillNode extends Cell {

  public double distance;

  public HillNode(int x, int y) {
    super(x, y);
  }

  public HillNode(int x, int y, int distance) {
    super(x, y);
    this.distance = distance;
  }

  public double getDistance() {
    return distance;
  }

  public void setDistance(double distance) {
    this.distance = distance;
  }
}
