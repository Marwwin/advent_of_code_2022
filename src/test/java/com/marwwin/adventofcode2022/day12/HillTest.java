package com.marwwin.adventofcode2022.day12;

import static org.junit.Assert.assertEquals;

import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.Test;

import com.marwwin.aoc.AoC;

public class HillTest {
  @Test
  public void shouldFindStartNode() {
    Hill hill = new Hill(AoC.getInputAsString("day12", true));
    HillNode start = hill.find('S');
    assertEquals(start.getX(), 0);
    assertEquals(start.getY(), 0);
  }

  @Test
  public void shouldFindEndNode() {
    Hill hill = new Hill(AoC.getInputAsString("day12", true));
    HillNode end = hill.find('E');
    assertEquals(end.getX(), 5);
    assertEquals(end.getY(), 2);
  }

  @Test
  public void startAndEndShouldBeFoundWhenCreatingNewHill() {
    Hill hill = new Hill(AoC.getInputAsString("day12", true));

    HillNode start = new HillNode(0, 0);
    assertEquals(hill.getStart().getX(), start.getX());
    assertEquals(hill.getStart().getY(), start.getY());

    HillNode end = new HillNode(5, 2);
    assertEquals(hill.getEnd().getX(), end.getX());
    assertEquals(hill.getEnd().getY(), end.getY());

  }

  @Test
  public void shouldGetHeuristicDistanceBetween2Points() {
    Hill hill = new Hill(AoC.getInputAsString("day12", true));
    double distance = hill.getDistance(hill.getStart(), hill.getEnd());
    assertEquals(distance, 5.385164807, 0.01d);

    double distance2 = hill.getDistance(new HillNode(3, 3), new HillNode(2, 2));
    assertEquals(distance2, Math.sqrt(2), 0.01d);
  }

  @Test
  public void priorityQueueShouldExist() {
    Hill hill = new Hill(AoC.getInputAsString("day12", true));
    Queue<Integer> queue = hill.getDiscovered();
  }

  @Test
  public void shouldBeAbleToAddToQueue() {
    Hill hill = new Hill(AoC.getInputAsString("day12", true));
    hill.addToDiscovered(new HillNode(0, 0));
  }
}
