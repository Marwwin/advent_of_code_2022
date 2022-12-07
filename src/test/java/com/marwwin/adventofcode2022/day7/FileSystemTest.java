package com.marwwin.adventofcode2022.day7;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FileSystemTest {
  @Test
  public void shouldCreateAFileSystem() {
    FileSystem fs = new FileSystem();
    Command root = new Command("$ cd /");
    fs.parse(root);
    assertEquals(fs.current().name(), "/");
  }

  @Test
  public void shouldCreateFoldersWithls() {
    FileSystem fs = new FileSystem();
    fs.parse(new Command("$ cd /"));
    fs.parse(new Command("$ ls"));
    fs.parse(new Command("dir a"));
    assertEquals(fs.current().name(), "/");
    assertEquals(fs.current().subFolders().get(0).name(), "a");
  }
  @Test
  public void shouldCreateFilesInCurrentFolder() {
    FileSystem fs = new FileSystem();
    fs.parse(new Command("$ cd /"));
    fs.parse(new Command("123 a.txt"));
    assertEquals(fs.current().files().get(0).name(), "a.txt");
  }

  @Test
  public void shouldCreateAFolderAndSetCurrent() {
    FileSystem fs = new FileSystem();
    fs.parse(new Command("$ cd /"));
    fs.parse(new Command("dir a"));
    fs.parse(new Command("$ cd a"));
    assertEquals(fs.current().name(), "a");
  }
  @Test
  public void shouldCreateANestedFolderAndSetCurrent() {
    FileSystem fs = new FileSystem();
    fs.parse(new Command("$ cd /"));

    assertEquals(fs.current().name(), "/");

    fs.parse(new Command("dir a"));
    fs.parse(new Command("$ cd a"));
    assertEquals(fs.current().name(), "a");
    fs.parse(new Command("dir b"));
    fs.parse(new Command("$ cd b"));
    assertEquals(fs.current().name(), "b");
  }

  @Test
  public void shouldMoveUpOnFolder() {
    FileSystem fs = new FileSystem();
    fs.parse(new Command("$ cd /"));

    assertEquals(fs.current().name(), "/");

    fs.parse(new Command("dir a"));
    fs.parse(new Command("$ cd a"));
    assertEquals(fs.current().name(), "a");
    fs.parse(new Command("$ cd .."));
    assertEquals(fs.current().name(), "/");
  }
}
