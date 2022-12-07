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
    assertEquals(folder.name(), "/");
  }
}
