package com.marwwin.adventofcode2022.day12;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.marwwin.aoc.AoC;

public class Hill2Test {
  @Test
  public void shouldCreateRootNode() {
    Hill2 hill = new Hill2(AoC.getInputAsString("day12", true));
    HillNode root = hill.getRoot();
    assertEquals(root.getX(), 0);
    assertEquals(root.getY(), 0);
    assertEquals(root.getValue(), 'S' - '0');
  }

  @Test
  public void shouldCreateNeighours() {
    Hill2 hill = new Hill2(AoC.getInputAsString("day12", true));
    HillNode root = hill.getRoot();
    root = hill.createNeighours(root);
    assertEquals(root.right().getValue(), 'a' - '0');
    assertEquals(root.down().getValue(), 'a' - '0');
  }


  @Test
  public void shouldCreateRoo() {
    Hill2 hill = new Hill2(AoC.getInputAsString("day12", true));
    HillNode root = hill.getRoot();
    assertEquals(root.getX(), 0);
    assertEquals(root.getY(), 0);
  }
}
