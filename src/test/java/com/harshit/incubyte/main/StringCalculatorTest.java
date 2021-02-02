package com.harshit.incubyte.main;

import static org.junit.Assert.assertEquals;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
    String input = "//c\n1c2";
    Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
    matcher.matches();
    System.out.println(matcher.group(1));
    System.out.println(matcher.group(2));
    assertEquals(3, StringCalculator.add(input));

  }
}
