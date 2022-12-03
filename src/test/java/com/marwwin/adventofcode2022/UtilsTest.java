package com.marwwin.adventofcode2022;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import com.marwwin.adventofcode2022.aoc.AoC;

import java.util.Arrays;
import java.util.List;

public class UtilsTest {
  @Test
  public void shouldReturnTestDataAsString() {
    List<String> result = Arrays.asList(new String[] { "1000", "2000", "3000", "", "4000", "", "5000", "6000", "",
        "7000", "8000", "9000", "", "10000" });
    assertEquals("", AoC.getInputAsString("day1", true), result);
  }

  @Test
  public void shouldReturnTestDataAsInteger() {
    List<Integer> result = Arrays
        .asList(new Integer[] { 1000, 2000, 3000, 0, 4000, 0, 5000, 6000, 0, 7000, 8000, 9000, 0, 10000 });
    assertEquals("", AoC.getInputAsInteger("day1", true), result);
  }

  @Test
  public void shouldSplitString(){
    String[] result = AoC.splitStringInTwo("123456");
    assertEquals(result[0], "123");
    assertEquals(result[1], "456");
  }
  @Test
  public void shouldSplitOddLengthString(){
    String[] result = AoC.splitStringInTwo("1234567");
    assertEquals(result[0], "123");
    assertEquals(result[1], "4567");
  }
  @Test
  public void shouldTestAllChars(){
    String[] result = AoC.splitStringInTwo("1234567");
    assertEquals(result[0], "123");
    assertEquals(result[1], "4567");
  }
}
