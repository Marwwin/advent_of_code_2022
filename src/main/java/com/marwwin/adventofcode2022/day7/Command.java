package com.marwwin.adventofcode2022.day7;

public class Command {

  private Commands type;
  private String destination;
  private int size;

  public Command(String input) {
   // if (input.charAt(0) == '$') {
      parseCommand(input);
   // }
  }

  private void parseCommand(String input) {
    String[] command = input.split(" ");

    if (command[0].equals("dir")){
      type = Commands.DIRECTORY;
      destination = command[1];
      return;
    }
    if (command[0].equals("$") && command[1].equals("cd")) {
      type = Commands.CHANGE_DIRECTORY;
      destination = command[2];
      return;
    }
    if (command[0].equals("$") && command[1].equals("ls")) {
      type = Commands.LIST;
      return;
    }
    type = Commands.FILE;
    size = Integer.parseInt(command[0]);
    destination = command[1];
  }

  public Commands type() {
    return type;
  }

  public String destination() {
    return destination;
  }

  public int size() {
    return size;
  }
}
