package com.marwwin.adventofcode2022.day12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HillV2BFS {

  HashMap<String, HillNode> matrix;
  int height;
  int width;
  HillNode start;
  Queue<HillNode> discovered = new LinkedList<HillNode>();
  private List<HillNode> as = new ArrayList<>();

  public HillNode getStart() {
    return start;
  }

  public HillV2BFS(List<String> list) {
    matrix = new HashMap<String, HillNode>();
    width = list.get(0).length();
    height = list.size();
    buildHill(list);
    createGraph(0, 0);
  }

  public HillNode findShortest(HillNode start) {
    System.out.println(start);
    Queue<HillNode> queue = new LinkedList<>();
    start.setExplored();
    queue.add(start);
    while (!queue.isEmpty()) {
      HillNode v = queue.remove();
      if (v.getValue() == 75)
        return v;
      for (HillNode n : getNeighbours(v.getX(), v.getY())) {
        if (!n.isExplored()) {
          n.setExplored();
          n.setParent(v);
          queue.add(n);
        }
      }
    }
    return null;
  }

  private void createGraph(int x, int y) {
    HillNode node = get(x, y);

    HillNode left = leftOf(node);
    if (left != null) {
      node.setLeft(left);
    }

    HillNode right = rightOf(node);
    if (right != null) {
      node.setRight(right);
    }

    HillNode above = above(node);
    if (above != null) {
      node.setUp(above);
    }

    HillNode below = below(node);
    if (below != null) {
      node.setDown(below);
    }

    if (x == getWidth() - 1 && y == getHeight() - 1)
      return;
    if (x == getWidth() - 1)
      createGraph(0, y + 1);
    else
      createGraph(x + 1, y);
  }

  private void buildHill(List<String> list) {
    for (int y = 0; y < getHeight(); y++) {
      String currentRow = list.get(y);
      for (int x = 0; x < getWidth(); x++) {
        int value = currentRow.charAt(x) == 'E' ? 75 : currentRow.charAt(x) - '0';
        HillNode node = new HillNode(x, y, value);
        if (value == 'S' - '0')
          start = node;
        if (value == 'a' - '0')
          as.add(node);
        matrix.put(x + " " + y, node);
      }
    }
  }

  public HillV2BFS() {
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
    if (left != null) {
      nodes.add(left);
    }

    HillNode right = rightOf(current);
    if (right != null) {
      nodes.add(right);
    }

    HillNode above = above(current);
    if (above != null) {
      nodes.add(above);
    }

    HillNode below = below(current);
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

  public int getRouteLength(HillNode node) {
    if (node == null)
      return Integer.MAX_VALUE;
    int length = 0;
    HillNode curr = node;
    while (true) {
      if (curr.getParent() == null || curr.getValue() == 'S' - '0') {
        return length;
      } else
        curr = curr.getParent();
      length++;
    }
  }

  public int findShortestFroma() {
    System.out.println(as.size());
    int length = Integer.MAX_VALUE;
    for (HillNode a : as) {
      System.out.println(" Find lenfth: " + a);

      int route = getRouteLength(findShortest(a));
      if (route < length)
        length = route;
      clear();
    }
    return length;
  }

  public void clear() {
    for (int y = 0; y < getHeight(); y++) {
      for (int x = 0; x < getWidth(); x++) {
        get(x, y).clear();
      }
    }
  }

}
