package com.marwwin.adventofcode2022.day12;

import java.util.ArrayList;
import java.util.List;

import com.marwwin.adventofcode2022.aoc.Position;

public class HillNode extends Position {

  private int value;
  private HillNode left = null;
  private HillNode right = null;
  private HillNode down = null;
  private HillNode up = null;
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

  public List<HillNode> getNeighbours() {
    List<HillNode> nodes = new ArrayList<HillNode>();

    if (left != null)
      nodes.add(left);

    if (right != null)
      nodes.add(right);

    if (up != null)
      nodes.add(up);

    if (down != null)
      nodes.add(down);

    return nodes;
  }

}
