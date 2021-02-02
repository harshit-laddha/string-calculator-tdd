package com.harshit.incubyte.main;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StringCalculatorTest {

  @Test
  public void testEmptyString() {
    String input = "";
    int result = StringCalculator.add(input);
    assertEquals(0, result);
  }
}
