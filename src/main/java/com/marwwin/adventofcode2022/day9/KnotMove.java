package com.marwwin.adventofcode2022.day9;

public class KnotMove {
  private KnotMoves direction;
  private int steps;

  public KnotMove(String string) {
    String[] move = string.split(" ");
    direction = parseDirection(move);
    steps = Integer.parseInt(move[1]);
  }

  public KnotMove(KnotMoves direction) {
    this.direction = direction;
    this.steps = 1;
  }

  private KnotMoves parseDirection(String[] move) {
    String direction = move[0];
    if (direction.equals("R"))
      return KnotMoves.RIGHT;
    if (direction.equals("L"))
      return KnotMoves.LEFT;
    if (direction.equals("U"))
      return KnotMoves.UP;
    if (direction.equals("D"))
      return KnotMoves.DOWN;
    return null;
  }
  
  public KnotMoves getDirection() {
    return direction;
  }

  public int getSteps() {
    return steps;
  }

  public void step() {
    steps--;
  }
}
