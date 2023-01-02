package com.marwwin.adventofcode2022.day20;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import com.marwwin.aoc.AoC;

public class CircularIntegerListTest {
  @Test
  public void shouldCreateCircularListOfNodes() {
    CircularIntegerList list = new CircularIntegerList(AoC.getInputAsString("day20", true));
    CircularNode root = list.getRoot();
    System.out.println(root);
    assertEquals(1, root.getValue());
    assertEquals(true, root.hasRightChild());
    assertEquals(2, root.getRightChild().getValue());
    assertEquals(-3, root.getRightChild().getRightChild().getValue());
    assertEquals(4, root.getLeftChild().getValue());

  }

  @Test
  public void shouldTestSize() {
    CircularIntegerList list = new CircularIntegerList(AoC.getInputAsString("day20", true));
    assertEquals(7, list.size());
  }

  @Test
  public void shouldReturnNthElement() {
    CircularIntegerList list = new CircularIntegerList(AoC.getInputAsString("day20", true));
    assertEquals(1, list.at(0).getValue());
    assertEquals(2, list.at(1).getValue());
    assertEquals(-3, list.at(2).getValue());
    assertEquals(3, list.at(3).getValue());
    assertEquals(-2, list.at(4).getValue());
    assertEquals(0, list.at(5).getValue());
    assertEquals(4, list.at(6).getValue());
    assertEquals(1, list.at(list.size()).getValue());
  }

  @Test
  public void shouldMoveRootOneStep() {
    CircularIntegerList list = new CircularIntegerList(AoC.getInputAsString("day20", true));
    assertEquals(1, list.getRoot().getValue());
    assertEquals(4, list.getRoot().getLeftChild().getValue());
    assertEquals(2, list.getRoot().getRightChild().getValue());

    list.move(1, 1);
    assertEquals(2, list.getRoot().getValue());
    assertEquals(4, list.getRoot().getLeftChild().getValue());
    assertEquals(1, list.getRoot().getRightChild().getValue());
  }

  @Test
  public void shouldMoveRootTwoStep() {
    CircularIntegerList list = new CircularIntegerList(AoC.getInputAsString("day20", true));
    list.move(1, 2);
    assertEquals(2, list.at(0).getValue());
    assertEquals(-3, list.at(1).getValue());
    assertEquals(1, list.at(2).getValue());
    assertEquals(3, list.at(3).getValue());
  }

  @Test
  public void shouldMoveRootToLast() {
    CircularIntegerList list = new CircularIntegerList(AoC.getInputAsString("day20", true));
    list.move(1,6 );
    System.out.println(list.getList());
    assertEquals(Arrays.asList(2,-3,3,-2,0,4,1), list.getList());
  }

  @Test
  public void shouldMoveRootBackToStartingPosition() {
    CircularIntegerList list = new CircularIntegerList(AoC.getInputAsString("day20", true));
    list.move(1,7 );
    System.out.println(list.getList());
    assertEquals(Arrays.asList(1,2,-3,3,-2,0,4), list.getList());
  }

  @Test
  public void shouldMoveRootOneStepGivenListSizePlus1() {
    CircularIntegerList list = new CircularIntegerList(AoC.getInputAsString("day20", true));
    list.move(1,8 );
    System.out.println(list.getList());
    assertEquals(Arrays.asList(2,1,-3,3,-2,0,4), list.getList());
  }

  @Test
  public void shouldMoveRootBackwards() {
    CircularIntegerList list = new CircularIntegerList(AoC.getInputAsString("day20", true));
    list.move(1, -1);
    assertEquals(Arrays.asList(2,-3,3,-2,0,4,1), list.getList());
  }

  @Test
  public void shouldMoveRootBackwards2Steps() {
    CircularIntegerList list = new CircularIntegerList(AoC.getInputAsString("day20", true));
    list.move(1, -2);
    assertEquals(Arrays.asList(2,-3,3,-2,0,1,4), list.getList());
  }

  @Test
  public void shouldMoveRootBackwardsToStartingPosition() {
    CircularIntegerList list = new CircularIntegerList(AoC.getInputAsString("day20", true));
    list.move(1, -7);
    assertEquals(Arrays.asList(1,2,-3,3,-2,0,4), list.getList());
  }

  @Test
  public void shouldMoveRootBackwardsOnePastStartingPosition() {
    CircularIntegerList list = new CircularIntegerList(AoC.getInputAsString("day20", true));
    list.move(1, -8);
    assertEquals(Arrays.asList(2,-3,3,-2,0,4,1), list.getList());
  }

  @Test
  public void shouldMoveNodeBackwards() {
    CircularIntegerList list = new CircularIntegerList(AoC.getInputAsString("day20", true));
    list.move(-3, -1);
    assertEquals(Arrays.asList(1,-3,2,3,-2,0,4), list.getList());
  }

  @Test
  public void shouldMoveNodeSomeStepsBackwardSoItBecomesRoot() {
    CircularIntegerList list = new CircularIntegerList(AoC.getInputAsString("day20", true));
    list.move(-3, -2);
    assertEquals(Arrays.asList(-3,1,2,3,-2,0,4), list.getList());
  }

