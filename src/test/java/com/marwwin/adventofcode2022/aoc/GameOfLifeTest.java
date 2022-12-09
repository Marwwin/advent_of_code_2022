package com.marwwin.adventofcode2022.aoc;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GameOfLifeTest {
  @Test
  public void shouldBeAbleToPlayTheGame(){
    GameOfLife game = new GameOfLife();
    assertEquals(game.play(), true);
  }
  @Test
  public void newGameShouldContainAStateOfTheGame(){
    GameOfLife game = new GameOfLife();
    assertEquals(game.getState(), new Matrix());
  }
}
