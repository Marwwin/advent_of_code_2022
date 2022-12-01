package com.marwwin.adventofcode2022.day1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.marwwin.adventofcode2022.aoc.LeaderBoard;

public class Day1Fast {
  public static LeaderBoard goFast() {
    LeaderBoard leaderBoard = new LeaderBoard(3);

    try {
      String input = "/input.txt";
      File file = new File(getPath("day1") + input);
      FileReader fr = new FileReader(file);
      BufferedReader br = new BufferedReader(fr);
      String line;
      int elf = 0;
      while ((line = br.readLine()) != null) {
        if (line.equals("")) {
          leaderBoard.add(elf);
          elf = 0;
        } else {
          elf += Integer.parseInt(line);
        }
      }
      fr.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return leaderBoard;
  }

  public static String getPath(String day) throws IOException {
    String currentPath = new java.io.File(".").getCanonicalPath();
    String daysPath = "/src/main/java/com/marwwin/adventofcode2022/";
    String path = currentPath + daysPath + day;
    return path;
  }
}
