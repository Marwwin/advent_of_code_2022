package com.marwwin.adventofcode2022.aoc;

public class Cell {
  int x = 0;
  int y = 0;

  public Cell(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public Cell(String string) {
    String[] position = string.split("x");
    this.x = Integer.parseInt(position[0]);
    this.y = Integer.parseInt(position[1]);;
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
