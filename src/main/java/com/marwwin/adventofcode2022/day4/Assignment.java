package com.marwwin.adventofcode2022.day4;

public class Assignment {
  private Section first;
  private Section second;

  public Assignment(String assignment) {
    String[] temp = assignment.split(",");
    first = new Section(temp[0]);
    second = new Section(temp[1]);
  }

  public Section first() {
    return first;
  }

  public Section second() {
    return second;
  }

  public boolean isOneSectionFullyContainedInTheOther() {
    if (first.start() <= second.start() && first.end() >= second.end())
      return true;
    if (second.start() <= first.start() && second.end() >= first.end())
      return true;

    return false;
  }

  public boolean hasOverlap() {
    if (first.end() < second.start() || first.start() > second.end())
      return false;

    return true;
  }
}
