package com.marwwin.adventofcode2022.day18;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.marwwin.aoc.AoC;
import com.marwwin.aoc.Coord;

public class CubeSpaceTest {
  @Test
  public void shouldCreateCubeSpace() {
    CubeSpace space = new CubeSpace(AoC.getInputAsString("day18", false));
  }

  @Test
  public void shouldMarkCubesAsConnected() {
    CubeSpace space = new CubeSpace(AoC.getInputAsString("day18", false));
    space.connectCubes();
    int s = 0;
    for (List<Cube> list : space.space.values()) {
      for (Cube cube : list) {
        s += cube.exposedSides();
      }
    }
    System.out.println(s);
  }

  @Test
  public void shouldGetTrapped() {

    CubeSpace space = new CubeSpace(AoC.getInputAsString("day18", true));
    space.connectCubes();
    int s = 0;
    for (List<Cube> list : space.space.values()) {
      for (Cube cube : list) {
        System.out.println(cube);
        s += cube.exposedSides();
      }
    }
    System.out.println(s);
    System.out.println(space.getTrappedCubes());
  }

  @Test
  public void shouldGetCubes() {
    CubeSpace space = new CubeSpace(AoC.getInputAsString("day18", true));
    assertEquals(space.getCubes().size(), 13);
  }

  @Test
  public void shouldGetCubesRealData() {
    CubeSpace space = new CubeSpace(AoC.getInputAsString("day18", false));
    assertEquals(space.getCubes().size(), 2890);
  }

  @Test
  public void shouldSaveDimensionOfSpace() {
    String[] coords = new String[] { "1,2,3", "-3,-2,-1", "0,0,0" };
    CubeSpace space = new CubeSpace(Arrays.asList(coords));
    assertEquals(space.getxNegativeEdge(), -3);
    assertEquals(space.getxPositiveEdge(), 1);
    assertEquals(space.getyNegativeEdge(), -2);
    assertEquals(space.getyPositiveEdge(), 2);
    assertEquals(space.getzNegativeEdge(), -1);
    assertEquals(space.getzPositiveEdge(), 3);

  }

}
