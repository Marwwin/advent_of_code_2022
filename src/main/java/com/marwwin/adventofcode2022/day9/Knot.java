package com.marwwin.adventofcode2022.day9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Knot {

  // x = 0, y = 1
  List<Integer> position = new ArrayList<Integer>();
  Set<List<Integer>> visited = new HashSet<>();
  Knot tail;

  public Knot() {
    setPosition(Arrays.asList(0, 0));
    savePosition();
  }

  public Knot(int numberOfTails) {
    setPosition(Arrays.asList(0, 0));
    savePosition();
    if (numberOfTails > 0) {
      tail = new Knot(numberOfTails - 1);
    }
  }

  public void move(String string) {
    KnotMove move = new KnotMove(string);
    while (move.nextStep()) {
      moveKnot(move.getDirection());
      savePosition();
      if (distanceToTail() >= 2)
        tail.move(createTailMove());
    }
  }

  private void moveKnot(KnotMoves direction) {
    if (direction == KnotMoves.RIGHT)
      right();
    if (direction == KnotMoves.LEFT)
      left();
    if (direction == KnotMoves.UP)
      up();
    if (direction == KnotMoves.DOWN)
      down();
    if (direction == KnotMoves.UPRIGHT)
      upRight();
    if (direction == KnotMoves.UPLEFT)
      upLeft();
    if (direction == KnotMoves.DOWNRIGHT)
      downRight();
    if (direction == KnotMoves.DOWNLEFT)
      downLeft();
  }

  private String createTailMove() {
    String result = "";
    if (getY() > tail.getY())
      result += "U";
    if (getY() < tail.getY())
      result += "D";
    if (getX() > tail.getX())
      result += "R";
    if (getX() < tail.getX())
      result += "L";
    return result += " 1";
  }

  public int distanceToTail() {
    if (tail == null)
      return 0;
    return Math.max(
        Math.abs(tail.getX() - getX()),
        Math.abs(tail.getY() - getY()));
  }

  public int getX() {
    return position.get(0);
  }

  public int getY() {
    return position.get(1);
  }

  public Knot getTail() {
    return tail;
  }

  public void savePosition() {
    visited.add(new ArrayList<Integer>(position));
  }

  public int visited() {
    return visited.size();
  }

  public void setPosition(List<Integer> position) {
    this.position = position;
  }

  public void up() {
    position.set(1, position.get(1) + 1);
  }

  public void down() {
    position.set(1, position.get(1) - 1);
  }

  public void right() {
    position.set(0, position.get(0) + 1);
  }

  public void left() {
    position.set(0, position.get(0) - 1);
  }

  public void upLeft() {
    up();
    left();
  }

  public void upRight() {
    up();
    right();
  }

  public void downRight() {
    down();
    right();
  }

  public void downLeft() {
    down();
    left();
  }

  @Override
  public String toString() {
    return "Knot " + position + " ";
  }

}
