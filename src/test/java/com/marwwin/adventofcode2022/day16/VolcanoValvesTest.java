package com.marwwin.adventofcode2022.day16;

import static org.junit.Assert.assertEquals;

import java.lang.annotation.Target;

import org.junit.Test;

import com.marwwin.aoc.AoC;

public class VolcanoValvesTest {

   @Test
   public void shouldParseInputs() {
      VolcanoValves volcano = new VolcanoValves(AoC.getInputAsString("day16", true));
      Valve start = volcano.getStart();
      assertEquals(start.getName(), "AA");
      assertEquals(start.getChildren().get(0).getName(), "DD");
      assertEquals(start.getChildren().get(1).getName(), "II");

      assertEquals(start.getChildren().get(2).getName(), "BB");
      assertEquals(start.getChildren().get(2).getChildren().get(0).getName(), "CC");


   }
}
