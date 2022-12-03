package com.marwwin.adventofcode2022;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.marwwin.adventofcode2022.aoc.BinaryTree.BinaryTree;
import com.marwwin.adventofcode2022.aoc.BinaryTree.Node;

public class BinaryTreeTest {

  @Test
  public void shouldCreateTree() {
    Node root = new Node();
    BinaryTree.insert(5, root);
    assertEquals(root.value(), 5);
  }

  @Test
  public void shouldInsertALowerNumberToTheLeft() {
    Node root = new Node();

    BinaryTree.insert(5, root);
    assertEquals(root.value(), 5);
    BinaryTree.insert(3, root);
    assertEquals(root.left().value(), 3);
  }
  @Test
  public void shouldInsertAHigherNumberToTheRight() {
    Node root = new Node();

    BinaryTree.insert(5, root);
    assertEquals(root.value(), 5);
    BinaryTree.insert(6, root);
    assertEquals(root.right().value(), 6);
  }
  @Test
  public void shouldInsertANumberCorrectly() {
    Node root = new Node();

    BinaryTree.insert(5, root);
    assertEquals(root.value(), 5);
    BinaryTree.insert(9, root);
    assertEquals(root.right().value(), 9);
    BinaryTree.insert(7, root);
    assertEquals(root.right().left().value(), 7);
  }

  @Test
  public void shouldReturnTrueIfValueExists(){
    Node root = new Node();
    BinaryTree.insert(5, root);
    BinaryTree.insert(2, root);
    BinaryTree.insert(42, root);
    BinaryTree.insert(8, root);
    BinaryTree.insert(4, root);
    assertTrue(BinaryTree.hasValue(5, root));
    assertTrue(BinaryTree.hasValue(2, root));


  }
}
