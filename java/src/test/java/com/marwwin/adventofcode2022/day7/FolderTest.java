package com.marwwin.adventofcode2022.day7;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FolderTest {
  @Test
  public void shouldCreateAFolder() {
    Folder folder = new Folder("/");
    assertEquals(folder.name(), "/");
  }

  @Test
  public void shouldCreateASubFolder() {
    Folder folder = new Folder("/");
    folder.addSubFolder(new Folder("a"));
    assertEquals(folder.subFolders().get(0).name(), "a");
  }
  @Test
  public void shouldCreateAFileInFolder() {
    Folder folder = new Folder("/");
    folder.addFile(new File(new Command("1234 abc.txt")));
    assertEquals(folder.files().get(0).name(), "abc.txt");
    assertEquals(folder.files().get(0).size(), 1234);

  }
}
