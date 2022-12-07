package com.marwwin.adventofcode2022;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.marwwin.aoc.BinaryTree.BinaryTree;
import com.marwwin.aoc.BinaryTree.Node;

public class BinaryTreeTest {

  @Test
  public void shouldCreateTree() {
    BinaryTree tree = new BinaryTree();
    tree.insert(5);
    assertEquals(tree.getRoot().value(), 5);
  }

  @Test
  public void shouldInsertALowerNumberToTheLeft() {
    BinaryTree tree = new BinaryTree();
    tree.insert(5);
    assertEquals(tree.getRoot().value(), 5);
    tree.insert(3);
    assertEquals(tree.getRoot().left().value(), 3);
  }
  @Test
  public void shouldInsertAHigherNumberToTheRight() {
    BinaryTree tree = new BinaryTree();
    tree.insert(5);
    assertEquals(tree.getRoot().value(), 5);
    tree.insert(6);
    assertEquals(tree.getRoot().right().value(), 6);
  }
  @Test
  public void shouldInsertANumberCorrectly() {
    BinaryTree tree = new BinaryTree();
    tree.insert(5);
    assertEquals(tree.getRoot().value(), 5);
    tree.insert(9);
    assertEquals(tree.getRoot().right().value(), 9);
    tree.insert(7);
    assertEquals(tree.getRoot().right().left().value(), 7);
  }

  @Test
  public void searchShouldReturnNodeIfValueExists(){
    BinaryTree tree = new BinaryTree();
    tree.insert(5);
    tree.insert(2);
    tree.insert(42);
    tree.insert(8);
    tree.insert(4);
    assertEquals(tree.search(5).value(), 5);
    assertEquals(tree.search(2).value(), 2);
  }
  @Test
  public void shouldDeleteLeafNode(){
    BinaryTree tree = new BinaryTree();
    tree.insert(5);
    tree.insert(3);
    tree.insert(6);

    tree.delete(3);
    tree.delete(6);
    
    Node root = tree.getRoot();
    assertEquals(root.left(), null);
    assertEquals(root.right(), null);
  }
  @Test
  public void shouldDeleteFullNode(){
    BinaryTree tree = new BinaryTree();
    tree.insert(10);
    tree.insert(4);
    tree.insert(8);
    tree.insert(3);
    tree.insert(5);
    tree.insert(9);
    tree.insert(1);

    tree.delete(4);

    Node root = tree.getRoot();
    assertEquals(root.left().value(), 8);
    assertEquals(root.left().left().value(), 5);
    assertEquals(root.left().right().value(), 9);
    assertEquals(root.left().left().left().value(), 3);
  }
  @Test
  public void shouldDeleteLeafNodeWithOneChild(){
    BinaryTree tree = new BinaryTree();
    tree.insert(10);
    tree.insert(4);
    tree.insert(8);
    
    tree.delete(4);

    Node root = tree.getRoot();
    assertEquals(root.left().value(), 8);
  }
}
