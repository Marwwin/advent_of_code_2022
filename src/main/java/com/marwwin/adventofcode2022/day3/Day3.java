package com.marwwin.adventofcode2022.day3;

import java.util.List;
import java.util.Set;

import com.marwwin.adventofcode2022.aoc.Day;
import com.marwwin.adventofcode2022.aoc.AoC;
import com.marwwin.adventofcode2022.aoc.BinaryTree.BinaryTree;
import com.marwwin.adventofcode2022.aoc.BinaryTree.Node;

public class Day3 extends Day {
  List<String> input;

  public Day3(boolean test) {
    super("Day 3");
    input = AoC.getInputAsString("day3", test);
  }

  @Override
  public int part1() {
    int result = 0;
    for (String rucksack : input) {
      String[] compartments = AoC.splitStringInTwo(rucksack);
      Set<Character> compartment1 = AoC.stringToSetOfChars(compartments[0]);
      compartment1.retainAll(AoC.stringToSetOfChars(compartments[1]));
      result += charToPriority(compartment1.iterator().next());
    }
    return result;
  }

  public int part1BT() {
    int result = 0;
    for (String rucksack : input) {
      Node root = new Node();
      String[] compartments = AoC.splitStringInTwo(rucksack);
      compartments[1].chars().forEach(ch -> BinaryTree.insert(ch, root));
      for (char ch : compartments[0].toCharArray()) {
        if (BinaryTree.hasValue(ch, root)) {
          result += charToPriority(ch);
          break;
        }
      }
    }
    return result;
  }

  private int charToPriority(int e) {
    return e >= 97 ? e - 96 : e - 38;
  }

  @Override
  public int part2() {
    int result = 0;
    int i = 0;
    String[] group = new String[3];
    for (String rucksack : input) {
      group[i] = rucksack;
      i += 1;
      if (i == 3) {
        result += charToPriority(unionOfGroup(group).iterator().next());
        i = 0;
      } 
    }
    return result;
  }

  private Set<Character> unionOfGroup(String[] group) {
    Set<Character> result = AoC.stringToSetOfChars(group[0]);
    result.retainAll(AoC.stringToSetOfChars(group[1]));
    result.retainAll(AoC.stringToSetOfChars(group[2]));
    return result;
  }

  public int part2BT() {
    int result = 0;
    for (int i = 0; i < input.size(); i += 3) {
      String first2String = unionOfStrings(input.get(i), input.get(i+1));
      String badge = unionOfStrings(first2String, input.get(i+2));
      result += charToPriority(badge.toCharArray()[0]);
    }
    return result;
  }

  public String unionOfStrings(String master, String string){
    Node root = new Node();
    String result = "";
    string.chars().forEach(ch -> BinaryTree.insert(ch, root));
    for (char ch : master.toCharArray()) {
      if (BinaryTree.hasValue(ch, root)) {
        result += ch;
      }
    }
    return result;
  }
}
