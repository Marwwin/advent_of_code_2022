package com.marwwin.adventofcode2022.day12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HillV2 {

  HashMap<String, HillNode> matrix;
  int height;
  int width;
  HillNode start;
  Queue<HillNode> discovered = new LinkedList<HillNode>();

  public HillNode getStart() {
    return start;
  }

  public HillV2(List<String> list) {
    matrix = new HashMap<String, HillNode>();
    width = list.get(0).length();
    height = list.size();
    buildHill(list);
  }

  private void buildHill(List<String> list) {
    for (int y = 0; y < getHeight(); y++) {
      String currentRow = list.get(y);
      for (int x = 0; x < getWidth(); x++) {
        int value = currentRow.charAt(x) - '0';
        HillNode node = new HillNode(x, y, value);
        if (value == 'S' - '0')
          start = node;
        matrix.put(x + " " + y, node);
      }
    }
  }

  public HillV2() {
    matrix = new HashMap<String, HillNode>();
  }

  public HashMap<String, HillNode> getHill() {
    return matrix;
  }

  public HillNode get(int x, int y) {
    return matrix.get(x + " " + y);
  }

  public void set(HillNode node) {
    matrix.put(node.getX() + " " + node.getY(), node);
  }

  public HashMap<String, HillNode> getMatrix() {
    return matrix;
  }

  public void setMatrix(HashMap<String, HillNode> matrix) {
    this.matrix = matrix;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public List<HillNode> getNeighbours(int x, int y) {
    List<HillNode> nodes = new ArrayList<HillNode>();
    HillNode current = get(x, y);

    HillNode left = leftOf(current);
    System.out.println(left);
    if (left != null) {
      nodes.add(left);
    }

    HillNode right = rightOf(current);
    System.out.println(right);

    if (right != null) {
      nodes.add(right);
    }

    HillNode above = above(current);
    System.out.println(above);

    if (above != null) {
      nodes.add(above);
    }

    HillNode below = below(current);
    System.out.println(below);
    if (below != null) {
      nodes.add(below);
    }

    return nodes;
  }

  private HillNode leftOf(HillNode current) {
    if (current.getX() - 1 < 0)
      return null;
    HillNode node = get(current.getX() - 1, current.getY());
    if (current.value == 'S' - '0')
      return node;
    if (node.value > current.value + 1)
      return null;

    return node;
  }

  private HillNode rightOf(HillNode current) {
    if (current.getX() + 1 >= getWidth())
      return null;
    HillNode node = get(current.getX() + 1, current.getY());
    if (current.value == 'S' - '0')
      return node;
    if (node.value > current.value + 1)
      return null;

    return node;

  }

  private HillNode above(HillNode current) {
    if (current.getY() - 1 < 0)
      return null;
    HillNode node = get(current.getX(), current.getY() - 1);
    if (current.value == 'S' - '0')
      return node;
    if (node.value > current.value + 1)
      return null;

    return node;

  }

  private HillNode below(HillNode current) {
    if (current.getY() + 1 >= getHeight())
      return null;
    HillNode node = get(current.getX(), current.getY() + 1);
    if (current.value == 'S' - '0')
      return node;
    if (node.value > current.value + 1)
      return null;

    return node;

  }

  public HillNode findEnd(HillNode currentNode) {
    if (currentNode.getValue() == 'E' - '0')
      return currentNode;
    List<HillNode> neighbours = getNeighbours(currentNode.getX(), currentNode.getY());

    neighbours.forEach(n -> {
      n.updateRoute(currentNode)
      if (discovered)
    });
    neighbours.forEach(discovered::add);

    // for

  }

}
