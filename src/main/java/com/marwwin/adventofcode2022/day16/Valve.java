package com.marwwin.adventofcode2022.day16;

import java.util.List;

public class Valve {
  int flowRate;
  int index;
  String name;
  List<Valve> children;
  String[] childrenNames;

  public Valve(String string) {
    String[] strings = string.split(";");
    parseNameAndFlowRate(strings[0]);
    parseChildren(strings[1]);
  }

  private void parseChildren(String string) {
    childrenNames = string.substring(24).split(", ");
  }

  private void parseNameAndFlowRate(String string) {
    name = string.substring(6, 8);
    flowRate = Integer.parseInt(string.split("=")[1]);
  }

  public String[] getChildrenNames() {
    return childrenNames;
  }

  public int getFlowRate() {
    return flowRate;
  }

  public void setFlowRate(int flowRate) {
    this.flowRate = flowRate;
  }

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
