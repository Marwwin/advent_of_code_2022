package com.marwwin.adventofcode2022.day17;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.marwwin.adventofcode2022.aoc.Position;

public class TetrisBlock {

  private List<Position> bricks = new ArrayList<>();
  private Position position = new Position(0, 0);
  private TetrisShape shape;
  private int highestY;
  private int rightMost;
  private int leftMost;
  private boolean isAtRest = false;

  @Override
  public String toString() {
    return "Block [position=" + position + ", shape=" + shape + ", rightMost=" + rightMost + ", leftMost="
        + leftMost + ", isAtRest=" + isAtRest + "]";
  }

  public int getRightBoundary() {
    System.out.println("right b " + shape + " " + rightMost + " " + position.getX());
    return rightMost + position.getX();
  }

  public TetrisBlock(TetrisShape shape) {
    this.shape = shape;
    createBlock(shape);
    // leftMost = bricks.stream().map(brick ->
    // brick.getX()).min(Integer::compare).get();
    // rightMost = bricks.stream().map(brick ->
    // brick.getX()).max(Integer::compare).get();
  }

  public TetrisBlock(TetrisShape shape, int spawningPoint) {
    this.shape = shape;
    createBlock(shape);

    this.position.setY(spawningPoint + 1);
    // leftMost = bricks.stream().map(brick ->
    // brick.getX()).min(Integer::compare).get();
    // rightMost = bricks.stream().map(brick ->
    // brick.getX()).max(Integer::compare).get();
  }

  private void createBlock(TetrisShape shape) {
    if (shape == TetrisShape.BOX)
      createBox();
    if (shape == TetrisShape.VERTICAL)
      createVertical();
    if (shape == TetrisShape.HORISONTAL)
      createHorisontal();
    if (shape == TetrisShape.STAR)
      createStar();
    if (shape == TetrisShape.WEDGE)
      createWedge();
  }

  public List<Position> getBricks() {
    return bricks.stream()
        .map(brick -> new Position(
            brick.getX() + position.getX(),
            brick.getY() + position.getY()))
        .collect(Collectors.toList());
  }

  public void move(char ch) {
    moveDown();
    if (ch == '>')
      moveRight();
    if (ch == '<')
      moveLeft();
  }

  public void move(char jet, int rightWall, int leftWall) {
    System.out.println("moving " + jet + " " + position.getX() + " " + leftMost);
    moveDown();
    if (position.getX() + rightMost < rightWall)
      if (jet == '>')
        moveRight();
    if ((position.getX() + leftMost) > leftWall) {
      System.out.println("left"+ " "+ (position.getX() - leftMost) + " "+ leftWall);
      if (jet == '<')
        moveLeft();
    }
  }

  public int[] getPosition() {
    return position.getPosition();
  }

  public void moveDown() {
    position.setY(position.getY() - 1);
  }

  public void moveLeft() {
    position.setX(position.getX() - 1);
  }

  public void moveRight() {
    position.setX(position.getX() + 1);

  }

  public TetrisShape getShape() {
    return shape;
  }

  public int highestY() {
    return position.getY() + highestY;
  }

  public int getHeight() {
    return highestY;
  }

  private void createBox() {
    bricks.add(new Position(0, 0));
    bricks.add(new Position(-1, 0));
    bricks.add(new Position(-1, 1));
    bricks.add(new Position(0, 1));
    rightMost = 0;
    leftMost = -1;
    highestY = 1;
  }

  private void createVertical() {
    bricks.add(new Position(-1, 0));
    bricks.add(new Position(-1, 1));
    bricks.add(new Position(-1, 2));
    bricks.add(new Position(-1, 3));
    highestY = 3;
    leftMost = -1;
    rightMost = -1;
  }

  private void createHorisontal() {
    bricks.add(new Position(0, 0));
    bricks.add(new Position(-1, 0));
    bricks.add(new Position(1, 0));
    bricks.add(new Position(2, 0));
    highestY = 0;
    leftMost = -1;
    rightMost = 2;
  }

  private void createStar() {
    bricks.add(new Position(0, 0));
    bricks.add(new Position(0, 1));
    bricks.add(new Position(-1, 1));
    bricks.add(new Position(1, 1));
    bricks.add(new Position(0, 2));
    highestY = 2;
    leftMost = -1;
    rightMost = 1;
  }

  private void createWedge() {
    bricks.add(new Position(0, 0));
    bricks.add(new Position(-1, 0));
    bricks.add(new Position(1, 0));
    bricks.add(new Position(1, 1));
    bricks.add(new Position(1, 2));
    rightMost = 1;
    leftMost = -1;
    highestY = 2;
  }

  public boolean isNotAtRest() {
    return !isAtRest;
  }

  public void setAtRest() {
    isAtRest = true;
  }

}
