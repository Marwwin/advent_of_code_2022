package com.marwwin.adventofcode2022.day2;

import com.marwwin.adventofcode2022.day2.enums.Hand;
import com.marwwin.adventofcode2022.day2.enums.Outcome;

public class RockPaperScissorsGamePart2 extends RockPaperScissorsGame {
  Hand player;
  Hand opponent;
  Outcome outcome;

  public RockPaperScissorsGamePart2(String hand) {
    String[] handArray = hand.split(" ");
    this.opponent = parseOpponent(handArray[0]);
    this.outcome = parseOutcome(handArray[1]);
    this.player = parsePlayer();
  }

  protected Hand parseOpponent(String string) {
    if (string.equals("A"))
      return Hand.ROCK;
    if (string.equals("B"))
      return Hand.PAPER;
    if (string.equals("C"))
      return Hand.SCISSOR;
    return null;
  }

  protected Outcome parseOutcome(String string) {
    if (string.equals("X"))
      return Outcome.LOSE;
    if (string.equals("Y"))
      return Outcome.DRAW;
    if (string.equals("Z"))
      return Outcome.WIN;
    return null;
  }
  
  protected Hand parsePlayer() {
    if (outcome == Outcome.WIN)
      return winningHand();
    if (outcome == Outcome.LOSE)
      return loosingHand();
    return opponent;
  }

  private Hand winningHand() {
    if (opponent == Hand.PAPER)
      return Hand.SCISSOR;
    if (opponent == Hand.ROCK)
      return Hand.PAPER;
    if (opponent == Hand.SCISSOR)
      return Hand.ROCK;
    return null;
  }

  private Hand loosingHand() {
    if (opponent == Hand.PAPER)
      return Hand.ROCK;
    if (opponent == Hand.ROCK)
      return Hand.SCISSOR;
    if (opponent == Hand.SCISSOR)
      return Hand.PAPER;
    return null;
  }

  @Override
  public Hand getOpponent() {
    return opponent;
  }

  @Override
  public Outcome getOutcome() {
    return outcome;
  }

  @Override
  public Hand getPlayer() {
    return player;
  }

}
