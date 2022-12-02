package com.marwwin.adventofcode2022.day2;

import com.marwwin.adventofcode2022.day2.enums.Hand;

public class RockPaperScissorsPart1 {
  private int points = 0;

  public void play(String hand) {
    RockPaperScissorsGame game = new RockPaperScissorsGame(hand);
    scoreGame(game);
    scoreShape(game.player);
  }

  public void scoreGame(RockPaperScissorsGame game) {
    if (game.opponent == game.player)
      points += 3;
    if (game.opponent == Hand.ROCK && game.player == Hand.PAPER)
      points += 6;
    if (game.opponent == Hand.PAPER && game.player == Hand.SCISSOR)
      points += 6;
    if (game.opponent == Hand.SCISSOR && game.player == Hand.ROCK)
      points += 6;
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
