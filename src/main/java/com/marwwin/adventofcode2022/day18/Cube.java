package com.marwwin.adventofcode2022.day18;

import com.marwwin.aoc.Coord;
import com.marwwin.aoc.Directions;

public class Cube {
  private Coord position;
  private int x;
  private int y;
  private int z;

  private boolean right = false;
  private boolean left = false;
  private boolean up = false;
  private boolean down = false;
  private boolean above = false;
  private boolean below = false;
  private int score;

  public Cube(int x, int y, int z) {

    position = new Coord(x, y, z);
    this.x = x;
    this.y = y;
    this.z = z;
    this.score = x + y + z;
  }

  public Cube(String string) {
    String[] coordinates = string.split(",");
    this.x = Integer.parseInt(coordinates[0]);
    this.y = Integer.parseInt(coordinates[1]);
    this.z = Integer.parseInt(coordinates[2]);
    position = new Coord(
        Integer.parseInt(coordinates[0]),
        Integer.parseInt(coordinates[1]),
        Integer.parseInt(coordinates[2]));

    this.score = position.getX() + position.getY() + position.getZ();
  }

  public int getX() {
    return position.getX();
  }

  public int getY() {
    return position.getY();
  }

  public int getZ() {
    return position.getZ();
  }

  public boolean isRight() {
    return right;
  }

  public boolean isLeft() {
    return left;
  }

  public boolean isUp() {
    return up;
  }

  public boolean isDown() {
    return down;
  }

  public boolean isAbove() {
    return above;
  }

  public boolean isBelow() {
    return below;
  }

  public void setRight(boolean right) {
    this.right = right;
  }

  public void setLeft(boolean left) {
    this.left = left;
  }

  public void setUp(boolean up) {
    this.up = up;
  }

  public void setDown(boolean down) {
    this.down = down;
  }

  public void setAbove(boolean above) {
    this.above = above;
  }

  public void setBelow(boolean below) {
    this.below = below;
  }

  public int exposedSides() {
    return countExposed(right) +
        countExposed(left) +
        countExposed(up) +
        countExposed(down) +
        countExposed(above) +
        countExposed(below);
  }

  public int countExposed(boolean bool) {
    return (!bool) ? 1 : 0;
  }

  public Integer score() {
    return score;
  }

  public Directions isConnected(Cube cubeWithLowerScore) {
    if (x == cubeWithLowerScore.getX() && y == cubeWithLowerScore.getY()) {
      if (z > cubeWithLowerScore.getZ())
        return Directions.BACKWARD;
      return Directions.FORWARD;
    }
    if (x == cubeWithLowerScore.getX() && z == cubeWithLowerScore.getZ()) {
      if (y > cubeWithLowerScore.getY())
        return Directions.DOWN;
      return Directions.UP;
    }
    if (y == cubeWithLowerScore.getY() && z == cubeWithLowerScore.getZ()) {
      if (x > cubeWithLowerScore.getX())
        return Directions.LEFT;
      return Directions.RIGHT;
    }
    return null;
  }

  public void connect(Directions connected) {
    if (connected == Directions.RIGHT)
      right = true;
    if (connected == Directions.LEFT)
      left = true;
    if (connected == Directions.UP)
      up = true;
    if (connected == Directions.DOWN)
      down = true;
    if (connected == Directions.FORWARD)
      above = true;
    if (connected == Directions.BACKWARD)
      below = true;
  }

  @Override
  public String toString() {
    return "Cube [x=" + x + ", y=" + y + ", z=" + z + ", right=" + right + ", left=" + left + ", up=" + up + ", down="
        + down + ", above=" + above + ", below=" + below + ", score=" + score + "]";
  }

  public Coord getPosition() {
    return position;
  }




}
