package com.marwwin.adventofcode2022.day2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.marwwin.adventofcode2022.day2.enums.Hand;
import com.marwwin.adventofcode2022.day2.enums.Outcome;

public class Day2Test {

  @Test
  public void part1ShouldGiveCorrectOuputForTestInput() {
    Day2 day2 = new Day2(true);
    assertEquals((int) day2.part1(), 15);
  }

  @Test
  public void part1ShouldGiveCorrectOuputForRealInput() {
    Day2 day2 = new Day2(false);
    assertEquals((int) day2.part1(), 11475);
  }

  @Test
  public void part1ShouldGivePointsForSelectedShapes() {
    RockPaperScissorsCalculator rps = new RockPaperScissorsCalculator();

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
  public void part1ShouldCreateGame(){
    RockPaperScissorsGame game = new RockPaperScissorsGamePart1("A X");
    assertEquals(game.getOpponent(), Hand.ROCK);
    assertEquals(game.getPlayer(), Hand.ROCK);
    assertEquals(game.getOutcome(), Outcome.DRAW);
  }

  @Test
  public void part1ShouldGivePointsForGamesWhenOpponentHasRock() {
    RockPaperScissorsCalculator rps = new RockPaperScissorsCalculator();
    RockPaperScissorsGame game1 = new RockPaperScissorsGamePart1("A X");
    rps.scoreGame(game1.getOutcome());
    assertEquals(rps.getPoints(), 3);
    rps.clearPoints();

    RockPaperScissorsGame game2 = new RockPaperScissorsGamePart1("A Z");
    rps.scoreGame(game2.getOutcome());
    assertEquals(rps.getPoints(), 0);

    RockPaperScissorsGame game3 = new RockPaperScissorsGamePart1("A Y");
    rps.scoreGame(game3.getOutcome());
    assertEquals(rps.getPoints(), 6);
  }

  @Test
  public void part1ShouldGivePointsForGamesWhenOpponentHasPaper() {
    RockPaperScissorsCalculator rps = new RockPaperScissorsCalculator();
    RockPaperScissorsGame game1 = new RockPaperScissorsGamePart1("B X");
    rps.scoreGame(game1.getOutcome());
    assertEquals(rps.getPoints(), 0);
    rps.clearPoints();

    RockPaperScissorsGame game2 = new RockPaperScissorsGamePart1("B Z");
    rps.scoreGame(game2.getOutcome());
    assertEquals(rps.getPoints(), 6);
    rps.clearPoints();

    RockPaperScissorsGame game3 = new RockPaperScissorsGamePart1("B Y");
    rps.scoreGame(game3.getOutcome());
    assertEquals(rps.getPoints(), 3);
  }

  @Test
  public void part1ShouldGivePointsForGamesWhenOpponentHasScissors() {
    RockPaperScissorsCalculator rps = new RockPaperScissorsCalculator();
    RockPaperScissorsGame game1 = new RockPaperScissorsGamePart1("C X");
    rps.scoreGame(game1.getOutcome());
    assertEquals(rps.getPoints(), 6);
    rps.clearPoints();

    RockPaperScissorsGame game2 = new RockPaperScissorsGamePart1("C Z");
    rps.scoreGame(game2.getOutcome());
    assertEquals(rps.getPoints(), 3);
    rps.clearPoints();

    RockPaperScissorsGame game3 = new RockPaperScissorsGamePart1("C Y");
    rps.scoreGame(game3.getOutcome());
    assertEquals(rps.getPoints(), 0);
  }

  @Test
  public void part1ShouldGivePointsForGame() {
    RockPaperScissorsCalculator rps = new RockPaperScissorsCalculator();
    rps.play(new RockPaperScissorsGamePart1("A X"));
    assertEquals(rps.getPoints(), 1 + 3);
  }

  @Test
  public void part2ShouldGiveCorrectOuputForTestInput() {
    Day2 day2 = new Day2(true);
    assertEquals((int) day2.part2(), 12);
  }

  @Test
  public void part2ShouldGiveCorrectOuputForRealInput() {
    Day2 day2 = new Day2(false);
    assertEquals((int) day2.part2(), 16862);
  }

  @Test
  public void part2shouldGiveScoreForRockAndDraw() {
    RockPaperScissorsCalculator rps = new RockPaperScissorsCalculator();
    rps.play(new RockPaperScissorsGamePart2("A Y"));
    assertEquals(rps.getPoints(), 4);
  }

  @Test
  public void part2shouldGiveScoreForRockAndWin() {
    RockPaperScissorsCalculator rps = new RockPaperScissorsCalculator();
    rps.play(new RockPaperScissorsGamePart2("C Z"));
    assertEquals(rps.getPoints(), 7);
  }

  @Test
  public void part2shouldGiveScoreForRockAndLose() {
    RockPaperScissorsCalculator rps = new RockPaperScissorsCalculator();
    rps.play(new RockPaperScissorsGamePart2("B X"));
    assertEquals(rps.getPoints(), 1);
  }
}
