package com.marwwin.adventofcode2022.day9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Knot {

  // x = 0
  // y = 1
  List<Integer> position = new ArrayList<Integer>();
  Set<List<Integer>> visited = new HashSet<>();
  List<Integer> previous = new ArrayList<Integer>();

  public Knot() {
    position.add(0);
    position.add(0);
    savePosition();
  }

  public List<Integer> position() {
    return position;
  }

  public int x() {
    return position.get(0);
  }

  public void setX(int n) {
    position.set(0, n);
  }

  public int y() {
    return position.get(1);
  }

  public void setY(int n) {
    position.set(1, n);
  }

  public void up() {
    position.set(1, position.get(1) + 1);
  }

  public void down() {
    position.set(1, position.get(1) - 1);
  }

  public void right() {
    position.set(0, position.get(0) + 1);
  }

  public void left() {
    position.set(0, position.get(0) - 1);
  }

  public void upLeft() {
    up();
    left();
  }

  public void upRight() {
    up();
    right();
  }

  public void downRight() {
    down();
    right();
  }

  public void downLeft() {
    down();
    left();
  }

  public void savePosition() {
    visited.add(position);
  }

  public Integer visited() {
    return visited.size();
  }

  @Override
  public String toString() {
    return "Knot " + position + " ";
  }

  public void savePrevious() {
    previous = new ArrayList<>(position);
  }

  public List<Integer> getPrevious() {
    return previous;
  }

  public void setKnot(List<Integer> position) {
    this.position = position;
  }

}
