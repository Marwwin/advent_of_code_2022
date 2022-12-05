package com.marwwin.adventofcode2022.day2;

import com.marwwin.adventofcode2022.day2.enums.Hand;
import com.marwwin.adventofcode2022.day2.enums.Outcome;

public abstract class RockPaperScissorsGame {
  public abstract Hand getOpponent();

  public abstract Outcome getOutcome();

  public abstract Hand getPlayer();
}
