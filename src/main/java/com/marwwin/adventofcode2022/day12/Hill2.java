package com.marwwin.adventofcode2022.day12;

import java.util.List;

import com.marwwin.aoc.Matrix;
import com.marwwin.aoc.BinaryTree.Node;

public class Hill2 extends Matrix {

  HillNode start;
  HillNode root;
  int[][] matrix;

  public HillNode getRoot() {
    return root;
  }

  public Hill2(List<String> input) {
    super(input);
    this.matrix = getMatrix();
    root = new HillNode(0, 0, matrix[0][0]);
  }

  public HillNode createNeighours(HillNode node) {
    if (node.getX() < width() - 1) {
      int x = node.getX() + 1;
      int y = node.getY();
      HillNode right = new HillNode(x, y, valueAt(x, y));
      node.setRight(right);
    }

    if (node.getY() < height() - 1) {
      int x = node.getX();
      int y = node.getY() + 1;
      HillNode down = new HillNode(x, y, valueAt(x, y));
      node.setDown(down);
    }
    return node;
  }

  // private HillNode buildHill(int x, int y, HillNode parent) {
  // HillNode node = new HillNode(x, y);
  // if (x == 0 && y == 0)
  // root = node;
  // if(x >= 0 && x < width()-1)
  // node.setLeft(x+1,y);
  // }
}
