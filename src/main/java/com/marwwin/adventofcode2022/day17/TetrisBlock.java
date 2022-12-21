package com.marwwin.adventofcode2022.day17;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.marwwin.aoc.Coord;

public class TetrisBlock {

  private List<Coord> bricks = new ArrayList<>();
  private Coord position = new Coord(0, 0);


  private TetrisShape shape;
  private int highestY;
  private int rightMost;
  private int leftMost = -1;
  private boolean isAtRest = false;

  public TetrisBlock(TetrisShape shape) {
    this.shape = shape;
    createBlock(shape);
  }

  public TetrisBlock(TetrisShape shape, int spawningPoint) {
    this.shape = shape;
    createBlock(shape);
    this.position.setY(spawningPoint + 1);
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

  public List<Coord> getBricks() {
    return bricks.stream()
        .map(brick -> new Coord(
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
    moveDown();
    if (position.getX() + rightMost < rightWall)
      if (jet == '>')
        moveRight();
    if ((position.getX() + leftMost) > leftWall) {
      if (jet == '<')
        moveLeft();
    }
  }

  private void createBox() {
    bricks.add(new Coord(0, 0));
    bricks.add(new Coord(-1, 0));
    bricks.add(new Coord(-1, 1));
    bricks.add(new Coord(0, 1));
    rightMost = 0;
    highestY = 1;
  }

  private void createVertical() {
    bricks.add(new Coord(-1, 0));
    bricks.add(new Coord(-1, 1));
    bricks.add(new Coord(-1, 2));
    bricks.add(new Coord(-1, 3));
    highestY = 3;
    rightMost = -1;
  }

  private void createHorisontal() {
    bricks.add(new Coord(0, 0));
    bricks.add(new Coord(-1, 0));
    bricks.add(new Coord(1, 0));
    bricks.add(new Coord(2, 0));
    highestY = 0;
    rightMost = 2;
  }

  private void createStar() {
    bricks.add(new Coord(0, 0));
    bricks.add(new Coord(0, 1));
    bricks.add(new Coord(-1, 1));
    bricks.add(new Coord(1, 1));
    bricks.add(new Coord(0, 2));
    highestY = 2;
    rightMost = 1;
  }

  private void createWedge() {
    bricks.add(new Coord(0, 0));
    bricks.add(new Coord(-1, 0));
    bricks.add(new Coord(1, 0));
    bricks.add(new Coord(1, 1));
    bricks.add(new Coord(1, 2));
    rightMost = 1;
    highestY = 2;
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

  public void moveUp() {
    position.setY(position.getY() + 1);
  
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

  public boolean isNotAtRest() {
    return !isAtRest;
  }

  public void setAtRest() {
    isAtRest = true;
  }

  @Override
  public String toString() {
    return "Block [Coord=" + position + ", shape=" + shape + ", rightMost=" + rightMost + ", leftMost="
        + leftMost + ", isAtRest=" + isAtRest + "]";
  }
  public Coord getPosition() {
    return position;
  }
  public Object getLeftBoundary() {
    return leftMost + position.getX();
  }
  public int getRightBoundary() {
    return rightMost + position.getX();
  }


}
