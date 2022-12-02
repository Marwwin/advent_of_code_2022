package com.marwwin.adventofcode2022.day2;

import com.marwwin.adventofcode2022.day2.enums.Hand;
import com.marwwin.adventofcode2022.day2.enums.Outcome;

public class RockPaperScissorsCalculator {
  private int points = 0;

  public void play(RockPaperScissorsGame game) {
    scoreGame(game);
    scoreShape(game.getPlayer());
  }

  public void scoreGame(RockPaperScissorsGame game) {
    if (game.getOutcome() == Outcome.WIN)
      points += 6;
    if (game.getOutcome() == Outcome.DRAW)
      points += 3;
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
