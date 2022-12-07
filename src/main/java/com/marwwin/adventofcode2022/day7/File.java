package com.marwwin.adventofcode2022.day7;

public class File {
  private int size;
  private String name;

  public int size() {
    return size;
  }

  public String name() {
    return name;
  }

  public File(Command command){
    this.size = command.size();
    this.name = command.destination();
  }
}
