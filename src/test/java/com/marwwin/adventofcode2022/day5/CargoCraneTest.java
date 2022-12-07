package com.marwwin.adventofcode2022.day5;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CargoCraneTest {
  @Test
  public void shouldCreateACargoCrateWithNStacks() {
    List<String> input = new ArrayList<>();
    input.add("    [D]    ");
    input.add("[N] [C]    ");
    input.add("[Z] [M] [P]");
    input.add(" 1   2   3 ");
    CargoCrane crane = new CargoCrane(input);
    assertEquals(3, crane.amountOfStacks());
  }
  @Test
  public void shouldaddInputStacks(){
    List<String> input = new ArrayList<>();
    input.add(" 1   2   3 ");
    CargoCrane crane = new CargoCrane(input);
    crane.populateStackFromRow("[Z] [M] [P]");
    assertEquals(crane.getTopItems(), "ZMP");
  }
  @Test
  public void shouldCreateACargoCrateAndPopulateStacks() {
    List<String> input = new ArrayList<>();
    input.add("    [D]    ");
    input.add("[N] [C]    ");
    input.add("[Z] [M] [P]");
    input.add(" 1   2   3 ");
    CargoCrane crane = new CargoCrane(input);
    assertEquals(3, crane.amountOfStacks());
    assertEquals(crane.getTopItems(), "NDP");
  }
  @Test
  public void shouldMoveCargoFromOneStackToOther() {
    List<String> input = new ArrayList<>();
    input.add("    [D]    ");
    input.add("[N] [C]    ");
    input.add("[Z] [M] [P]");
    input.add(" 1   2   3 ");
    CargoCrane crane = new CargoCrane(input);
    crane.move("move 1 from 2 to 1");
    assertEquals(crane.getTopItems(), "DCP");
  }
}
