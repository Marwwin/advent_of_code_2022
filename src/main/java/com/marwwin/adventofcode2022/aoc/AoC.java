package com.marwwin.adventofcode2022.aoc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AoC {

  public static List<Integer> getInputAsInteger(String day, boolean useTestData) {
    List<String> result = getInputAsString(day, useTestData);
    return inputToInt(result);
  }

  public static List<String> getInputAsString(String day, boolean useTestData) {
    List<String> result = new ArrayList<String>();
    try {
      String input = useTestData ? "/train.txt" : "/input.txt";
      File file = new File(getPath(day) + input);
      FileReader fr = new FileReader(file);
      BufferedReader br = new BufferedReader(fr);
      String line;
      while ((line = br.readLine()) != null) {
        result.add(line);
      }
      fr.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return result;
  }

  private static List<Integer> inputToInt(List<String> input) {
    return input.stream()
        .map(e -> e.chars().sum() == 0 ? 0 : Integer.parseInt(e))
        .collect(Collectors.toList());
  }

  public static String getPath(String day) throws IOException {
    String currentPath = new java.io.File(".").getCanonicalPath();
    String daysPath = "/src/main/java/com/marwwin/adventofcode2022/";
    String path = currentPath + daysPath + day;
    return path;
  }

  public static String[] splitStringInTwo(String string) {
    int mid = string.length() / 2;
    return new String[] { string.substring(0, mid), string.substring(mid, string.length()) };
  }

  public static Set<Character> stringToSetOfChars(String string) {
    return string.chars()
        .mapToObj(e -> (char) e).collect(Collectors.toSet());
  }

}
