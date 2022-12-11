package com.marwwin.adventofcode2022.day11;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class MonkeyHouse {
  LinkedHashMap<Integer, Monkey> monkies;
  int worryLevelDivisor = 1;

  public MonkeyHouse(List<String> inputAsString) {
    monkies = parseMonkies(inputAsString);
  }

  public void doRound() {
    for (Monkey monkey : monkies.values()) {
      monkey.inspectItems(worryLevelDivisor);
      monkey.getItems().forEach(item -> {
        HashMap<String, Long> thrownItem = monkey.throwItem(item);
        Monkey recievingMonkey = monkies.get(thrownItem.get("id").intValue());
        recievingMonkey.addItem(thrownItem.get("item"));
      });
      monkey.clearItems();
    }
  }

  private LinkedHashMap<Integer, Monkey> parseMonkies(List<String> input) {
    LinkedHashMap<Integer, Monkey> monkies = new LinkedHashMap<>();
    Monkey monkey = new Monkey(0);
    for (String line : input) {
      if (line.contains("Monkey "))
        monkey = new Monkey(line);
      if (line.contains("Starting items: "))
        monkey.addItems(line);
      if (line.contains("Operation: "))
        monkey.setOperation(line);
      if (line.contains("Test: "))
        monkey.setTest(line);
      if (line.contains("If true: "))
        monkey.setIfTrue(line.trim());
      if (line.contains("If false: "))
        monkey.setIfFalse(line.trim());
      if (line.equals(""))
        monkies.put(monkey.getId(), monkey);
    }
    monkies.put(monkey.getId(), monkey);
    return monkies;
  }

  public LinkedHashMap<Integer, Monkey> getMonkies() {
    return monkies;
  }

  public Integer getLCM() {
    return monkies.values()
        .stream()
        .map(monkey -> monkey.getDivisor())
        .reduce(1, (a, b) -> a * b);
  }

  public void setWorryLevelDivisor(int worryLevelDivisor) {
    this.worryLevelDivisor = worryLevelDivisor;
  }

}
