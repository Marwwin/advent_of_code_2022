package com.marwwin.adventofcode2022.aoc;

public class Position {
  int x = 0;
  int y = 0;

  public Position(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public Position(String string) {
    if (string.contains("x")) {
      String[] position = string.split("x");
      this.x = Integer.parseInt(position[0]);
      this.y = Integer.parseInt(position[1]);
    }
    if (string.contains(",")) {
      String[] position = string.split(",");
      this.x = Integer.parseInt(position[0]);
      this.y = Integer.parseInt(position[1]);
    }

  }

  public Position(int[] coordinates) {
    this.x = coordinates[0];
    this.y = coordinates[1];
  }

  public int[] getPosition() {
    return new int[] { x, y };
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  @Override
  public String toString() {
    return x + "x" + y;
  }

}
