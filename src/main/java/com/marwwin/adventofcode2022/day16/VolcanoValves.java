package com.marwwin.adventofcode2022.day16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class VolcanoValves {

  private Valve start = null;

  private HashMap<String,Valve> valves = new HashMap<>();

  public VolcanoValves(List<String> input) {
    for (String string : input) {
      System.out.println( "+ "+
          string);
      Valve newValve = new Valve(string);
      valves.put(newValve.getName(), newValve);
    }
    start = valves.get("AA");
    setChildren();
  }

  private void setChildren() {
    for (Valve valve : valves.values()) {
        valve.setChildren(valves);
    }
  }

  public Valve getStart() {
    return start;
  }
}
