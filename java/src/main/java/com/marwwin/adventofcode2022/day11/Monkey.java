package com.marwwin.adventofcode2022.day11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Monkey {

  private int id;
  private ArrayList<Long> items;
  private int divisor;
  private Operation operation;
  private int ifTrue;
  private int ifFalse;
  private int inspectedItems;

  public Monkey(int id) {
    this.items = new ArrayList<>();
    this.id = id;
    this.inspectedItems = 0;
  }

  public Monkey(String string) {
    int id = Integer.parseInt(string.trim().split(" ")[1].split(":")[0]);
    this.items = new ArrayList<>();
    this.id = id;
    this.inspectedItems = 0;
  }

  public void inspectItems(int worryLevelDivider) {
    ArrayList<Long> newItems = new ArrayList<>();
    this.items.stream()
        .map(item -> {
          if (worryLevelDivider > 10)
            return (long) (operation.calculate(item) % worryLevelDivider);
          return (long) (operation.calculate(item) / worryLevelDivider);
        })
        .forEach(item -> newItems.add(item));
    this.inspectedItems += newItems.size();
    this.items = newItems;
  }

  public HashMap<String, Long> throwItem(Long item) {
    HashMap<String, Long> result = new HashMap<>();
    result.put("item", item);
    if (test(item)) {
      result.put("id", (long) ifTrue);
    } else {
      result.put("id", (long) ifFalse);
    }
    return result;
  }

  public List<Long> getItems() {
    return items;
  }

  public void clearItems() {
    this.items = new ArrayList<>();
  }

  public void addItem(Long item) {
    items.add(item);
  }

  public boolean test(Long item) {
    return item % divisor == 0;
  }

  public void setTest(String string) {
    this.divisor = Integer.parseInt(string.trim().split("by ")[1]);
  }

  public void setOperation(String string) {
    this.operation = new Operation(string.trim().split("= ")[1]);
  }

  public void setIfTrue(String string) {
    this.ifTrue = Integer.parseInt(string.trim().split(" ")[5]);
  }

  public void setIfFalse(String string) {
    this.ifFalse = Integer.parseInt(string.trim().split(" ")[5]);
  }

  public int getId() {
    return id;
  }

  public void addItems(String line) {
    String[] items = line.split(": ")[1].split(",");
    for (String item : items) {
      addItem(Long.parseLong(item.trim()));
    }
  }

  public int getInspectedItems() {
    return this.inspectedItems;
  }

  public int getDivisor() {
    return divisor;
  }

}
