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
    //final int prime = 31;
    //int result = 1;
    //result = prime * result + ((x == null) ? 0 : x.hashCode());
    //result = prime * result + ((y == null) ? 0 : y.hashCode());
    //result = prime * result + ((z == null) ? 0 : z.hashCode());
    //return result;
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
    //if (x == null) {
    //  if (other.x != null)
    //    return false;
    //} else if (!x.equals(other.x))
    //  return false;
    //if (y == null) {
    //  if (other.y != null)
    //    return false;
    //} else if (!y.equals(other.y))
    //  return false;
    //if (z == null) {
    //  if (other.z != null)
    //    return false;
    //} else if (!z.equals(other.z))
    //  return false;
    //return true;
  }

}
