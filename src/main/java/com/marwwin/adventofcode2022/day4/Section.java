package com.marwwin.adventofcode2022.day4;

public class Section {
  private int start;
  private int end;

  public Section(String section){
    String[] temp = section.split("-");
    start = Integer.parseInt(temp[0]);
    end = Integer.parseInt(temp[1]);
  }

  public int end() {
    return end;
  }
  public int start() {
    return start;
  }
}
