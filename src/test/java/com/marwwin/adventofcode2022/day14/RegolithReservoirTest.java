package com.marwwin.adventofcode2022.day14;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.marwwin.aoc.AoC;

public class RegolithReservoirTest {
  @Test
  public void shouldCreateAReservoir() {
    RegolithReservoir reservoir = new RegolithReservoir(AoC.getInputAsString("day14", true));
    assertEquals(reservoir.at(498, 4), Unit.ROCK);
    assertEquals(reservoir.at(498, 5), Unit.ROCK);
    assertEquals(reservoir.at(498, 6), Unit.ROCK);
    assertEquals(reservoir.at(497, 6), Unit.ROCK);
    assertEquals(reservoir.at(496, 6), Unit.ROCK);

    assertEquals(reservoir.at(499, 4), Unit.AIR);
    assertEquals(reservoir.at(500, 4), Unit.AIR);
    assertEquals(reservoir.at(501, 4), Unit.AIR);

    assertEquals(reservoir.at(502, 4), Unit.ROCK);
    assertEquals(reservoir.at(503, 4), Unit.ROCK);

    assertEquals(reservoir.at(502, 5), Unit.ROCK);
    assertEquals(reservoir.at(502, 6), Unit.ROCK);
    assertEquals(reservoir.at(502, 7), Unit.ROCK);
    assertEquals(reservoir.at(502, 8), Unit.ROCK);
    assertEquals(reservoir.at(502, 9), Unit.ROCK);

    assertEquals(reservoir.at(494, 9), Unit.ROCK);
    assertEquals(reservoir.at(495, 9), Unit.ROCK);
    assertEquals(reservoir.at(496, 9), Unit.ROCK);
    assertEquals(reservoir.at(497, 9), Unit.ROCK);
    assertEquals(reservoir.at(498, 9), Unit.ROCK);
    assertEquals(reservoir.at(499, 9), Unit.ROCK);
    assertEquals(reservoir.at(500, 9), Unit.ROCK);
    assertEquals(reservoir.at(501, 9), Unit.ROCK);
  }

  @Test
  public void shouldCreateASandAndItShouldDropDown() {
    RegolithReservoir reservoir = new RegolithReservoir(AoC.getInputAsString("day14", true));
    reservoir.dropSand();
    assertEquals(reservoir.at(500, 8), Unit.SAND);
    reservoir.dropSand();
    assertEquals(reservoir.at(499, 8), Unit.SAND);
    reservoir.dropSand();
    assertEquals(reservoir.at(501, 8), Unit.SAND);
  }

  @Test
  public void shouldDrow22sands() {
    RegolithReservoir reservoir = new RegolithReservoir(AoC.getInputAsString("day14", true));

    for (int i = 0; i < 25; i++)
      reservoir.dropSand();
    assertEquals(reservoir.at(500, 2), Unit.SAND);

  }

  @Test
  public void shouldDrow() {
    RegolithReservoir reservoir = new RegolithReservoir(AoC.getInputAsString("day14", false));

    while (reservoir.getAtBottom() == false) {
      reservoir.dropSand();

    }
  }

  @Test
  public void shouldDrowpart2test() {
    RegolithReservoir reservoir = new RegolithReservoir(AoC.getInputAsString("day14", true));

    for (int i = 0; i < 93; i++)
      reservoir.dropSandPart2();
    System.out.println(reservoir.getAmountOfSand());
    reservoir.print();
  }
  @Test
  public void shouldDrowpart2() {
    RegolithReservoir reservoir = new RegolithReservoir(AoC.getInputAsString("day14", false));

    while (!reservoir.startingPointIsBlocked()) {
      reservoir.dropSandPart2();
    }
    System.out.println(reservoir.getAmountOfSand());

  }
}
