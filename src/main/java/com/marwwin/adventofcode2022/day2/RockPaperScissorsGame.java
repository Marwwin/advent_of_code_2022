package com.marwwin.adventofcode2022.day2;

import com.marwwin.adventofcode2022.day2.enums.Hand;
import com.marwwin.adventofcode2022.day2.enums.Outcome;

public class RockPaperScissorsGame {
  Hand player;
  Hand opponent;
  Outcome outcome;

  public RockPaperScissorsGame(String hand) {
    String[] handArray = hand.split(" ");
    this.opponent = parseOpponent(handArray[0]);
    this.player = parsePlayer(handArray[1]);
    this.outcome = parseOutcome(handArray[1]);
  }

  private Hand parsePlayer(String string) {
    if (string.equals("X"))
      return Hand.ROCK;
    if (string.equals("Y"))
      return Hand.PAPER;
    if (string.equals("Z"))
      return Hand.SCISSOR;
    return null;
  }

  private Hand parseOpponent(String string) {
    if (string.equals("A"))
      return Hand.ROCK;
    if (string.equals("B"))
      return Hand.PAPER;
    if (string.equals("C"))
      return Hand.SCISSOR;
    return null;
  }

  private Outcome parseOutcome(String string) {
    if (string.equals("X"))
      return Outcome.LOSE;
    if (string.equals("Y"))
      return Outcome.DRAW;
    if (string.equals("Z"))
      return Outcome.WIN;
    return null;
  }
}
