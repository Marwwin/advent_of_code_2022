package com.marwwin.adventofcode2022.day15;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BeaconExlusionZone {
  private List<Sensor> sensors = new ArrayList<>();
  private List<Beacon> beacons = new ArrayList<>();

  public BeaconExlusionZone(List<String> input) {
    parseInput(input);
    scan();
  }

  private void parseInput(List<String> input) {
    for (String string : input) {
      String[] strings = string.split("at ");
      String[] sensorString = strings[1].split(":");
      beacons.add(new Beacon(parseCoordinates(strings[2])));
      sensors.add(new Sensor(parseCoordinates(sensorString[0])));
    }
  }

  private int[] parseCoordinates(String string) {
    String[] coordinates = string.split(",");
    int x = Integer.parseInt(coordinates[0].substring(2));
    int y = Integer.parseInt(coordinates[1].substring(3));
    return new int[] { x, y };
  }

  public void scan() {
    for (Sensor sensor : sensors) {
      sensor.findClosestBeacon(beacons);
    }
  }

  public Set<Integer> coverageOnRow(int y) {
    Set<Integer> positions = new HashSet<>();
    for (Sensor sensor : sensors) {
      if (sensor.isPointInsideCoverage(sensor.getX(), y)) {
        for (int i = 0; i <= sensor.distanceToEndOfCoverage(sensor.getX(), y); i++) {
          if (!isBeaconAt(sensor.getX() + i, y))
            positions.add(sensor.getX() + i);
          if (!isBeaconAt(sensor.getX() - i, y))
            positions.add(sensor.getX() - i);
        }
      }
    }
    return positions;
  }

  public boolean isBeaconAt(int x, int y) {
    for (Beacon beacon : beacons) {
      if (beacon.isAt(x, y))
        return true;
    }
    return false;
  }

  public int[] findDistressSignal(int lowerBound, int upperBound) {
    for (int y = lowerBound; y < upperBound; y++) {
      for (int x = lowerBound; x < upperBound; x++) {
        Sensor sensor = getSensorThatIncludesPointInCoverage(x, y);
        if (sensor == null)
          return new int[] { x, y };
        x += Math.min(sensor.distanceToEndOfCoverage(x, y), upperBound);
      }
    }
    return new int[] { 0, 0 };
  }

  public Sensor getSensorThatIncludesPointInCoverage(int x, int y) {
    for (Sensor sensor : sensors) {
      if (sensor.isPointInsideCoverage(x, y))
        return sensor;
    }
    return null;
  }

  public BigInteger getTuningFrequency(int lowerBound, int upperBound) {
    int[] position = findDistressSignal(lowerBound, upperBound);
    return (new BigInteger(Integer.toString(position[0]))
        .multiply(new BigInteger("4000000")))
        .add(new BigInteger(Integer.toString(position[1])));
  }

  public List<Sensor> getSensors() {
    return sensors;
  }

  public List<Beacon> getBeacons() {
    return beacons;
  }
}
