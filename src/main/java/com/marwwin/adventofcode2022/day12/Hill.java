package com.marwwin.adventofcode2022.day12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Hill {

  private HashMap<String, HillNode> matrix;
  private List<HillNode> aNodes = new ArrayList<>();
  private HillNode start;
  private int height;
  private int width;

  public Hill() {
    matrix = new HashMap<String, HillNode>();
  }

  public Hill(List<String> list) {
    matrix = new HashMap<String, HillNode>();
    width = list.get(0).length();
    height = list.size();
    buildHill(list);
    createGraph(getNode(0, 0));
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

  private void createGraph(HillNode node) {
    while (node.getX() != getWidth() - 1 && node.getY() != getHeight() - 1) {
      node = setNeighbours(node);
      int x = node.getX();
      int y = node.getY();
      if (node.getX() == getWidth() - 1)
        node = getNode(0, y + 1);
      else
        node = getNode(x + 1, y);
    }
  }

  private HillNode setNeighbours(HillNode node) {
    node.setLeft(leftOf(node));
    node.setRight(rightOf(node));
    node.setUp(above(node));
    node.setDown(below(node));
    return node;
  }

  public HillNode findShortest(HillNode start) {
    Queue<HillNode> queue = new LinkedList<>();
    start.setExplored();
    queue.add(start);
    return findShortestHelper(queue);
  }

  private HillNode findShortestHelper(Queue<HillNode> queue) {
    if (queue.isEmpty())
      return null;

    HillNode current = queue.remove();
    if (current.getValue() == 75)
      return current;

    for (HillNode node : current.getNeighbours()) {
      if (node.isExplored())
        continue;
      node.setExplored();
      node.setParent(current);
      queue.add(node);
    }
    return findShortestHelper(queue);
  }

  public int getRouteLength(HillNode node) {
    if (node == null)
      return Integer.MAX_VALUE;
    return getRouteLengthHelper(node, 0);
  }

  private int getRouteLengthHelper(HillNode node, int length) {
    if (node.getParent() == null)
      return length;
    return getRouteLengthHelper(node.getParent(), length += 1);
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
