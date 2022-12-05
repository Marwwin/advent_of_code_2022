package com.marwwin.adventofcode2022.aoc.BinaryTree;

public class BinaryTree {
  Node root;

  public BinaryTree() {
  }

  public Node getRoot() {
    return root;
  }

  ////////////
  // INSERT //
  ////////////
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

  ////////////
  // SEARCH //
  ////////////

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

  ////////////
  // DELETE //
  ////////////

  public void delete(int value) {
    Node parent = getParentWithChildContaining(value);
    if (parent == null)
      return;
    deleteHelper(value, parent);
  }

  public Node getParentWithChildContaining(int value) {
    return getParentHelper(value, root);
  }

  private Node getParentHelper(int value, Node node) {
    if (node == null)
      return null;
    if (doesChildContainValue(value, node))
      return node;
    if (value < node.value())
      return getParentHelper(value, node.left());
    if (value > node.value())
      return getParentHelper(value, node.right());
    return null;
  }

  private boolean doesChildContainValue(int value, Node node) {
    return (node.left() != null && value == node.left().value())
        || (node.right() != null && value == node.right().value());
  }

  private void deleteHelper(int value, Node parent) {
    Node left = parent.left();
    Node right = parent.right();

    if (left != null && value == left.value()) {
      deleteLeft(left, parent);
    }
    if (right != null && value == right.value()) {
      deleteRight(right, parent);
    }
  }

  private void deleteLeft(Node node, Node parent) {
    if (isLeaf(node)) {
      parent.setLeft(null);
      return;
    }
    if (node.left() == null) {
      parent.setLeft(node.right());
      return;
    }
    if (node.right() == null) {
      parent.setLeft(node.left());
      return;
    }
    insertHelper(node.left(), node.right());
    parent.setLeft(node.right());
  }

  private void deleteRight(Node node, Node parent) {
    if (isLeaf(node)) {
      parent.setRight(null);
      return;
    }
    if (node.left() == null) {
      parent.setRight(node.right());
      return;
    }
    if (node.right() == null) {
      parent.setRight(node.left());
      return;
    }
    insertHelper(node.left(), node.right());
    parent.setRight(node.right());
  }

  private boolean isLeaf(Node node) {
    if (node.left() == null && node.right() == null)
      return true;
    return false;
  }

  ///////////
  // PRINT //
  ///////////

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
