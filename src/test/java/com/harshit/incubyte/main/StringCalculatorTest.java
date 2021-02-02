package com.harshit.incubyte.main;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StringCalculatorTest {

  @Test
  public void testEmptyString() {
    String input = "";
    assertEquals(0, StringCalculator.add(input));
  }

  @Test
  public void testOneNumber() {
    String input = "3";
    assertEquals(3, StringCalculator.add(input));
  }

  @Test
  public void testTwoNumbers() {
    String input = "1,4";
    assertEquals(5, StringCalculator.add(input));
  }
}
