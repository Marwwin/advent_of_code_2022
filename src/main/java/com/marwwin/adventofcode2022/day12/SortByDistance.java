package com.marwwin.adventofcode2022.day12;

import java.util.Comparator;

class SortByDistance implements Comparator<HillNode> {

  @Override
  public int compare(HillNode o1, HillNode o2) {
    return (int) Math.floor(o1.distance - o2.distance);
  }

}
