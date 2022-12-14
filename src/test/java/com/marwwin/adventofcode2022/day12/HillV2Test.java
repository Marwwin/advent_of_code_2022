package com.marwwin.adventofcode2022.day12;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import com.marwwin.aoc.AoC;
import com.marwwin.aoc.BinaryTree.Node;

public class HillV2Test {

  @Test
  public void shouldCreateHill() {
    HillV2 hill = new HillV2();
  }

  @Test
  public void shouldReturnHill() {
    HillV2 hill = new HillV2();
    hill.set(new HillNode(0, 0));
    HillNode node = hill.get(0, 0);
    assertEquals(node.getX(), 0);
    assertEquals(node.getY(), 0);
  }

  @Test
  public void shouldBuildHill() {
    HillV2 hill = new HillV2(AoC.getInputAsString("day12", true));
    HillNode node = hill.get(0, 0);
    assertEquals(node.getX(), 0);
    assertEquals(node.getY(), 0);
    assertEquals(hill.getHeight(), 5);
    assertEquals(hill.getWidth(), 8);
  }

  @Test
  public void shouldSaveStartPositionWhenBuildingHill() {
    HillV2 hill = new HillV2(AoC.getInputAsString("day12", true));
    assertEquals(hill.getStart().getX(), 0);
    assertEquals(hill.getStart().getY(), 0);
  }

  @Test
  public void shouldReturnAccessibleNeighboursForCorner() {
    HillV2 hill = new HillV2(AoC.getInputAsString("day12", true));
    List<HillNode> nodes = hill.getNeighbours(0, 0);
    assertEquals(nodes.size(), 2);
  }
  @Test
  public void shouldReturnAccessibleNeighboursFromAllDirections() {
    HillV2 hill = new HillV2(AoC.getInputAsString("day12", true));
    List<HillNode> nodes = hill.getNeighbours(1, 1);
    assertEquals(nodes.size(), 4);
  }
  @Test
  public void shouldReturnAccessibleNeighboursWhenTooHighElevation() {
    HillV2 hill = new HillV2(AoC.getInputAsString("day12", true));
    List<HillNode> nodes = hill.getNeighbours(2, 2);
    assertEquals(nodes.size(), 3);
  }

  @Test
  public void shouldScanTheNearest() {
    HillV2 hill = new HillV2(AoC.getInputAsString("day12", true));
    HillNode end = hill.findEnd(hill.getStart());
    assertEquals(end.getX(), 5);
    assertEquals(end.getY(), 2);
  }
}
