package com.marwwin.adventofcode2022.day12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HillV2BFS {

  private HashMap<String, HillNode> matrix;
  private int height;
  private int width;
  private HillNode start;
  private List<HillNode> aNodes = new ArrayList<>();

  public HillV2BFS() {
    matrix = new HashMap<String, HillNode>();
  }

  public HillV2BFS(List<String> list) {
    matrix = new HashMap<String, HillNode>();
    width = list.get(0).length();
    height = list.size();
    buildHill(list);
    createGraph(0, 0);
  }

  public HillNode findShortest(HillNode start) {
    Queue<HillNode> queue = new LinkedList<>();
    start.setExplored();
    queue.add(start);
    while (!queue.isEmpty()) {
      HillNode node = queue.remove();
      if (node.getValue() == 75)
        return node;
      for (HillNode n : getNeighbours(node)) {
        if (!n.isExplored()) {
          n.setExplored();
          n.setParent(node);
          queue.add(n);
        }
      }
    }
    return null;
  }

  public int getRouteLength(HillNode node) {
    if (node == null)
      return Integer.MAX_VALUE;
    int length = 0;
    HillNode current = node;
    while (true) {
      if (current.getParent() == null || current.getValue() == 'S' - '0') {
        return length;
      } else
        current = current.getParent();
      length++;
    }
  }

  public int findShortestFroma() {
    int length = Integer.MAX_VALUE;
    for (HillNode a : aNodes) {
      int route = getRouteLength(findShortest(a));
      if (route < length)
        length = route;
      clear();
    }
    return length;
  }

  private void createGraph(int x, int y) {
    HillNode node = getNode(x, y);

    HillNode left = leftOf(node);
    if (left != null)
      node.setLeft(left);

    HillNode right = rightOf(node);
    if (right != null)
      node.setRight(right);

    HillNode above = above(node);
    if (above != null)
      node.setUp(above);

    HillNode below = below(node);
    if (below != null)
      node.setDown(below);

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
          aNodes.add(node);
        matrix.put(x + " " + y, node);
      }
    }
  }

  public List<HillNode> getNeighbours(HillNode current) {
    List<HillNode> nodes = new ArrayList<HillNode>();
   // HillNode current = getNode(x, y);

    HillNode left = leftOf(current);
    if (left != null)
      nodes.add(left);

    HillNode right = rightOf(current);
    if (right != null)
      nodes.add(right);

    HillNode above = above(current);
    if (above != null)
      nodes.add(above);

    HillNode below = below(current);
    if (below != null)
      nodes.add(below);

    return nodes;
  }

  private HillNode leftOf(HillNode current) {
    if (current.getX() - 1 < 0)
      return null;
    HillNode node = getNode(current.getX() - 1, current.getY());
    return isNextNodeReachable(current, node);
  }

  private HillNode rightOf(HillNode current) {
    if (current.getX() + 1 >= getWidth())
      return null;
    HillNode node = getNode(current.getX() + 1, current.getY());
    return isNextNodeReachable(current, node);
  }

  private HillNode above(HillNode current) {
    if (current.getY() - 1 < 0)
      return null;
    HillNode node = getNode(current.getX(), current.getY() - 1);
    return isNextNodeReachable(current, node);
  }

  private HillNode below(HillNode current) {
    if (current.getY() + 1 >= getHeight())
      return null;

    HillNode node = getNode(current.getX(), current.getY() + 1);
    return isNextNodeReachable(current, node);
  }

  private HillNode isNextNodeReachable(HillNode current, HillNode node) {
    if (current.getValue() == 'S' - '0')
      return node;
    if (node.getValue() > current.getValue() + 1)
      return null;
    return node;
  }

  public void clear() {
    for (int y = 0; y < getHeight(); y++) {
      for (int x = 0; x < getWidth(); x++) {
        getNode(x, y).clear();
      }
    }
  }

  public HillNode getNode(int x, int y) {
    return matrix.get(x + " " + y);
  }

  public HillNode getStart() {
    return start;
  }

  public HashMap<String, HillNode> getMatrix() {
    return matrix;
  }

  public int getHeight() {
    return height;
  }

  public int getWidth() {
    return width;
  }
}
