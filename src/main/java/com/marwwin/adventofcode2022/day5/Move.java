package com.marwwin.adventofcode2022.day5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Move {
  int amount;
  int from;
  int to;

  public Move(String string) {
    Pattern p = Pattern.compile("\\d+");
    Matcher m = p.matcher(string);
    int i = 0;
    while (m.find()) {
      System.out.println(m.group());
      if (i == 0)
        amount = Integer.parseInt(m.group());
      if (i == 1)
        from = Integer.parseInt(m.group());
      if (i == 2)
        to = Integer.parseInt(m.group());
      i++;
    }
  }

  public int getAmount() {
    return amount;
  }

  public int getFrom() {
    return from - 1;
  }

  public int getTo() {
    return to - 1;
  }
}
