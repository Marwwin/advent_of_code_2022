package com.marwwin.adventofcode2022.day14;

import com.marwwin.adventofcode2022.aoc.Position;

public class Rock extends Position {

  public Rock(String string) {
    super(string);
  }

  @Override
  public String toString() {
    return getX()+" "+getY();
  }
    
}
