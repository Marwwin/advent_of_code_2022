package com.marwwin.adventofcode2022.day6;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PacketFinderTest {

  @Test
  public void shouldAddCharsToMemory(){
    PacketFinder finder = new PacketFinder();
    finder.setTargetLength(3);
    finder.add('f');
    assertEquals(finder.size(), 1);
    finder.add('f');
    assertEquals(finder.size(), 2);
    finder.add('e');
    assertEquals(finder.size(), 3);
  }
  @Test
  public void shouldReturnTrueWhenFull(){
    PacketFinder finder = new PacketFinder();
    finder.setTargetLength(3);
    finder.add('f');
    assertEquals(finder.isFound(), false);
    finder.add('d');
    assertEquals(finder.isFound(), false);
    finder.add('e');
    assertEquals(finder.isFound(), true);
  }
  @Test
  public void shouldReturn(){
    PacketFinder finder = new PacketFinder();
    finder.setTargetLength(3);
    finder.add('f');
    assertEquals(finder.isFound(), false);
    finder.add('d');
    assertEquals(finder.isFound(), false);
    finder.add('d');
    assertEquals(finder.isFound(), false);
    finder.add('a');
    assertEquals(finder.isFound(), false);
    finder.add('b');
    assertEquals(finder.isFound(), true);
  }
  @Test
  public void shouldSolve(){
    PacketFinder finder = new PacketFinder();
    assertEquals(finder.solve("bvwbjplbgvbhsrlpgdmjqwftvncz",3), 5);
  }
}
