package com.marwwin.adventofcode2022.aoc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameOfLife {
  HashMap<String, Boolean> matrix;
  Set<String> emptyNeighbours;

  public GameOfLife() {
    this.matrix = new HashMap<String, Boolean>();
    emptyNeighbours = new HashSet<String>();
  }

  public void play() throws InterruptedException, IOException {
    Runtime.getRuntime().exec("clear");
    print();
    evolve();
    Thread.sleep(500);
    play();
  }

  public void print() {
    int maxX = 0;
    int maxY = 0;

    for (String cell : matrix.keySet()) {
      int x = Math.abs(getX(cell));
      if (x > maxX)
        maxX = x;
      int y = Math.abs(getY(cell));
      if (y > maxY)
        maxY = y;
    }

    int columns = 10;
    int rows = 20;

    for (int y = columns; y >= -columns; y--) {
      for (int x = -rows; x < rows; x++) {
        if (y == -columns || y == columns) {
          System.out.print("-");
          continue;
        }
        if (x == -rows || x == rows - 1) {
          System.out.print("|");
          continue;
        }
        if (matrix.get(x + "x" + y) != null && matrix.get(x + "x" + y)) {
          System.out.print("x");
          continue;
        }
        System.out.print(" ");

      }
      System.out.println();
    }
  }

  private void evolve() {
    Object[] cells = matrix.keySet().toArray();

    List<String> toRemove = new ArrayList<String>();

    for (int i = 0; i < cells.length; i++) {
      String cell = (String) cells[i];
      if (!matrix.get(cell))
        continue;

      int neighbours = amountOfNeighbours(new Position(cell));
      if (neighbours < 2)
        toRemove.add(cell);
      if (neighbours > 3)
        toRemove.add(cell);
    }

    Object[] emptyCells = emptyNeighbours.toArray();
    List<String> toAdd = new ArrayList<String>();

    for (int i = 0; i < emptyCells.length; i++) {
      String cell = (String) emptyCells[i];

      int neighbours = amountOfNeighbours(new Position(cell));

      if (neighbours == 3) {
        toAdd.add(cell);
      }
    }
    toRemove.forEach(cell -> setCell(cell, false));
    toAdd.forEach(cell -> setCell(cell, true));

    emptyNeighbours = new HashSet<>();
  }

  public int amountOfNeighbours(Position cell) {
    int result = 0;
    if (getCell(leftOf(cell)))
      result++;
    else
      emptyNeighbours.add(leftOf(cell));

    if (getCell(rightOf(cell)))
      result++;
    else
      emptyNeighbours.add(rightOf(cell));

    if (getCell(above(cell)))
      result++;
    else
      emptyNeighbours.add(above(cell));

    if (getCell(below(cell)))
      result++;
    else
      emptyNeighbours.add(below(cell));

    return result;
  }

  private String rightOf(Position cell) {
    return (cell.getX() + 1) + "x" + cell.getY();
  }

  private String leftOf(Position cell) {
    return (cell.getX() - 1) + "x" + cell.getY();
  }

  private String above(Position cell) {
    return cell.getX() + "x" + (cell.getY() + 1);
  }

  private String below(Position cell) {
    return cell.getX() + "x" + (cell.getY() - 1);
  }

  public Boolean getCell(Position cell) {
    return getCell(cell.toString());
  }

  public Boolean getCell(String cell) {
    Boolean s = matrix.get(cell);
    return s != null && s;
  }

  public Boolean setCell(Position cell, boolean value) {
    return matrix.put(cell.toString(), value);
  }

  public Boolean setCell(String cell, boolean value) {
    return matrix.put(cell, value);
  }

  public int getX(String cell) {
    return Integer.parseInt(cell.split("x")[0]);
  }

  public int getY(String cell) {
    return Integer.parseInt(cell.split("x")[1]);
  }
}