  @Test
  public void shouldMoveNodeSomeStepsBackwardSoItBecomesLast() {
    CircularIntegerList list = new CircularIntegerList(AoC.getInputAsString("day20", true));
    list.move(-3, -3);
    assertEquals(Arrays.asList(1,2,3,-2,0,4,-3), list.getList());
  }

  @Test
  public void shouldMoveNodeSomeStepsBackwardSoItBecomesSecondToLast() {
    CircularIntegerList list = new CircularIntegerList(AoC.getInputAsString("day20", true));
    list.move(-3, -4);
    assertEquals(Arrays.asList(1,2,3,-2,0,-3,4), list.getList());
  }

  @Test
  public void shouldReturnNodeWithValue() {
    CircularIntegerList list = new CircularIntegerList(AoC.getInputAsString("day20", true));
    assertEquals(1, list.find(1, list.getRoot()).getValue());
    assertEquals(2, list.find(2, list.getRoot()).getValue());
    assertEquals(3, list.find(3, list.getRoot()).getValue());
  }

  @Test
  public void shouldPlay2Rounds() {
    CircularIntegerList list = new CircularIntegerList(AoC.getInputAsString("day20", true));
    list.play(2);
    assertEquals(1, list.at(0).getValue());
    assertEquals(-3, list.at(1).getValue());
    assertEquals(2, list.at(2).getValue());
    assertEquals(3, list.at(3).getValue());
  }

  @Test
  public void shouldRemoveNode() {
    CircularIntegerList list = new CircularIntegerList(AoC.getInputAsString("day20", true));
    assertEquals(2, list.getRoot().getRightChild().getValue());
    assertEquals(4, list.getRoot().getLeftChild().getValue());

    list.remove(2, true);
    assertEquals(-3, list.getRoot().getRightChild().getValue());
    assertEquals(4, list.getRoot().getLeftChild().getValue());
  }

  @Test
  public void ifRootIsRemovedNeighbourShouldBecomeRoot() {
    CircularIntegerList list = new CircularIntegerList(AoC.getInputAsString("day20", true));
    assertEquals(1, list.getRoot().getValue());
    list.remove(1, true);
    assertEquals(2, list.getRoot().getValue());
  }

  @Test
  public void shouldAddAtI() {
    CircularIntegerList list = new CircularIntegerList(AoC.getInputAsString("day20", true));
    CircularNode node = list.remove(1, true);
    assertEquals(-3, list.getRoot().getRightChild().getValue());
    list.add(node, 1);
    assertEquals(1, list.getRoot().getRightChild().getValue());
    assertEquals(-3, list.getRoot().getRightChild().getRightChild().getValue());
  }

  @Test
  public void shouldGetIndexOfValue() {
    CircularIntegerList list = new CircularIntegerList(AoC.getInputAsString("day20", true));
    assertEquals(0, list.getIndex(1));
    assertEquals(1, list.getIndex(2));
    assertEquals(2, list.getIndex(-3));
  }

  @Test
  public void shouldMix1() {
    CircularIntegerList list = new CircularIntegerList(AoC.getInputAsString("day20", true));
    assertArrayEquals(new Object[] { 1, 2, -3, 3, -2, 0, 4 }, list.getList().toArray());
    list.play(1);
    assertArrayEquals(new Object[] { 2, 1, -3, 3, -2, 0, 4 }, list.getList().toArray());
  }

  @Test
  public void shouldMix2() {
    CircularIntegerList list = new CircularIntegerList(AoC.getInputAsString("day20", true));
    list.play(2);
    assertArrayEquals(new Object[] { 1, -3, 2, 3, -2, 0, 4 }, list.getList().toArray());
  }

  @Test
  public void shouldMix3() {
    CircularIntegerList list = new CircularIntegerList(AoC.getInputAsString("day20", true));
    list.play(3);
    System.out.println(list.getList());
    assertArrayEquals(new Object[] { 1, 2, 3, -2, -3, 0, 4 }, list.getList().toArray());
  }

  @Test
  public void shouldMix4() {
    CircularIntegerList list = new CircularIntegerList(AoC.getInputAsString("day20", true));
    list.play(4);
    assertArrayEquals(new Object[] { 1, 2, -2, -3, 0, 3, 4 }, list.getList().toArray());
  }

  @Test
  public void shouldMix5() {
    CircularIntegerList list = new CircularIntegerList(AoC.getInputAsString("day20", true));
    list.play(5);
    assertArrayEquals(new Object[] { 1, 2, -3, 0, 3, 4, -2 }, list.getList().toArray());
  }

  @Test
  public void shouldMix6() {
    CircularIntegerList list = new CircularIntegerList(AoC.getInputAsString("day20", true));
    list.play(6);
    assertArrayEquals(new Object[] { 1, 2, -3, 0, 3, 4, -2 }, list.getList().toArray());
  }

  @Test
  public void shouldMix7() {
    CircularIntegerList list = new CircularIntegerList(AoC.getInputAsString("day20", true));
    list.play(7);
    System.out.println(list.getList());
    assertArrayEquals(new Object[] { 1, 2, -3, 4, 0, 3, -2 }, list.getList().toArray());
  }
}
