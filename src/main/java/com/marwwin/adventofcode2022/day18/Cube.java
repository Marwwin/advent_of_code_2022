package com.marwwin.adventofcode2022.day18;

import com.marwwin.aoc.Coord;
import com.marwwin.aoc.Directions;

public class Cube {
  private Coord position;
  private int x;
  private int y;
  private int z;

  private Cube right = null;
  private Cube left = null;
  private Cube up = null;
  private Cube down = null;
  private Cube above = null;
  private Cube below = null;

  private int score;
  private boolean found;

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

  public int exposedSides() {
    return countExposed(right) +
        countExposed(left) +
        countExposed(up) +
        countExposed(down) +
        countExposed(above) +
        countExposed(below);
  }

  public int countExposed(Cube cube) {
    return (cube == null) ? 1 : 0;
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

  public void connect(Directions connected, Cube cube) {
    if (connected == Directions.RIGHT)
      right = cube;
    if (connected == Directions.LEFT)
      left = cube;
    if (connected == Directions.UP)
      up = cube;
    if (connected == Directions.DOWN)
      down = cube;
    if (connected == Directions.FORWARD)
      above = cube;
    if (connected == Directions.BACKWARD)
      below = cube;
  }

  @Override
  public String toString() {
    return "Cube [x=" + x + ", y=" + y + ", z=" + z + ", right=" + right + ", left=" + left + ", up=" + up + ", down="
        + down + ", above=" + above + ", below=" + below + ", score=" + score + "]";
  }

  public Coord getPosition() {
    return position;
  }

  public void setFound() {
    found = true;
  }

  public boolean getFound() {
    return found;
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
    return right != null;
  }

  public boolean isLeft() {
    return left != null;
  }

  public boolean isUp() {
    return up != null;
  }

  public boolean isDown() {
    return down != null;
  }

  public boolean isAbove() {
    return above != null;
  }

  public boolean isBelow() {
    return below != null;
  }

  public void setRight(Cube right) {
    this.right = right;
  }

  public void setLeft(Cube left) {
    this.left = left;
  }

  public void setUp(Cube up) {
    this.up = up;
  }

  public void setDown(Cube down) {
    this.down = down;
  }

  public void setAbove(Cube above) {
    this.above = above;
  }

  public void setBelow(Cube below) {
    this.below = below;
  }

  public Cube getRight() {
    return right;
  }

  public Cube getLeft() {
    return left;
  }

  public Cube getUp() {
    return up;
  }

  public Cube getDown() {
    return down;
  }

  public Cube getAbove() {
    return above;
  }

  public Cube getBelow() {
    return below;
  }

}
