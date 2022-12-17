package com.marwwin.adventofcode2022.day16;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ValveTest {

  @Test
  public void shouldCreateAValve() {
    Valve valve = new Valve("Valve AA has flow rate=0; tunnels lead to valves DD, II, BB");
    assertEquals(valve.getName(), "AA");
    assertEquals(valve.getFlowRate(), 0);
    assertArrayEquals(valve.getChildrenNames(), new String[]{"DD","II","BB"});

  }

  @Test
  public void shouldCreateAnotherValve() {
    Valve valve = new Valve("Valve AA has flow rate=3; tunnels lead to valves GG");
    assertEquals(valve.getName(), "AA");
    assertEquals(valve.getFlowRate(), 3);
    assertArrayEquals(valve.getChildrenNames(), new String[]{"GG"});
  }
}
