package com.marwwin.adventofcode2022.day2;

import com.marwwin.adventofcode2022.day2.enums.Hand;
import com.marwwin.adventofcode2022.day2.enums.Outcome;

public class RockPaperScissorsGamePart1 extends RockPaperScissorsGame {
  private Hand player;
  private Hand opponent;
  private Outcome outcome;

  public RockPaperScissorsGamePart1(String hand) {
    String[] handArray = hand.split(" ");
    this.opponent = parseOpponent(handArray[0]);
    this.player = parsePlayer(handArray[1]);
    this.outcome = parseOutcome();
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

  private Outcome parseOutcome() {
    if (this.player == this.opponent)
      return Outcome.DRAW;
    if (this.player == Hand.ROCK && this.opponent == Hand.SCISSOR)
      return Outcome.WIN;
    if (this.player == Hand.PAPER && this.opponent == Hand.ROCK)
      return Outcome.WIN;
    if (this.player == Hand.SCISSOR && this.opponent == Hand.PAPER)
      return Outcome.WIN;
    return Outcome.LOSE;
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
