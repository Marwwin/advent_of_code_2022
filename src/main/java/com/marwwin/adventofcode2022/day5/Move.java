package com.marwwin.adventofcode2022.day5;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Move {
  private int amount;
  private int from;
  private int to;

  public Move(String string) {
    Pattern pattern = Pattern.compile("\\d+");
    Matcher match = pattern.matcher(string);
    match.find();
    amount = Integer.parseInt(match.group());
    match.find();
    from = Integer.parseInt(match.group());
    match.find();
    to = Integer.parseInt(match.group());
  }

  public int amount() {
    return amount;
  }

  public int from() {
    return from - 1;
  }

  public int to() {
    return to - 1;
  }
}
