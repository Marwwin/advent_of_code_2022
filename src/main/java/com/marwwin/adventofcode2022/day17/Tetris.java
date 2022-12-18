package com.marwwin.adventofcode2022.day17;

import java.util.HashMap;
import java.util.List;

import com.marwwin.adventofcode2022.aoc.Position;
import com.marwwin.adventofcode2022.day14.Unit;
import com.marwwin.aoc.Stack;

public class Tetris {

  private int width;
  private int leftWall;
  private int rightWall;
  private int height = 4;
  private String pattern;
  private int numberOfBlocks = 0;
  private Stack<TetrisBlock> stack = new Stack<>();
  private HashMap<String, Unit> rocks = new HashMap<>();
  private char[] jetPattern;

  public Tetris(int width) {
    this.width = width;
    leftWall = -(width - 1) / 2;
    rightWall = (width - 1) / 2;
  }

  public Tetris(int width, String string) {
    this.width = width;
    leftWall = -(width - 1) / 2;
    rightWall = (width - 1) / 2;
    jetPattern = string.toCharArray();
    System.out.println(string.charAt(0));
    System.out.println(jetPattern[0]);

    for (int x = leftWall; x <= rightWall; x++)
      rocks.put(x + "x0", Unit.ROCK);
  }

  public void play(int rounds) {
    int patternIndex= 0;
    System.out.println(rounds);
    for (int i = 0; i < rounds; i++) {
      TetrisBlock block = spawnNext();
      while (block.isNotAtRest()) {
        move(jetPattern[patternIndex++]);
        print();
      }
    }
  }

  public TetrisBlock spawnNext() {
    System.out.println(numberOfBlocks % TetrisShape.values().length);
    TetrisShape nextShape = TetrisShape.values()[numberOfBlocks % TetrisShape.values().length];
    numberOfBlocks += 1;
    System.out.println(nextShape);
    TetrisBlock block = new TetrisBlock(nextShape, height);
    stack.push(block);
    return block;
  }

  public void move(char jet) {
    currentBlock().move(jet, rightWall, leftWall);
    for (Position brick : currentBlock().getBricks()) {
      if (at(brick.getX(), brick.getY() - 1) == Unit.ROCK) {
        System.out.println("there be rock below");
        height += currentBlock().getHeight()+1;
        TetrisBlock block = stack.pop();
        block.setAtRest();
        addRocks(block);
        break;
      }
    }
  }

  private void addRocks(TetrisBlock block) {
    for (Position brick : block.getBricks()) {
      rocks.put(brick.toString(), Unit.ROCK);
    }
  }

  public Unit at(int x, int y) {
    Unit unit = rocks.get(x + "x" + y);
    return unit == Unit.ROCK ? unit : Unit.AIR;
  }

  public void print() {
    System.out.println();
    for (int y = height + 1; y >= 0; y--) {
      for (int x = leftWall; x <= rightWall; x++) {

        boolean isBrick = false;

        if (currentBlock() != null) {
          for (Position brick : currentBlock().getBricks()) {
            if (x == brick.getX() && y == brick.getY()) {
              System.out.print("@");
              isBrick = true;
            }
            continue;
          }
        }
        if (isBrick)
          continue;
        if (at(x, y) == Unit.ROCK) {
          System.out.print("#");
          continue;
        }
        System.out.print(".");
      }
      System.out.println();
    }
  }

  public TetrisBlock currentBlock() {
    return stack.top();
  }

  public int getWidth() {
    return width;
  }

  public int getSpawningPoint() {
    return height;
  }

  public boolean isInsideArea(Position position) {
    return (position.getX() >= leftWall && position.getX() <= rightWall);
  }

  public void setPattern(List<String> inputAsString) {
    pattern = inputAsString.get(0);
  }

  public String getPattern() {
    return pattern;
  }
}
