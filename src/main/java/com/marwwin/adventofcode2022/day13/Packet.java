package com.marwwin.adventofcode2022.day13;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Packet {
  List<Packet> children;
  List<Integer> numbers;
  boolean isNumber;

  public Packet(String input) {
  //  this.packet = parseInput(input);
  }

  private List<List<Integer>> parseInput(String input) {
    // System.out.println(input);
    // jackson
    // Pattern pattern = Pattern.compile("\\[[\\d,]+]");
    // Matcher matcher = pattern.matcher(input);
    // System.out.println(matcher.matches());
    //List<List<Integer>> result = new ArrayList<List<Integer>>();
    // boolean startingBracketFound = false;
    // for (String ch : input.split("")) {
    // if ( ch.equals("]") || ch.equals(","))
    // continue;
    // if (ch.equals("[")){
    // if (!startingBracketFound){
    // startingBracketFound = true;
    // continue;
    // }
    // result.add(new PacketData()
    // }
    // result.add(new PacketData(Integer.valueOf(ch)));
    // }
    return null;
  }

//  public PacketData getIndex(int i) {
//    return packet.get(i);
//  }

 // public List<PacketData> getPacket() {
 //   return packet;
 // }

}
