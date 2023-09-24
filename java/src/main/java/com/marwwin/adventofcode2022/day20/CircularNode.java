package com.marwwin.adventofcode2022.day20;

public class CircularNode {
  private int value = 0;
  private CircularNode right;
  private CircularNode left;

  public CircularNode(int value, CircularNode right) {
    this.value = value;
    this.right = right;
  }

  public CircularNode(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public Object hasRightChild() {
    return true;
  }

  public CircularNode getRightChild() {
    return right;
  }

  public void setRightChild(CircularNode circularNode) {
    right = circularNode;
  }

  public void setLeftChild(CircularNode circularNode) {
    left = circularNode;
  }

  public CircularNode getLeftChild() {
    return left;
  }

  @Override
  public String toString() {
    return "CircularNode [value=" + value + ", right=" + right.getValue() + ", left=" + left.getValue() + "]";
  }
}
