package com.marwwin.adventofcode2022.day8;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Day8Test {
  @Test
  public void shouldReturnTrueForEdges() {
    Day8 day8 = new Day8(true);
    assertEquals(day8.forest.isTreeVisible(0, 0), true);
    assertEquals(day8.forest.isTreeVisible(4, 4), true);
    assertEquals(day8.forest.isTreeVisible(0, 2), true);
    assertEquals(day8.forest.isTreeVisible(4, 2), true);
    assertEquals(day8.forest.isTreeVisible(2, 0), true);
    assertEquals(day8.forest.isTreeVisible(2, 4), true);
  }

  @Test
  public void shouldReturnTrueisTreeVisible() {
    Day8 day8 = new Day8(true);
    assertEquals(day8.forest.isTreeVisible(1, 1), true);
    assertEquals(day8.forest.isTreeVisible(1, 2), true);
    assertEquals(day8.forest.isTreeVisible(1, 3), false);
  }

  @Test
  public void shouldTestIfTargetVisible() {
    Day8 day8 = new Day8(true);
    assertEquals(day8.forest.isTreeVisibleOnLine( 1, new int[] {1,2,3,4}), true);
    assertEquals(day8.forest.isTreeVisibleOnLine( 1, new int[] {4,3,2,1}), true);
    assertEquals(day8.forest.isTreeVisibleOnLine( 1, new int[] {3,2,3}), false);
  }

  @Test
  public void shouldTestisHighestTree() {
    Day8 day8 = new Day8(true);
    assertEquals(day8.forest.isHighestTree(1, new int[] { 1, 2, 3, 4 }), false);
    assertEquals(day8.forest.isHighestTree(5, new int[] { 1, 2, 3, 4 }), true);
  }

  @Test
  public void testDataPart1() {
    Day8 day8 = new Day8(true);
    assertEquals(day8.part1(), 21);
  }

  @Test
  public void realDataPart1() {
    Day8 day8 = new Day8(false);
    assertEquals(day8.part1(), 1801);
  }
  @Test
  public void testPart2() {
    Day8 day8 = new Day8(true);
    assertEquals(day8.part2(), 8);
  }
  @Test
  public void realPart2() {
    Day8 day8 = new Day8(false);
    assertEquals(day8.part2(), 209880);
  }

  @Test
  public void shouldGetScenicScore(){
    Day8 day8 = new Day8(true);
    assertEquals(day8.forest.getScenicScore(2,1),4);
    assertEquals(day8.forest.getScenicScore(2,3),8);

  }
  @Test
  public void shouldTestLookUpOlookUpOrLeft(){
    Day8 day8 = new Day8(true);
    assertEquals(day8.forest.lookUpOrLeft(2, new int[]{1,2,3}),2);
    assertEquals(day8.forest.lookUpOrLeft(2, new int[]{1,2,3,4,5}),2);
    assertEquals(day8.forest.lookUpOrLeft(2, new int[]{3,2,3}),2);
    assertEquals(day8.forest.lookUpOrLeft(2, new int[]{3,3,3}),1);
    assertEquals(day8.forest.lookUpOrLeft(3, new int[]{3,3,4,3}),1);
  }
  @Test
  public void shouldTestLookDownOlookDownOrRight(){
    Day8 day8 = new Day8(true);
    assertEquals(day8.forest.lookDownOrRight(1, new int[]{1,2,3}),1);
    assertEquals(day8.forest.lookDownOrRight(1, new int[]{1,2,2}),1);
    assertEquals(day8.forest.lookDownOrRight(2, new int[]{3,2,3,2,2}),2);
    assertEquals(day8.forest.lookDownOrRight(1, new int[]{3,2,3,2,2}),1);
    assertEquals(day8.forest.lookDownOrRight(2, new int[]{3,2,3,2,2,5}),3);
    assertEquals(day8.forest.lookDownOrRight(1, new int[]{3,5,3,5,3}),2);
  }
}
