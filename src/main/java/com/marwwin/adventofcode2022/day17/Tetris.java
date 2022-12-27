package com.marwwin.adventofcode2022.day17;

import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.marwwin.adventofcode2022.day14.Unit;
import com.marwwin.aoc.Coord;
import com.marwwin.aoc.Stack;

public class Tetris {

  private int width;
  private int leftWall;
  private int rightWall;
  private int height = 3;
  private String pattern = "";
  private int numberOfBlocks = 0;
  private Stack<TetrisBlock> stack = new Stack<>();
  private HashMap<Coord, Unit> rocks = new HashMap<>();
  private int patternIndex = 0;

  public void getPatternIndex() {
    System.out.println(patternIndex);
    System.out.println(patternIndex % pattern.length());

  }

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
    setPattern(string);
    for (int x = leftWall; x <= rightWall; x++) {
      rocks.put(new Coord(x, 0), Unit.ROCK);
    }
  }

  public boolean isRepeat(int i) {
    int h = height - 3;
    if (h % 2 != 0) {
      return false;
    }

    for (int y = 1; y <= (h / 2); y++) {
      BitSet row = scanRow(y);
      BitSet rowDuplicate = scanRow((h / 2) + y);
      if (y > 1) {
        System.out.println("row " + y + " h / 2 " + (h / 2) + " h " + h + " blocks " + numberOfBlocks);
        System.out.println(" " + row + " " + rowDuplicate + " " + row.equals(rowDuplicate));
        showBitRow(h, y);
        System.out.println(" " + scanRow(y + 2) + " " + scanRow((h / 2) + y + 2) + " "
            + scanRow(y + 1).equals(scanRow((h / 2) + y + 2)));
        System.out.println(" " + scanRow(y + 3) + " " + scanRow((h / 2) + y + 3) + " "
            + scanRow(y + 1).equals(scanRow((h / 3) + y + 3)));
        //
      }
      if (!row.equals(rowDuplicate)) {
        // System.out.println("not "+row + " " + rowDuplicate);

        return false;
      }
      if (row.equals(rowDuplicate)) {
        // System.out.println(row + " " + rowDuplicate + " " +
        // row.equals(rowDuplicate));
      }
    }
    // System.out.println("true "+h + " "+ numberOfBlocks);
    return true;
  }

  private void showBitRow(int heightOfRocks, int y) {
    System.out.println(" row:" + scanRow(y + 1) + " " + scanRow((heightOfRocks / 2) + y + 1) + " "
        + scanRow(y + 1).equals(scanRow((heightOfRocks / 2) + y + 1)));
  }

  private BitSet scanRow(int y) {
    BitSet row = new BitSet();
    for (int x = leftWall; x <= rightWall; x++) {
      if (rocks.get(new Coord(x, y)) == Unit.ROCK) {
        row.set(x + 3);
      }
    }
    return row;
  }

  public void play(int rounds) {
    for (int i = 0; i < rounds; i++) {
      if (i == 174) {
        System.out.println(i + " " + height + " " + numberOfBlocks);
      }
      // if (i > 100000) {
      if (isRepeat(i))
        System.out.println(rounds + " equals");
      // }
      TetrisBlock block = spawnNext();
      drop(block);

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

  public void drop(TetrisBlock block) {
    while (block.isNotAtRest()) {
      // print();
      move(nextMove());
    }
  }

  public void move(char jet) {
    if (currentBlock().getRightBoundary() < rightWall)
      if (jet == '>')
        currentBlock().moveRight();
    if (currentBlock().getLeftBoundary() > leftWall) {
      if (jet == '<')
        currentBlock().moveLeft();
    }
    if (hasBlockReachedRock(jet)) {
      turnCurrentBlockToRock();
      return;
    }
    currentBlock().moveDown();
  }

  private char nextMove() {
    if (pattern == "") {
      return ' ';
    }
    char jet = pattern.charAt(patternIndex++ % pattern.length());
    if (isRockToSide(jet))
      return ' ';
    return jet;
  }

  private boolean isRockToSide(char jet) {
    for (Coord brick : currentBlock().getBricks()) {
      if (jet == '>' && at(brick.getX() + 1, brick.getY()) == Unit.ROCK)
        return true;
      if (jet == '<' && at(brick.getX() - 1, brick.getY()) == Unit.ROCK)
        return true;
    }
    return false;
  }

  private boolean hasBlockReachedRock(char jet) {
    for (Coord brick : currentBlock().getBricks()) {
      if (isRockBelow(brick)) {
        return true;
      }
    }
    return false;
  }

  private boolean isRockBelow(Coord brick) {
    return at(brick.getX(), brick.getY() - 1) == Unit.ROCK;
  }

  private void turnCurrentBlockToRock() {
    TetrisBlock block = stack.pop();
    block.setAtRest();
    addRocks(block);
    int currentBlockHeight = block.highestY();
    height = currentBlockHeight + 3 > height ? currentBlockHeight + 3 : height;
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

  public int getHeight() {
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

  public long heightOfRocks() {

    Optional<Long> maybeInt = rocks.keySet().stream().map(rock -> (long) rock.getY()).max(Long::compare);
    return maybeInt.isPresent() ? maybeInt.get() : null;
  }

}
