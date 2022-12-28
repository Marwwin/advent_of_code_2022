package com.marwwin.adventofcode2022.day20;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CircularNodeTest {
  @Test
  public void testGetRightChild() {
    CircularNode node = new CircularNode(0);
    node.setRightChild(new CircularNode(1));
    assertEquals(1, node.getRightChild().getValue());
  }

  @Test
  public void testGetLeftChild() {
    CircularNode node = new CircularNode(0);
    node.setLeftChild(new CircularNode(-1));
    assertEquals(-1, node.getLeftChild().getValue());
  }

  @Test
  public void testGetValue() {
    CircularNode node = new CircularNode(42);
    assertEquals(42, node.getValue());
  }
}
