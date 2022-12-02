package com.marwwin.adventofcode2022.day2;

import com.marwwin.adventofcode2022.day2.enums.Hand;
import com.marwwin.adventofcode2022.day2.enums.Outcome;

public class RockPaperScissorsPart2 extends RockPaperScissorsPart1 {
  private int points = 0;

  public void play(String hand) {
    RockPaperScissorsGame game = new RockPaperScissorsGame(hand);
    scoreGame(game);
  }

  public void scoreGame(RockPaperScissorsGame game) {
    if (game.outcome == Outcome.WIN)
      scoreWin(game);
    if (game.outcome == Outcome.DRAW)
      scoreDraw(game);
    if (game.outcome == Outcome.LOSE)
      scoreLose(game);
  }

  private void scoreWin(RockPaperScissorsGame game) {
    points += 6;
    if (game.opponent == Hand.ROCK)
      scoreShape(Hand.PAPER);
    if (game.opponent == Hand.SCISSOR)
      scoreShape(Hand.ROCK);
    if (game.opponent == Hand.PAPER)
      scoreShape(Hand.SCISSOR);
  }

  private void scoreDraw(RockPaperScissorsGame game) {
    points += 3;
    scoreShape(game.opponent);
  }

  private void scoreLose(RockPaperScissorsGame game) {
  if (game.opponent == Hand.ROCK)
    scoreShape(Hand.SCISSOR);
  if (game.opponent == Hand.SCISSOR)
    scoreShape(Hand.PAPER);
  if (game.opponent == Hand.PAPER)
    scoreShape(Hand.ROCK);
  }

  public void scoreShape(Hand player) {
    if (player == Hand.SCISSOR)
      points += 3;
    if (player == Hand.PAPER)
      points += 2;
    if (player == Hand.ROCK)
      points += 1;
  }

  public int getPoints() {
    return points;
  }

  public void clearPoints() {
    points = 0;
  }
}
