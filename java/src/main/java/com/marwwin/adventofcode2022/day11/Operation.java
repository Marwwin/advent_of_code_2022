package com.marwwin.adventofcode2022.day11;

public class Operation {
  Integer value;
  String operation;

  public Operation(String operation) {
    String[] ops = operation.split(" ");
    this.operation = ops[1];

    if (ops[2].equals("old"))
      this.value = null;
    else
      this.value = Integer.parseInt(ops[2]);
  }

  public Long calculate(long n) {
    if (operation.equals("+"))
      return n + (value != null ? value : n);
    if (operation.equals("*"))
      return n * (value != null ? value : n);
    return null;
  }

  public int getValue() {
    return value;
  }

  public String getOperation() {
    return operation;
  }

}
