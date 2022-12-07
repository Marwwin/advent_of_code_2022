package com.marwwin.adventofcode2022.day7;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FileSystemTest {
  @Test
  public void shouldCreateAFileSystem() {
    FileSystem fs = new FileSystem();
    Command root = new Command("$ cd /");
    fs.parse(root);
    assertEquals(fs.getCurrent().name(), "/");
  }

  @Test
  public void shouldCreateFoldersWithls() {
    FileSystem fs = new FileSystem();
    Command ls = new Command("$ ls");
    fs.parse(ls);
    Command dir = new Command("dir a");
    fs.parse(dir);
    assertEquals(fs.getCurrent().name(), "/");
    assertEquals(fs.getCurrent().subFolders().get(0).name(), "a");
  }
  @Test
  public void shouldCreateFilesInCurrentFolder() {
    FileSystem fs = new FileSystem();
    fs.parse(new Command("$ ls"));
    fs.parse(new Command("123 a.txt"));
    assertEquals(fs.getCurrent().files().get(0).name(), "a.txt");
  }
}
