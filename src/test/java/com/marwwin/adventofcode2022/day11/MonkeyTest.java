package com.marwwin.adventofcode2022.day11;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

public class MonkeyTest {
  @Test
  public void shouldCreateAMonkeyWithIdFromInt() {
    Monkey monkey = new Monkey(1);
    assertEquals((long) monkey.getId(), 1);
  }

  @Test
  public void shouldCreateAMonkeyWithIdFromString() {
    Monkey monkey = new Monkey("Monkey 1:");
    assertEquals((long) monkey.getId(), 1);
  }

  @Test
  public void shouldHaveItemsProperty() {
    Monkey monkey = new Monkey(1);
    assertEquals(monkey.getItems(), Arrays.asList());
  }

  @Test
  public void shouldBeAbleToAddItems() {
    Monkey monkey = new Monkey(1);
    monkey.addItem((long) 1);
    assertEquals(monkey.getItems(), Arrays.asList((long) 1));
    monkey.addItem((long) 42);
    assertEquals(monkey.getItems(), Arrays.asList((long) 1, (long) 42));
  }

  @Test
  public void shouldHaveATest() {
    Monkey monkey = new Monkey(1);

    monkey.setTest("  Test: divisible by 2");
    assertEquals(monkey.test((long) 2), true);
    assertEquals(monkey.test((long) 3), false);
    assertEquals(monkey.test((long) 10), true);

    monkey.setTest("Test: divisible by 3");
    assertEquals(monkey.test((long) 2), false);
    assertEquals(monkey.test((long) 3), true);
    assertEquals(monkey.test((long) 9), true);

  }

  @Test
  public void shouldRunOperationOnSingleItem() {
    Monkey monkey = new Monkey(1);

    monkey.addItem((long) 1);
    monkey.setOperation("  Operation: new = old * 3");
    monkey.inspectItems(1);
    assertEquals(monkey.getItems(), Arrays.asList((long) 3));
  }

  @Test
  public void shouldRunOperationOnMultipleItem() {
    Monkey monkey = new Monkey(1);

    monkey.addItem((long) 1);
    monkey.addItem((long) 2);
    monkey.setOperation("  Operation: new = old * 2");
    monkey.inspectItems(1);
    assertEquals(monkey.getItems(), Arrays.asList((long) 2, (long) 4));
  }

  @Test
  public void shouldThrowItem() {
    Monkey monkey = new Monkey(1);

    monkey.setTest("Test: divisible by 2");
    monkey.setIfTrue("If true: throw to monkey 5");
    monkey.setIfFalse("If false: throw to monkey 9");
    HashMap<String, Long> result = monkey.throwItem((long) 2);

    assertEquals((long) result.get("id"), 5);
    assertEquals((long) result.get("item"), 2);
  }
}
