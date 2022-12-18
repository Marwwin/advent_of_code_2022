package com.marwwin.adventofcode2022.day18;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.marwwin.aoc.AoC;
import com.marwwin.aoc.Coord;
import com.marwwin.aoc.Directions;

public class CubeSpace {

  HashMap<Integer, List<Cube>> space = new HashMap<>();
  HashMap<Coord, Cube> cubes = new HashMap<>();
  int xNegativeEdge = 0;
  int xPositiveEdge = 0;
  int yNegativeEdge = 0;
  int yPositiveEdge = 0;
  int zNegativeEdge = 0;
  int zPositiveEdge = 0;

  public CubeSpace(List<String> input) {
    for (String string : input) {
      Cube cube = new Cube(string);
      List<Cube> list = space.get(cube.score());
      if (list == null) {
        space.put(cube.score(), new ArrayList<Cube>());
      }
      space.get(cube.score()).add(cube);
      cubes.put(cube.getPosition(), cube);
    }
    for (Coord cube : cubes.keySet()) {
      if (cube.getX() < xNegativeEdge)
        xNegativeEdge = cube.getX();
      if (cube.getX() > xPositiveEdge)
        xPositiveEdge = cube.getX();
      if (cube.getY() < yNegativeEdge)
        yNegativeEdge = cube.getY();
      if (cube.getY() > yPositiveEdge)
        yPositiveEdge = cube.getY();
      if (cube.getZ() < zNegativeEdge)
        zNegativeEdge = cube.getZ();
      if (cube.getZ() > zPositiveEdge)
        zPositiveEdge = cube.getZ();
    }
  }

  public void connectCubes() {
    for (List<Cube> cubes : space.values()) {
      List<Cube> lower = space.get(cubes.get(0).score() - 1);
      List<Cube> higher = space.get(cubes.get(0).score() + 1);
      cubes.forEach(cube -> {
        if (lower != null) {
          lower.forEach(cubeWithLowerScore -> {
            Directions connected = cube.isConnected(cubeWithLowerScore);
            if (connected != null) {
              cube.connect(connected);
            }
          });
        }
        if (higher != null) {
          higher.forEach(cubeWithHigherScore -> {
            Directions connected = cube.isConnected(cubeWithHigherScore);
            if (connected != null) {
              cube.connect(connected);
            }
          });
        }
      });
    }
  }

  public int count() {
    int result = 0;
    for (int y = yNegativeEdge; y <= yPositiveEdge; y++)
      for (int z = zNegativeEdge; z <= zPositiveEdge; z++)
        for (int x = xNegativeEdge; x <= xPositiveEdge; x++) {
          Cube cube = cubes.get(new Coord(x, y, z));
          System.out.println(cube + " " + new Coord(x, y, z));
          result += cube == null ? 0 : 1;
        }

    System.out.println(cubes.size());
    return result;
  }

  public int getTrappedCubes() {
    int trapped = 0;
    for (List<Cube> cubes : space.values()) {
      for (Cube cube : cubes) {
        if (cube.exposedSides() == 6) {
          trapped += 1;
        }
      }
    }
    return trapped;
  }

  public HashMap<Integer, List<Cube>> getSpace() {
    return space;
  }

  public HashMap<Coord, Cube> getCubes() {
    return cubes;
  }

  public int getxNegativeEdge() {
    return xNegativeEdge;
  }

  public int getxPositiveEdge() {
    return xPositiveEdge;
  }

  public int getyNegativeEdge() {
    return yNegativeEdge;
  }

  public int getyPositiveEdge() {
    return yPositiveEdge;
  }

  public int getzNegativeEdge() {
    return zNegativeEdge;
  }

  public int getzPositiveEdge() {
    return zPositiveEdge;
  }
}
