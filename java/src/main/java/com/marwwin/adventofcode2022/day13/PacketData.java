package com.marwwin.adventofcode2022.day13;

import java.util.List;

public class PacketData {
  public int number;

  public Packet packet;

  public PacketData(Integer number) {
    this.number = number;
  }

  public boolean isPacket() {
    return packet != null;
  }

  public int getNumber() {
    return number;
  }

  public Packet getPacket() {
    return packet;
  }

}
