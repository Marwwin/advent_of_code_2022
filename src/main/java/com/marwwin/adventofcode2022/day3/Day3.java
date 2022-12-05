package com.marwwin.adventofcode2022.day3;

import java.util.List;
import java.util.Set;

import com.marwwin.adventofcode2022.aoc.Day;
import com.marwwin.adventofcode2022.aoc.AoC;
import com.marwwin.adventofcode2022.aoc.BinaryTree.BinaryTree;

public class Day3 extends Day {
  List<String> input;

  public Day3(boolean test) {
    super("Day 3");
    input = AoC.getInputAsString("day3", test);
  }

  @Override
  public Integer part1() {
    int result = 0;
    for (String rucksack : input) {
      BinaryTree tree = new BinaryTree();
      String[] compartments = AoC.splitStringInTwo(rucksack);
      compartments[1].chars().forEach(ch -> tree.insert(ch));
      for (char ch : compartments[0].toCharArray()) {
        if (tree.search(ch) != null) {
          result += charToPriority(ch);
          break;
        }
      }
    }
    return result;
  }

  @Override
  public Integer part2() {
    int result = 0;
    int i = 0;
    String[] group = new String[3];
    for (String rucksack : input) {
      group[i] = rucksack;
      i += 1;
      if (i == 3) {
        result += charToPriority(intersectionOfGroup(group).iterator().next());
        i = 0;
      }
    }
    return result;
  }

  private int charToPriority(int e) {
    return e >= 97 ? e - 96 : e - 38;
  }

  private Set<Character> intersectionOfGroup(String[] group) {
    Set<Character> result = AoC.stringToSetOfChars(group[0]);
    result.retainAll(AoC.stringToSetOfChars(group[1]));
    result.retainAll(AoC.stringToSetOfChars(group[2]));
    return result;
  }

  public int part1Slower() {
    int result = 0;
    for (String rucksack : input) {
      String[] compartments = AoC.splitStringInTwo(rucksack);
      Set<Character> compartment1 = AoC.stringToSetOfChars(compartments[0]);
      compartment1.retainAll(AoC.stringToSetOfChars(compartments[1]));
      result += charToPriority(compartment1.iterator().next());
    }
    return result;
  }

  public int part2BT() {
    int result = 0;
    for (int i = 0; i < input.size(); i += 3) {
      String first2String = intersectionOfStrings(input.get(i), input.get(i + 1));
      String badge = intersectionOfStrings(first2String, input.get(i + 2));
      result += charToPriority(badge.toCharArray()[0]);
    }
    return result;
  }

  public String intersectionOfStrings(String master, String string) {
    BinaryTree tree = new BinaryTree();
    String result = "";
    string.chars().forEach(ch -> tree.insert(ch));
    for (char ch : master.toCharArray()) {
      if (tree.search(ch) != null) {
        result += ch;
      }
    }
    return result;
  }
}
