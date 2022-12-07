package com.marwwin.aoc.BinaryTree;

public class Node {
  int value;
  Node right;
  Node left;

  public Node() {
  }

  public Node(int value) {
    this.value = value;
  }

  public Node left() {
    return left;
  }

  public Node right() {
    return right;
  }

  public int value() {
    return value;
  }

  public boolean isEmpty(){
    return value == 0;
  }

  public void setLeft(Node left) {
    this.left = left;
  }

  public void setRight(Node right) {
    this.right = right;
  }

  public void setValue(int value) {
    this.value = value;
  }
}
