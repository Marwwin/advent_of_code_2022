package com.marwwin.adventofcode2022.day15;

import java.util.List;

import com.marwwin.adventofcode2022.aoc.Position;

public class Sensor extends Position {

  private Beacon closest;
  private int distance = Integer.MAX_VALUE;

  public Sensor(int x, int y) {
    super(x, y);
  }

  public Sensor(int[] coordinates) {
    super(coordinates);
  }

  public Beacon findClosestBeacon(List<Beacon> beacons) {
    for (Beacon beacon : beacons) {
      int newDistance = calculateDistance(beacon);
      if (newDistance < distance) {
        closest = beacon;
        distance = newDistance;
      }
    }
    return closest;
  }

  public Beacon getClosestBeacon() {
    return closest;
  }

  public int getDistanceToClosest() {
    return distance;
  }

  public int calculateDistance(Position target) {
    return Math.abs(this.getX() - target.getX()) + Math.abs(this.getY() - target.getY());
  }

  public int calculateDistance(int x, int y) {
    return Math.abs(this.getX() - x) + Math.abs(this.getY() - y);
  }

  public boolean isPointInsideCoverage(int x, int y) {
    return calculateDistance(x, y) <= distance;
  }

  public int distanceToEndOfCoverage(int x, int y) {
    return distance - calculateDistance(x, y);

  }

}
