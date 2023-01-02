package com.marwwin.adventofcode2022.day16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Valve {
  private int flowRate;
  private int index;
  private String name;
  private List<Valve> children = new ArrayList<>();
  private List<String> childrenNames = new ArrayList<>();

  public Valve(String string) {
    String[] strings = string.split(";");
    parseNameAndFlowRate(strings[0]);
    parseChildren(strings[1]);
  }

  private void parseChildren(String string) {
    for (String child : string.substring(24).split(", ")) {
      childrenNames.add(child);
    }
  }

  private void parseNameAndFlowRate(String string) {
    name = string.substring(6, 8);
    flowRate = Integer.parseInt(string.split("=")[1]);
  }

  public List<String> getChildrenNames() {
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

  public void setChildren(HashMap<String,Valve> valves) {
      for (String childName : getChildrenNames()) {
        List<Valve> children = recursivelyGetChild(valves.get(childName));
        
        children.forEach(child -> addChild(child));

      }

  }

  private List<Valve> recursivelyGetChild(Valve valve) {
    List<Valve> children =  new ArrayList<Valve>(); 
    if (valve.getFlowRate() == 0){
    //  return valve.getChildren() recursivelyGetChild();
    }
    children.add(valve);
   // return children
  }

  public void addChild(Valve newValve) {
    children.add(newValve);
  }

  public List<Valve> getChildren() {
    return children;
  }

}
