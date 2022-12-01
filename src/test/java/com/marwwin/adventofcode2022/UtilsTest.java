package com.marwwin.adventofcode2022;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import com.marwwin.adventofcode2022.aoc.Utils;

import java.util.Arrays;
import java.util.List;

public class UtilsTest {
  @Test
  public void shouldReturnTestDataAsString() {
    List<String> result = Arrays.asList(new String[] { "1000", "2000", "3000", "", "4000", "", "5000", "6000", "",
        "7000", "8000", "9000", "", "10000" });
    assertEquals("", Utils.getInputAsString("day1", true), result);
  }

  @Test
  public void shouldReturnTestDataAsInteger() {
    List<Integer> result = Arrays
        .asList(new Integer[] { 1000, 2000, 3000, 0, 4000, 0, 5000, 6000, 0, 7000, 8000, 9000, 0, 10000 });
    assertEquals("", Utils.getInputAsInteger("day1", true), result);
  }
}
