package com.marwwin.adventofcode2022.day9;

public class KnotMove {
  private KnotMoves direction;
  private int steps;

  public KnotMove(String string) {
    String[] move = string.split(" ");
    direction = parseDirection(move);
    steps = Integer.parseInt(move[1]);
  }

  private KnotMoves parseDirection(String[] move) {
    String direction = move[0];
    if (direction.equals("U"))
      return KnotMoves.UP;
    if (direction.equals("D"))
      return KnotMoves.DOWN;
    if (direction.equals("R"))
      return KnotMoves.RIGHT;
    if (direction.equals("L"))
      return KnotMoves.LEFT;
    if (direction.equals("UR"))
      return KnotMoves.UPRIGHT;
    if (direction.equals("UL"))
      return KnotMoves.UPLEFT;
    if (direction.equals("DR"))
      return KnotMoves.DOWNRIGHT;
    if (direction.equals("DL"))
      return KnotMoves.DOWNLEFT;
    return null;
  }

  public KnotMoves getDirection() {
    return direction;
  }

  public int getStepsRemaining() {
    return steps;
  }

  public boolean nextStep() {
    return steps-- > 0;
  }
}
