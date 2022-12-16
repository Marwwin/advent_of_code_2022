package com.marwwin.adventofcode2022.day14;

import java.util.HashMap;
import java.util.List;

import com.marwwin.adventofcode2022.aoc.Position;

public class RegolithReservoir {

  private Position startingPoint = new Position(500, 0);
  private HashMap<String, Unit> reservoir = new HashMap<String, Unit>();
  private int amountOfSand = 0;
  private boolean atBottom = false;
  private int floorLevel;

  public RegolithReservoir(List<String> input) {
    parseInput(input);
  }

  private void parseInput(List<String> input) {
    for (String string : input) {
      String[] points = string.split(" -> ");
      addRocks(points);
    }
    System.out.println("floor " + floorLevel);
    addFloor();
  }

  private void addFloor() {
    for (int x = 0; x < 1000; x++) {
      reservoir.put(x + " " + floorLevel, Unit.ROCK);

    }
  }

  private void addRocks(String[] points) {
    Rock start = null;
    for (String point : points) {
      if (start == null) {
        start = new Rock(point);
        continue;
      }
      if ((start.getY() + 2) > floorLevel) {
        floorLevel = start.getY() + 2;
      }
      Rock current = new Rock(point);

      if ((current.getY() + 2) > floorLevel) {
        floorLevel = current.getY() + 2;
      }
      while (!current.toString().equals(start.toString())) {
        reservoir.put(start.toString(), Unit.ROCK);
        if (start.getY() < current.getY()) {
          start.setY(start.getY() + 1);
          continue;
        }
        if (start.getY() > current.getY()) {
          start.setY(start.getY() - 1);
          continue;
        }
        if (start.getX() < current.getX()) {
          start.setX(start.getX() + 1);
          continue;
        }
        if (start.getX() > current.getX()) {
          start.setX(start.getX() - 1);
          continue;
        }
      }
      reservoir.put(start.toString(), Unit.ROCK);
      start = current;
    }
  }

  public RegolithReservoir() {
  }

  public Object at(int x, int y) {
    Unit result = reservoir.get(x + " " + y);
    return result == null ? Unit.AIR : result;
  }

  public void dropSand() {
    amountOfSand++;
    Sand sand = new Sand(startingPoint);
    while (!sand.isAtRest() && atBottom == false) {
      simulateSand(sand);
    }
  }

  public void dropSandPart2() {
    amountOfSand++;
    Sand sand = new Sand(startingPoint);
    while (!sand.isAtRest() && !startingPointIsBlocked()) {
      simulateSand(sand);
    }
  }

  private void simulateSand(Sand sand) {
    if (atBottom(sand)) {
      return;
    }
    if (at(sand.getX(), sand.getY() + 1) == Unit.AIR) {
      sand.moveDown();
      return;
    }
    if (at(sand.getX() - 1, sand.getY() + 1) == Unit.AIR) {
      sand.moveDownLeft();
      return;

    }
    if (at(sand.getX() + 1, sand.getY() + 1) == Unit.AIR) {
      sand.moveDownRight();
      return;

    }
    if (at(sand.getX() + 1, sand.getY() + 1) != Unit.AIR &&
        at(sand.getX() - 1, sand.getY() + 1) != Unit.AIR) {
      sand.setAtRest();
      reservoir.put(sand.toString(), Unit.SAND);
    }
  }

  private boolean atBottom(Sand sand) {
    if (sand.getY() >= floorLevel) {
      sand.setAtRest();
      atBottom = true;
      // System.out.println(amountOfSand - 1);
    }
    return false;
  }

  public boolean getAtBottom() {
    return atBottom;
  }

  public boolean startingPointIsBlocked() {
    return at(500, 0) == Unit.SAND;
  }

  public int getAmountOfSand() {
    return amountOfSand;
  }

  public void print() {
    for (int y = 0; y < 20; y++) {
      for (int x = 500 - 10; x < 500 + 10; x++) {
        printUnit(x, y);
      }
      System.out.println();
    }
  }

  private void printUnit(int x, int y) {
    if (at(x, y) == Unit.SAND) {
      System.out.print("O");
      return;
    }
    if (at(x, y) == Unit.AIR) {
      System.out.print(".");
      return;
    }
    if (at(x, y) == Unit.ROCK) {
      System.out.print("#");
      return;
    }
  }
}
