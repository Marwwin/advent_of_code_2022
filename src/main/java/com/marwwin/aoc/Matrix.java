package com.marwwin.aoc;

import java.util.List;

public class Matrix {
  int[][] matrix;

  public Matrix(int width, int length) {
    matrix = new int[width][length];
  }

  public Matrix(List<String> input) {
    int height = input.size();
    int width = input.get(0).length();
    matrix = new int[height][width];
    populateMatrix(input);
  }

  private void populateMatrix(List<String> input) {
    for (int column = 0; column < height(); column++) {
      String currentRow = input.get(column);
      for (int row = 0; row < width(); row++) {
        matrix[column][row] = currentRow.charAt(row) - '0';
      }
    }
  }

  public int valueAt(int column, int row) {
    return matrix[column][row];
  }

  public int[][] getMatrix() {
    return matrix;
  }

  public int width() {
    return matrix.length;
  }

  public int height() {
    return matrix[0].length;
  }

  public int[] getColumn(int i) {
    int[] result = new int[height()];
    for (int column = 0; column < height(); column++) {
      result[column] = matrix[column][i];
    }
    return result;
  }

  public int[] getRow(int i) {
    return matrix[i];
  }

  public boolean isEdge(int columnIndex, int rowIndex) {
    if (columnIndex == 0 || rowIndex == 0)
      return true;
    if (columnIndex == height() - 1 || rowIndex == width() - 1)
      return true;
    return false;
  }
}
