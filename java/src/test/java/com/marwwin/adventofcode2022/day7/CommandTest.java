package com.marwwin.adventofcode2022.day7;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CommandTest {
  @Test
  public void shouldCreateAChangeDirectoryCommand(){
    Command cmd = new Command("$ cd /");
    assertEquals(cmd.type(),Commands.CHANGE_DIRECTORY);
    assertEquals(cmd.destination(), "/");
  }
  @Test
  public void shouldCreateAListCommand(){
    Command cmd = new Command("$ ls");
    assertEquals(cmd.type(),Commands.LIST);
    assertEquals(cmd.destination(), null);
  }
  @Test
  public void shouldCreateADirectoryCommand(){
    Command cmd = new Command("dir a");
    assertEquals(cmd.type(),Commands.DIRECTORY);
    assertEquals(cmd.destination(), "a");
  }
  @Test
  public void shouldCreateAFileCommand(){
    Command cmd = new Command("1234 a.txt");
    assertEquals(cmd.type(),Commands.FILE);
    assertEquals(cmd.destination(), "a.txt");
    assertEquals(cmd.size(), 1234);

  }
}
