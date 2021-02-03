package com.harshit.incubyte.main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
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

  @Test
  public void testMultipleNumbers() {
    String input = "1,2,3";
    assertEquals(6, StringCalculator.add(input));

    input = "5,4,3,2,1";
    assertEquals(15, StringCalculator.add(input));
  }

  @Test
  public void testNewLineCharacter_Two_Number() {
    String input = "1\n3";
    assertEquals(4, StringCalculator.add(input));
  }

  @Test
  public void testNewLineCharacterMixWithCommaDelimiter_MultipleNumbers() {
    String input = "1,2\n3";
    assertEquals(6, StringCalculator.add(input));
  }

  @Test
  public void testCustomDelimiter() {
    String input = "//;\n1;2";
    assertEquals(3, StringCalculator.add(input));
  }

  @Test
  public void testCustomDelimiter_MultipleNumber() {
    String input = "//,\n1,2,3";
    assertEquals(6, StringCalculator.add(input));
  }

  @Test(expected = RuntimeException.class)
  public void testThrowExceptionForNegativeNumber() {
    String input = "1,-2,3";
    StringCalculator.add(input);
  }

  @Test
  public void testExceptionShouldContainNegativeNumber() {
    String input = "1,-2,3";
    try {
      StringCalculator.add(input);
      fail("Exception should have thrown for negative Number");
    } catch (RuntimeException e) {
      assertEquals("negatives not allowed: -2", e.getMessage());
    }
  }

  @Test
  public void testExceptionShouldContainNegativeNumber_Multiple_Negative() {
    String input = "1,-2,-3";
    try {
      StringCalculator.add(input);
      fail("Exception should have thrown for negative Number");
    } catch (RuntimeException e) {
      assertEquals("negatives not allowed: -2,-3", e.getMessage());
    }
  }

  @Test
  public void testNumberBiggerThan1000() {
    String input = "2,1001";
    assertEquals(2, StringCalculator.add(input));

    // Custom Delimiter
    input = "//,\n1,2,1001";
    assertEquals(3, StringCalculator.add(input));
  }

  @Test
  public void testMultipleLengthDelimiter() {
    String input = "//[***]\n1***2***3";
    assertEquals(6, StringCalculator.add(input));
  }

  @Test
  public void testMultipleDelimiter() {
    String input = "//[*][%][^]\n1*2%*3^4";
    assertEquals(10, StringCalculator.add(input));
  }
}
