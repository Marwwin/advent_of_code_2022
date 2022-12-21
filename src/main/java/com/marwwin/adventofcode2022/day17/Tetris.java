package com.marwwin.adventofcode2022.day17;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

import com.marwwin.adventofcode2022.day14.Unit;
import com.marwwin.aoc.Coord;
import com.marwwin.aoc.Stack;

public class Tetris {

  private int width;
  private int leftWall;
  private int rightWall;
  private int height = 4;
  private String pattern = "";
  private int numberOfBlocks = 0;
  private Stack<TetrisBlock> stack = new Stack<>();
  private HashMap<Coord, Unit> rocks = new HashMap<>();
  private char[] jetPattern;

  public Tetris(int width) {
    this.width = width;
    leftWall = -(width - 1) / 2;
    rightWall = (width - 1) / 2;
    for (int x = leftWall; x <= rightWall; x++) {
      rocks.put(new Coord(x, 0), Unit.ROCK);
    }
  }

  public Tetris(int width, String string) {
    this.width = width;
    leftWall = -(width - 1) / 2;
    rightWall = (width - 1) / 2;
    jetPattern = string.toCharArray();
    for (int x = leftWall; x <= rightWall; x++) {
      rocks.put(new Coord(x, 0), Unit.ROCK);
    }
  }

  public void play(int rounds) {
    System.out.println(rounds);
    int patternIndex = 0;
    for (int i = 0; i < rounds; i++) {
      TetrisBlock block = spawnNext();
      drop(block, patternIndex);
    }
  }

  public void drop(TetrisBlock block) {
    while (block.isNotAtRest()) {
      move(' ');
    }
  }

  public void drop(TetrisBlock block, int patternIndex) {
    while (block.isNotAtRest()) {
      char next = pattern.charAt(patternIndex++  % pattern.length());
      System.out.println(next);
      move(next);
    }
  }

  public TetrisBlock spawnNext() {
    TetrisShape nextShape = TetrisShape.values()[numberOfBlocks % TetrisShape.values().length];
    return spawn(nextShape);
  }

  public TetrisBlock spawn(TetrisShape shape) {
    numberOfBlocks += 1;
    TetrisBlock block = new TetrisBlock(shape, height);
    stack.push(block);
    return block;
  }

  public void move(char jet) {
    currentBlock().move(jet, rightWall, leftWall);
    if (hasBlockReachedRock()){
      turnCurrentBlockToRock();
    }
  }

  private boolean hasBlockReachedRock() {
    for (Coord brick : currentBlock().getBricks()) {
      if (isRockBelow(brick)) {
        return true;
      }
    }
    return false;
  }

  private boolean isRockBelow(Coord brick) {
    return at(brick.getX(), brick.getY() -1) == Unit.ROCK;
  }

  private void turnCurrentBlockToRock() {
    height += currentBlock().getHeight() + 1;
    TetrisBlock block = stack.pop();
    block.setAtRest();
    addRocks(block);
  }

  private void addRocks(TetrisBlock block) {
    for (Coord brick : block.getBricks()) {
      rocks.put(brick, Unit.ROCK);
    }
  }

  public Unit at(int x, int y) {
    Unit unit = rocks.get(new Coord(x, y));
    return unit == Unit.ROCK ? unit : Unit.AIR;
  }

  public void print() {
    System.out.println();
    for (int y = height + 1; y >= 0; y--) {
      for (int x = leftWall; x <= rightWall; x++) {

        boolean isBrick = false;

        if (currentBlock() != null) {
          for (Coord brick : currentBlock().getBricks()) {
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

  public boolean isInsideArea(Coord Coord) {
    return (Coord.getX() >= leftWall && Coord.getX() <= rightWall);
  }

  public void setPattern(List<String> inputAsString) {
    pattern = inputAsString.get(0);
  }
  public void setPattern(String inputAsString) {
    pattern = inputAsString;
  }

  public String getPattern() {
    return pattern;
  }

  public int heightOfRocks() {
    Optional<Integer> maybeInt = rocks.keySet().stream().map(rock -> rock.getY()).max(Integer::compare);
    return maybeInt.isPresent() ? maybeInt.get() : null;
  }

}
