package com.marwwin.adventofcode2022.day15;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.marwwin.aoc.AoC;

public class BeaconExlusionZoneTest {

  @Test
  public void shouldMeaseDistanceBetweenBeaconAndSensor() {
    Sensor sensor = new Sensor(0, 0);
    assertEquals(sensor.calculateDistance(new Beacon(5, 5)), 10);

    Sensor sensor2 = new Sensor(-3, 3);
    assertEquals(sensor2.calculateDistance(new Beacon(5, -1)), 12);
  }

  @Test
  public void shouldParseInput() {
    BeaconExlusionZone bez = new BeaconExlusionZone(AoC.getInputAsString("day15", true));
    assertEquals(bez.getBeacons().size(), 14);
    assertEquals(bez.getSensors().size(), 14);
  }

 // @Test
 // public void shouldFindClosestBeacon() {
 //   BeaconExlusionZone bez = new BeaconExlusionZone(AoC.getInputAsString("day15", true));
 //   List<Sensor> sensors = bez.getSensors();
//
 //   Beacon closestBeaconOne = bez.findClosestBeacon(sensors.get(0));
 //   assertEquals(closestBeaconOne.getX(), -2);
 //   assertEquals(closestBeaconOne.getY(), 15);
//
 //   Beacon closestBeaconTwo = bez.findClosestBeacon(sensors.get(1));
 //   assertEquals(closestBeaconTwo.getX(), 10);
 //   assertEquals(closestBeaconTwo.getY(), 16);
//
 //   Beacon closestBeaconThree = bez.findClosestBeacon(sensors.get(2));
 //   assertEquals(closestBeaconThree.getX(), 15);
 //   assertEquals(closestBeaconThree.getY(), 3);
 // }

  @Test
  public void shouldTestScan() {
    BeaconExlusionZone bez = new BeaconExlusionZone(AoC.getInputAsString("day15", true));
    assertEquals(bez.getSensors().get(13).getClosestBeacon().getX(), 15);
    assertEquals(bez.getSensors().get(13).getClosestBeacon().getY(), 3);
    assertEquals(bez.getSensors().get(13).getDistanceToClosest(), 7);
  }

  @Test
  public void shouldReturnTrueIfBeaconAtPosition() {
    BeaconExlusionZone bez = new BeaconExlusionZone(AoC.getInputAsString("day15", true));
    assertFalse(bez.isBeaconAt(0, 0));
    assertTrue(bez.isBeaconAt(2, 10));
  }

  @Test
  public void shouldTestCoverageOnOneLine() {
    BeaconExlusionZone bez = new BeaconExlusionZone(AoC.getInputAsString("day15", true));
    assertEquals(bez.coverageOnRow(9).size(), 25);
    assertEquals(bez.coverageOnRow(10).size(), 26);
  }

  @Test
  public void shouldFindEmptySpot() {
    BeaconExlusionZone bez = new BeaconExlusionZone(AoC.getInputAsString("day15", true));
    int[] d = bez.findDistressSignal(0, 20);
    assertEquals(d[0], 14);
    assertEquals(d[1], 11);
  }

  // @Test
  // public void getTuningFrequency() {
  // BeaconExlusionZone bez = new BeaconExlusionZone(AoC.getInputAsString("day15",
  // true));
  // bez.scan();
  // BigInteger freq = bez.getTuningFrequency(0, 20);
  // assertEquals(freq, new BigInteger("56000011"));
  // }

  // @Test
  // public void getTuningFrequencyReal() {
  // BeaconExlusionZone bez = new BeaconExlusionZone(AoC.getInputAsString("day15",
  // false));
  // bez.scan();
  // BigInteger freq = bez.getTuningFrequency(0, 4000000);
  // assertEquals(freq, new BigInteger("12274327017867"));
  // }

}
