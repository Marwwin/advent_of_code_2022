package com.marwwin.adventofcode2022.day20;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class CircularIntegerList {

  private CircularNode root = null;
  private int size;
  private List<Integer> intList;

  public CircularIntegerList(List<String> input) {
    intList = input.stream()
        .map(Integer::parseInt)
        .collect(Collectors.toList());

    this.size = input.size();
    parseCircularList(new ArrayList<>(new LinkedHashSet<>(intList)));
  }

  private void parseCircularList(List<Integer> input) {
    if (root == null) {
      root = new CircularNode(input.get(0));
    }
    root.setRightChild(parseCircularListHelper(root, input, 1));
  }

  private CircularNode parseCircularListHelper(CircularNode leftNode, List<Integer> input, int i) {
    if (input.size() == i) {
      root.setLeftChild(leftNode);
      return root;
    }

    CircularNode node = new CircularNode(input.get(i));
    node.setLeftChild(leftNode);
    node.setRightChild(parseCircularListHelper(node, input, i + 1));
    return node;
  }

  public void play(int rounds) {
    for (int i = 0; i < rounds; i++) {
      int curr = i % intList.size();
      move(intList.get(curr), intList.get(curr));
    }
  }

  public void mix() {
    for (int i = 0; i < intList.size(); i++) {
      move(intList.get(i), intList.get(i));
    }
    root = find(0);
  }

  public void move(int value, int i) {
    int currentIndex = getIndex(value);
    CircularNode node = remove(value, i > 0);
    if ((currentIndex + i) >= intList.size()) {
      ++i;
    }
    add(node, (currentIndex + i) % intList.size());
  }

  public CircularNode remove(int value, boolean movingRight) {
    CircularNode node = find(value);
    if (root.getValue() == node.getValue()) {
      root = movingRight
          ? node.getRightChild()
          : node.getLeftChild();
    }
    node.getLeftChild().setRightChild(node.getRightChild());
    node.getRightChild().setLeftChild(node.getLeftChild());
    return node;
  }

  public void add(CircularNode node, int i) {
    CircularNode right = at(i);
    CircularNode left = right.getLeftChild();

    left.setRightChild(node);
    right.setLeftChild(node);

    node.setLeftChild(left);
    node.setRightChild(right);
  }

  public int getIndex(int value) {
    return getIndexHelper(root, value, 0);
  }

  private int getIndexHelper(CircularNode node, int value, int i) {
    if (node.getValue() == value) {
      return i;
    }
    return getIndexHelper(node.getRightChild(), value, ++i);
  }

  public CircularNode getRoot() {
    return root;
  }

  public CircularNode at(int i) {
    return atHelper(root, i);
  }

  public CircularNode atHelper(CircularNode node, int i) {
    if (i == 0) {
      return node;
    }
    if (i > 0)
      return atHelper(node.getRightChild(), i - 1);
    return atHelper(node.getLeftChild(), i + 1);

  }

  public int size() {
    return size;
  }

  public CircularNode find(int value) {
    return findHelper(root, value);
  }

  private CircularNode findHelper(CircularNode node, int value) {
    return node.getValue() == value ? node : findHelper(node.getRightChild(), value);
  }

  public List<Integer> getList() {
    List<Integer> result = new ArrayList<>();
    result.add(root.getValue());
    return getListHelper(root.getRightChild(), result);
  }

  private List<Integer> getListHelper(CircularNode node, List<Integer> list) {
    if (node.getValue() == root.getValue()) {
      return list;
    }
    list.add(node.getValue());
    return getListHelper(node.getRightChild(), list);
  }
}
