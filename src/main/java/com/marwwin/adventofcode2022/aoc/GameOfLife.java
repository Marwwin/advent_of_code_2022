package com.marwwin.adventofcode2022.aoc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class GameOfLife {
  HashMap<String, Boolean> matrix;
  Set<String> emptyNeighbours;

  public GameOfLife() {
    this.matrix = new HashMap<String, Boolean>();
    emptyNeighbours = new HashSet<String>();
  }

  public void play() throws InterruptedException {
    evolve();
    print();
    Thread.sleep(100000);
    play();
  }

  private void evolve() {
    for (String cell : matrix.keySet()) {
      if(!matrix.get(cell))
        return;

      int neighbours = amountOfNeighbours(new Cell(cell));
      if (neighbours < 2)
        setCell(cell, false);
      if (neighbours > 3)
        setCell(cell, false);
    }

    for (String cell : emptyNeighbours) {
      int neighbours = amountOfNeighbours(new Cell(cell));
      if (neighbours == 3) {
        setCell(cell, true);
      }
    }
    emptyNeighbours = new HashSet<>();
  }

  public int amountOfNeighbours(Cell cell) {
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

  private String rightOf(Cell cell) {
    return (cell.getX() + 1 ) + "x" + cell.getY();
  }

  private String leftOf(Cell cell) {
    return (cell.getX() - 1) + "x" + cell.getY();
  }

  private String above(Cell cell) {
    return cell.getX() + "x" + cell.getY() + 1;
  }

  private String below(Cell cell) {
    return cell.getX() + "x" + (cell.getY() - 1);
  }

  public Boolean getCell(Cell cell) {
    return getCell(cell.toString());
  }

  public Boolean getCell(String cell) {
    return matrix.get(cell) != null;
  }

  public Boolean setCell(Cell cell, boolean value) {
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

  public void print() {
    int maxX = 0;
    int maxY = 0;

    Set<String> keys = matrix.keySet();
    for (String cell : matrix.keySet()) {
      int x = Math.abs(getX(cell));
      if (x > maxX)
        maxX = x;
      int y = Math.abs(getY(cell));
      if (y > maxY)
        maxY = y;
    }

    for (int y = -20; y < 20; y++) {
      for (int x = -20; x < 20; x++) {
        if (y == -20 || y == 19) {
          System.out.print("-");
          continue;
        }
        if (x == -20 || x == 19) {
          System.out.print("|");
          continue;
        }
        if (keys.contains(x + "-" + y)) {
          System.out.print("x");
          continue;
        }
        System.out.print(" ");

      }
      System.out.println();
    }
  }
}
