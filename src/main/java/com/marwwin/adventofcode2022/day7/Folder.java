package com.marwwin.adventofcode2022.day7;

import java.util.ArrayList;
import java.util.List;

public class Folder {
  private String name;
  private int size;
  private List<Folder> subFolders = new ArrayList<>();
  private List<File> files = new ArrayList<>();

  public List<Folder> subFolders() {
    return subFolders;
  }

  public List<File> files() {
    return files;
  }

  public Folder(String name) {
    this.name = name;
  }

  public String name() {
    return name;
  }

  public int size() {
    return size;
  }

  public Folder find(String target) {
    if (name == target)
      return this;
    return this;
  }
  public void addSubFolder(Folder folder){
    subFolders.add(folder);
  }
  public void addFile(File file){
    files.add(file);
  }
}
