package com.marwwin.adventofcode2022.day12;

import com.marwwin.adventofcode2022.aoc.Cell;

public class HillNode extends Cell {

  private int value;
  private HillNode left;
  private HillNode right;
  private HillNode down;
  private HillNode up;
  private HillNode parent;

  public HillNode(int x, int y) {
    super(x, y);
  }

  public HillNode(int x, int y, int value) {
    super(x, y);

    this.value = value;
  }

  public HillNode getParent() {
    return parent;
  }

  public void setParent(HillNode parent) {
    this.parent = parent;
  }

  private boolean explored;

  public boolean isExplored() {
    return explored;
  }

  public HillNode getLeft() {
    return left;
  }

  public void setLeft(HillNode left) {
    this.left = left;
  }

  public HillNode getRight() {
    return right;
  }

  public void setRight(HillNode right) {
    this.right = right;
  }

  public HillNode getDown() {
    return down;
  }

  public void setDown(HillNode down) {
    this.down = down;
  }

  public HillNode getUp() {
    return up;
  }

  public void setUp(HillNode up) {
    this.up = up;
  }

  public int getValue() {
    return value;
  }

  public void setExplored() {
    explored = true;
  }

  @Override
  public String toString() {
    return "HillNode [value=" + value + " " + getX() + " " + getY() + "]";
  }

  public void clear() {
    explored = false;
    parent = null;
  }

}
