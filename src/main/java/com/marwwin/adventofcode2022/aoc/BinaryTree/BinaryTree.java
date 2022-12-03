package com.marwwin.adventofcode2022.aoc.BinaryTree;

public class BinaryTree {
  public static void insert(int value, Node node) {
    if (node.isEmpty())
      node.setValue(value);
    if (value < node.value()) {
      if (node.left() == null)
        node.setLeft(new Node(value));
      else
        insert(value, node.left());
    }
    if (value > node.value()) {
      if (node.right() == null)
        node.setRight(new Node(value));
      else
        insert(value, node.right());
    }
  }

  public static boolean hasValue(int value, Node node) {
    if (node == null)
      return false;
    if (value == node.value())
      return true;
    if (value < node.value())
      return hasValue(value, node.left());
    if (value > node.value())
      return hasValue(value, node.right());
    return false;
  }
}
