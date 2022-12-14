package com.marwwin.adventofcode2022.day12;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import javax.naming.spi.DirStateFactory.Result;

import com.marwwin.aoc.Matrix;
import com.marwwin.aoc.BinaryTree.Node;

public class Hill extends Matrix {

  HillNode startPosition;
  HillNode endPosition;
  Queue<HillNode> discovered;
  HillNode root;

  public Hill(List<String> input) {
    super(input);
    startPosition = find('S');
    endPosition = find('E');
    discovered = new LinkedList<HillNode>();
  }

  public HillNode find(char ch) {
    int[][] matrix = getMatrix();
    for (int column = 0; column < height(); column++) {
      for (int row = 0; row < width(); row++) {
        if (matrix[column][row] == (ch - '0'))
          return new HillNode(row, column);
      }
    }
    return null;
  }

  public HillNode build(char ch) {
    int[][] matrix = getMatrix();
    for (int column = 0; column < height(); column++) {
      for (int row = 0; row < width(); row++) {
        if (matrix[column][row] == (ch - '0'))
          return new HillNode(row, column);
      }
    }
    return null;
  }

  public HillNode getStart() {
    return startPosition;
  }

  public HillNode getEnd() {
    return endPosition;
  }

  public double getDistance(HillNode start, HillNode end) {
    int x = Math.abs(start.getX() - end.getX());
    int y = Math.abs(start.getY() - end.getY());
    return Math.sqrt((x * x) + (y * y));
  }

  public PriorityQueue<Integer> getDiscovered() {
    return discovered;
  }

  public void addToDiscovered(HillNode node) {
    node.setDistance(getDistance(node, endPosition));
  }

  private String rightOf(HillNode HillNode) {
    return (HillNode.getX() + 1) + "x" + HillNode.getY();
  }

  private String leftOf(HillNode HillNode) {
    return (HillNode.getX() - 1) + "x" + HillNode.getY();
  }

  private String above(HillNode HillNode) {
    return HillNode.getX() + "x" + (HillNode.getY() + 1);
  }

  private String below(HillNode HillNode) {
    return HillNode.getX() + "x" + (HillNode.getY() - 1);
  }

  public Boolean getHillNode(HillNode HillNode) {
    return getHillNode(HillNode.toString());
  }

  public Boolean getHillNode(String HillNode) {
    Boolean s = matrix.get(HillNode);
    return s != null && s;
  }

}
