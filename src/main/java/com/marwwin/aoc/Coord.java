package com.marwwin.aoc;

import java.util.Objects;

public class Coord {
  private Integer x = null;
  private Integer y = null;
  private Integer z = null;

  public Coord(int x, int y, int z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public Coord(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public Integer getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public Integer getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public Integer getZ() {
    return z;
  }

  public void setZ(int z) {
    this.z = z;
  }

  @Override
  public String toString() {
    return "Coordinates [x=" + x + ", y=" + y + ", z=" + z + "]";
  }

  @Override
  public int hashCode() {
    return Objects.hash(x,y,z);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;

    Coord other = (Coord) obj;
    return Objects.equals(x,other.getX()) && Objects.equals(y,other.getY()) && Objects.equals(z,other.getZ());
  }

}
