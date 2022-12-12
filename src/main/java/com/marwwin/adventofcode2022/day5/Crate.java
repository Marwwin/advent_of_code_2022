package com.marwwin.adventofcode2022.day5;

public class Crate {

  private char content;
  private CrateMoverTask task;
  int index;

  public Crate(char crate, CrateMoverTask task) {
    content = crate;
  }

  public Crate(char crate) {
    content = crate;
  }

  public Crate(String ch) {
    content = ch.charAt(0);
  }

  public Crate(String ch, int i) {
    content = ch.charAt(0);
    index = i;
  }

  public char getContent() {
    return content;
  }

  public int from() {
    return task.from();
  }

  public int destination() {
    return task.to();
  }

  public int amount() {
    return task.amount();
  }

  public void attachTask(CrateMoverTask task) {
    this.task = task;
  }

}
