package com.marwwin.adventofcode2022.day12;

import java.util.List;
import java.util.PriorityQueue;

import com.marwwin.aoc.Matrix;
import com.marwwin.aoc.BinaryTree.Node;

public class Hill extends Matrix {

  HillNode startPosition;
  HillNode endPosition;
  PriorityQueue<Integer> discovered;

  public Hill(List<String> input) {
    super(input);
    startPosition = find('S');
    endPosition = find('E');
    discovered = new PriorityQueue<Integer>();
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

}
