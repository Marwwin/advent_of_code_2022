package com.marwwin.adventofcode2022.day7;

public class FileSystem {
  Folder root;
  Folder current;

  public Folder getCurrent() {
    return current;
  }

  public FileSystem() {
    root = new Folder("/");
    current = root;
  }

  public Folder root() {
    return root;
  }

  public void parse(Command input) {
    if (input.type() == Commands.CHANGE_DIRECTORY) {
      current = root.find(input.destination());
    }
    if (input.type() == Commands.LIST) {

    }
    if (input.type() == Commands.DIRECTORY) {
      current.addSubFolder(new Folder(input.destination()));
    }
    if (input.type() == Commands.FILE) {
      current.addFile(new File(input));
    }
  }

}
