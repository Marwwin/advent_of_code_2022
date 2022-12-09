package com.marwwin.adventofcode2022.day9;

public class RopeBridge {
  Knot head;
  Knot tail;
  int i = 0;

  public RopeBridge() {
    head = new Knot();
    tail = new Knot();
  }

  public Knot head() {
    return head;
  }

  public Knot tail() {
    return tail;
  }

  public void move(String string) {
    KnotMove move = new KnotMove(string);
    i++;
    while (move.getSteps() > 0) {
      moveKnot(move, head);
      if (isTailTooFarAway()) {
        tail.setKnot(head.getPrevious());
      }
      move.step();
      tail.savePosition();
    }
  }

  private KnotMove shouldTailMoveDiagonally(KnotMove move) {
    System.out.println(head + " " + tail);
    System.out.println(" " + head.x() + " " + tail.x() + " x:" + (head.x() - tail.x()));
    System.out.println(" " + head.y() + " " + tail.y() + " y:" + (head.y() - Math.abs(tail.y())));

    if (head.x() - tail.x() >= 2) {
      if (head.y() > tail.y()) {
        System.out.println("UR");
        return new KnotMove(KnotMoves.UPRIGHT);
      }
      if (head.y() < tail.y()) {
        System.out.println("1DR");
        return new KnotMove(KnotMoves.DOWNRIGHT);
      }
    }
    if (head.x() - tail.x() <= -2) {
      if (head.y() > tail.y()) {
        System.out.println("UL");
        return new KnotMove(KnotMoves.UPLEFT);
      }
      if (head.y() < tail.y()) {
        System.out.println("DL");
        return new KnotMove(KnotMoves.DOWNLEFT);
      }
    }
    if (head.y() - tail.y() >= 2) {
      if (head.x() > tail.x()) {
        System.out.println("UR");
        return new KnotMove(KnotMoves.UPRIGHT);
      }
      if (head.x() < tail.x()) {
        System.out.println("2DR");
        return new KnotMove(KnotMoves.DOWNRIGHT);
      }
    }
    if (head.y() - tail.y() <= -2) {
      if (head.x() > tail.x()) {
        System.out.println("UL");
        return new KnotMove(KnotMoves.UPLEFT);
      }
      if (head.x() < tail.x()) {
        System.out.println("DL");
        return new KnotMove(KnotMoves.DOWNLEFT);
      }
    }
    return move;
  }

  public boolean isTailTooFarAway() {
    if (head.x() - tail.x() >= 2)
      return true;
    if (head.x() - tail.x() <= -2)
      return true;
    if (head.y() - tail.y() >= 2)
      return true;
    if (head.y() - tail.y() <= -2)
      return true;
    return false;
  }

  private void moveKnot(KnotMove move, Knot knot) {
    System.out.println(knot.x() + " " + knot.y());

    knot.savePrevious();
    if (move.getDirection() == KnotMoves.RIGHT)
      knot.right();
    if (move.getDirection() == KnotMoves.LEFT)
      knot.left();
    if (move.getDirection() == KnotMoves.UP)
      knot.up();
    if (move.getDirection() == KnotMoves.DOWN)
      knot.down();
    if (move.getDirection() == KnotMoves.UPRIGHT)
      knot.upRight();
    if (move.getDirection() == KnotMoves.UPLEFT)
      knot.upLeft();
    if (move.getDirection() == KnotMoves.DOWNRIGHT)
      knot.downRight();
    if (move.getDirection() == KnotMoves.DOWNLEFT)
      knot.downLeft();
  }

  public Integer visited() {
    return tail.visited();
  }
}
