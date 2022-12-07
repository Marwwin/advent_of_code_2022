package com.marwwin.adventofcode2022.day7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Folder {
  private String name;
  private int size;
  private List<Folder> subFolders = new ArrayList<>();
  private List<File> files = new ArrayList<>();

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
    return subFolders.stream()
        .filter(f -> f.name().equals(target))
        .collect(Collectors.toList()).get(0);
  }

  public void addSubFolder(Folder folder) {
    subFolders.add(folder);
  }

  public void addFile(File file) {
    files.add(file);
  }

  public List<Folder> subFolders() {
    return subFolders;
  }

  public List<File> files() {
    return files;
  }

  public void print() {
    System.out.println(name);
    for (File file : files) {
      file.print();
    }
    for (Folder folder : subFolders) {
      folder.print();
    }
  }

  public HashMap<String, Integer> calculateSize() {
    int sizeOfFiles = files
        .stream()
        .map(f -> f.size())
        .reduce(0, (a, b) -> a + b);
    int sizeOfSubFolderFiles = 0;
    int part1 = 0;
    int part2 = Integer.MAX_VALUE;
    for (Folder folder : subFolders) {
      HashMap<String, Integer> s = folder.calculateSize();
      sizeOfSubFolderFiles += s.get("result");
      part1 += s.get("part1");
      if (s.get("part2") < part2)
       part2 = s.get("part2");
    }
    int result = sizeOfFiles + sizeOfSubFolderFiles;
    if (result <= 100000)
      part1 += result;

    // Output for part2 just get the smallest number larger than 3313415
    if (result >= 3313415 && result < part2) {
      System.out.println(result);
      part2 = result;
    }

    HashMap<String, Integer> output = new HashMap<>();
    output.put("result", result);
    output.put("part1", part1);
    output.put("part2", part2);

    return output;
  }
}
