package com.marwwin.adventofcode2022.day7;

import java.util.HashMap;

import com.marwwin.aoc.Stack;

public class FileSystem {
  Folder root;
  Stack<Folder> stack = new Stack<Folder>();

  public FileSystem() {
    root = new Folder("/");
  }

  public void parse(Command input) {

    if (input.type() == Commands.CHANGE_DIRECTORY) {

      if (stack.isEmpty()) {
        stack.push(root);
        return;
      }

      if (input.destination().equals("..")) {
        stack.pop();
      } else
        stack.push(current().find(input.destination()));
    }
    if (input.type() == Commands.LIST) {
    }
    if (input.type() == Commands.DIRECTORY) {
      current().addSubFolder(new Folder(input.destination()));
    }
    if (input.type() == Commands.FILE) {
      current().addFile(new File(input));
    }
  }

  public Folder current() {
    return stack.peek();
  }

  public Folder root() {
    return root;
  }

  public void print() {
    root.print();
  }

  public HashMap<String,Integer> calculateSize() {
    return root.calculateSize();
  }

}
