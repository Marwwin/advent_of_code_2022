package com.marwwin.adventofcode2022.aoc.BinaryTree;

public class BinaryTree {
  Node root;

  public BinaryTree() {
  }

  public Node getRoot() {
    return root;
  }

  public void insert(int value) {
    Node node = new Node(value);
    if (root == null) {
      root = node;
      return;
    }
    insertHelper(node, root);
  }

  private void insertHelper(Node node, Node root) {
    if (node.value() < root.value())
      insertLeft(node, root);
    if (node.value() > root.value())
      insertRight(node, root);
  }

  private void insertLeft(Node node, Node root) {
    if (root.left() == null) {
      root.setLeft(node);
      return;
    }
    insertHelper(node, root.left());
  }

  private void insertRight(Node node, Node root) {
    if (root.right() == null) {
      root.setRight(node);
      return;
    }
    insertHelper(node, root.right());
  }

  public Node search(int value) {
    return searchHelper(value, root);
  }

  private Node searchHelper(int value, Node node) {
    if (node == null)
      return null;
    if (value < node.value())
      return searchHelper(value, node.left());
    if (value > node.value())
      return searchHelper(value, node.right());
    return node;
  }

  public Node getParent(int value) {
    return getParentHelper(value, root);
  }

  private Node getParentHelper(int value, Node node) {
    if (node == null)
      return null;
    if (isChild(value, node))
      return node;
    if (value < node.value())
      return getParentHelper(value, node.left());
    if (value > node.value())
      return getParentHelper(value, node.right());
    return null;
  }

  private boolean isChild(int value, Node node) {
    return (node.left() != null && value == node.left().value())
        || (node.right() != null && value == node.right().value());
  }

  public void delete(int value) {
    Node parent = getParent(value);
    if (parent == null)
      return;
    deleteHelper(value, parent);
  }

  private void deleteHelper(int value, Node parent) {
    Node left = parent.left();
    Node right = parent.right();

    if (left != null && value == left.value()) {
      if (isLeaf(left)) {
        parent.setLeft(null);
        return;
      }
      if (left.left() == null) {
        parent.setLeft(left.right());
        return;
      }
      if (left.right() == null) {
        parent.setLeft(left.left());
        return;
      }
      insertHelper(left.left(), left.right());
      parent.setLeft(left.right());
    }
    if (right != null && value == right.value()) {
      if (isLeaf(right)) {
        parent.setRight(null);
        return;
      }
      if (right.left() == null) {
        parent.setRight(right.right());
        return;
      }
      if (right.right() == null) {
        parent.setRight(right.left());
        return;
      }
      insertHelper(right.left(), right.right());
      parent.setRight(right.right());
    }
  }

  private boolean isLeaf(Node node) {
    if (node.left() == null && node.right() == null)
      return true;
    return false;
  }

  public void printTree() {
    printTreeHelper(root);
  }

  private void printTreeHelper(Node node) {
    System.out.println(node.value());
    if (node.left() != null) {
      printTreeHelper(node.left());
    }
    if (node.right() != null) {
      printTreeHelper(node.right());
    }
  }
}
