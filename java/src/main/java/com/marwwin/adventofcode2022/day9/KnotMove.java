package com.marwwin.adventofcode2022.day9;

import com.marwwin.aoc.Directions;

public class KnotMove {
  private Directions direction;
  private int steps;

  public KnotMove(String string) {
    String[] move = string.split(" ");
    direction = parseDirection(move[0]);
    steps = Integer.parseInt(move[1]);
  }

  private Directions parseDirection(String direction) {
    if (direction.equals("U"))
      return Directions.UP;
    if (direction.equals("D"))
      return Directions.DOWN;
    if (direction.equals("R"))
      return Directions.RIGHT;
    if (direction.equals("L"))
      return Directions.LEFT;
    if (direction.equals("UR"))
      return Directions.UPRIGHT;
    if (direction.equals("UL"))
      return Directions.UPLEFT;
    if (direction.equals("DR"))
      return Directions.DOWNRIGHT;
    if (direction.equals("DL"))
      return Directions.DOWNLEFT;
    return null;
  }

  public Directions getDirection() {
    return direction;
  }

  public int getStepsRemaining() {
    return steps;
  }

  public boolean nextStep() {
    return steps-- > 0;
  }
}
