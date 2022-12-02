package com.marwwin.adventofcode2022.day2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.marwwin.adventofcode2022.day2.enums.Hand;

public class Day2Test {

  @Test
  public void part1ShouldGiveCorrectOuputForTestInput() {
    Day2 day2 = new Day2(true);
    assertEquals(day2.part1(), 15);
  }

  @Test
  public void part1ShouldGiveCorrectOuputForRealInput() {
    Day2 day2 = new Day2(false);
    assertEquals(day2.part1(), 11475);
  }

  @Test
  public void part1ShouldGivePointsForSelectedShapes() {
    RockPaperScissorsPart1 rps = new RockPaperScissorsPart1();

    rps.scoreShape(Hand.PAPER);
    assertEquals(rps.getPoints(), 2);

    rps.clearPoints();
    assertEquals(rps.getPoints(), 0);

    rps.scoreShape(Hand.SCISSOR);
    assertEquals(rps.getPoints(), 3);
    rps.clearPoints();

    rps.scoreShape(Hand.ROCK);
    assertEquals(rps.getPoints(), 1);
  }

  @Test
  public void part1ShouldGivePointsForGamesWhenOpponentHasRock() {
    RockPaperScissorsPart1 rps = new RockPaperScissorsPart1();
    RockPaperScissorsGame game1 = new RockPaperScissorsGame("A X");
    rps.scoreGame(game1);
    assertEquals(rps.getPoints(), 3);
    rps.clearPoints();

    RockPaperScissorsGame game2 = new RockPaperScissorsGame("A Z");
    rps.scoreGame(game2);
    assertEquals(rps.getPoints(), 0);

    RockPaperScissorsGame game3 = new RockPaperScissorsGame("A Y");
    rps.scoreGame(game3);
    assertEquals(rps.getPoints(), 6);
  }

  @Test
  public void part1ShouldGivePointsForGamesWhenOpponentHasPaper() {
    RockPaperScissorsPart1 rps = new RockPaperScissorsPart1();
    RockPaperScissorsGame game1 = new RockPaperScissorsGame("B X");
    rps.scoreGame(game1);
    assertEquals(rps.getPoints(), 0);
    rps.clearPoints();

    RockPaperScissorsGame game2 = new RockPaperScissorsGame("B Z");
    rps.scoreGame(game2);
    assertEquals(rps.getPoints(), 6);
    rps.clearPoints();

    RockPaperScissorsGame game3 = new RockPaperScissorsGame("B Y");
    rps.scoreGame(game3);
    assertEquals(rps.getPoints(), 3);
  }

  @Test
  public void part1ShouldGivePointsForGamesWhenOpponentHasScissors() {
    RockPaperScissorsPart1 rps = new RockPaperScissorsPart1();
    RockPaperScissorsGame game1 = new RockPaperScissorsGame("C X");
    rps.scoreGame(game1);
    assertEquals(rps.getPoints(), 6);
    rps.clearPoints();

    RockPaperScissorsGame game2 = new RockPaperScissorsGame("C Z");
    rps.scoreGame(game2);
    assertEquals(rps.getPoints(), 3);
    rps.clearPoints();

    RockPaperScissorsGame game3 = new RockPaperScissorsGame("C Y");
    rps.scoreGame(game3);
    assertEquals(rps.getPoints(), 0);
  }

  @Test
  public void part1ShouldGivePointsForGame() {
    RockPaperScissorsPart1 rps = new RockPaperScissorsPart1();
    rps.play("A X");
    assertEquals(rps.getPoints(), 1 + 3);
  }

  @Test
  public void part2ShouldGiveCorrectOuputForTestInput() {
    Day2 day2 = new Day2(true);
    assertEquals(day2.part2(), 12);
  }

  @Test
  public void part2ShouldGiveCorrectOuputForRealInput() {
    Day2 day2 = new Day2(false);
    assertEquals(day2.part2(), 16862);
  }

  @Test
  public void part2shouldGiveScoreForRockAndDraw() {
    RockPaperScissorsPart2 rps = new RockPaperScissorsPart2();
    rps.play("A Y");
    assertEquals(rps.getPoints(), 4);
  }

  @Test
  public void part2shouldGiveScoreForRockAndWin() {
    RockPaperScissorsPart2 rps = new RockPaperScissorsPart2();
    rps.play("C Z");
    assertEquals(rps.getPoints(), 7);
  }

  @Test
  public void part2shouldGiveScoreForRockAndLose() {
    RockPaperScissorsPart2 rps = new RockPaperScissorsPart2();
    rps.play("B X");
    assertEquals(rps.getPoints(), 1);
  }
}
