package com.marwwin.adventofcode2022.day14;

import com.marwwin.adventofcode2022.aoc.Position;

public class Sand extends Position {

  int y;
  boolean atRest = false;

  public Sand(int x, int y) {
    super(x, y);
  }

  public Sand(Position startingPoint) {
    super(startingPoint.getX(), startingPoint.getY());
  }

  public void moveDown() {
    setY(getY()+1);
  }

  public boolean isAtRest() {
    return atRest;
  }

  @Override
  public String toString() {
    return getX() + " " + getY();
  }

  public void setAtRest() {
    atRest = true;
  }

  public void moveDownLeft() {
    setY(getY()+1);
    setX(getX()-1);
  }

  public void moveDownRight() {
    setY(getY()+1);
    setX(getX()+1);
  }

}
