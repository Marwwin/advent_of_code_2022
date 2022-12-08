package com.marwwin.adventofcode2022.day8;

import java.util.Arrays;
import java.util.List;

import com.marwwin.aoc.Matrix;

public class ElfForest extends Matrix {

  public ElfForest(List<String> input) {
    super(input);
  }

  public int solvePart1() {
    int result = 0;
    for (int column = 0; column < height(); column++) {
      for (int row = 0; row < width(); row++) {
        if (isTreeVisible(column, row))
          result++;
      }
    }
    return result;
  }

  public boolean isTreeVisible(int columnIndex, int rowIndex) {
    if (isEdge(columnIndex, rowIndex))
      return true;

    if (isTreeVisibleOnLine(rowIndex, getColumn(columnIndex)) ||
        isTreeVisibleOnLine(columnIndex, getRow(rowIndex)))
      return true;
    return false;
  }

  public boolean isTreeVisibleOnLine(int index, int[] array) {
    int value = array[index];
    if (isHighestTree(value, Arrays.copyOfRange(array, 0, index)) ||
        isHighestTree(value, Arrays.copyOfRange(array, index + 1, array.length)))
      return true;
    return false;
  }

  public boolean isHighestTree(int target, int[] input) {
    return Arrays.stream(input).allMatch(e -> e < target);
  }

  public int solvePart2() {
    int result = 0;
    for (int column = 0; column < height(); column++) {
      for (int row = 0; row < width(); row++) {
        int score = getScenicScore(column, row);
        if (score > result)
          result = score;
      }
    }
    return result;
  }

  public int getScenicScore(int columnIndex, int rowIndex) {
    int result = 1;
    result *= lookUpOrLeft(rowIndex, getColumn(columnIndex));
    result *= lookUpOrLeft(columnIndex, getRow(rowIndex));
    result *= lookDownOrRight(rowIndex, getColumn(columnIndex));
    result *= lookDownOrRight(columnIndex, getRow(rowIndex));
    return result;
  }

  public int lookUpOrLeft(int rowIndex, int[] column) {
    int count = 0;
    int value = column[rowIndex];
    for (int i = rowIndex - 1; i >= 0; i--) {
      count++;
      if (column[i] >= value) {
        break;
      }
    }
    return count;
  }

  public int lookDownOrRight(int columnIndex, int[] row) {
    int count = 0;
    int value = row[columnIndex];
    for (int i = columnIndex + 1; i < row.length; i++) {
      count++;
      if (row[i] >= value) {
        break;
      }
    }
    return count;
  }

}
