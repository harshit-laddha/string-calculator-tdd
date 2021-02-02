package com.harshit.incubyte.main;

public class StringCalculator {
  public static int add(String input) {
    if (input.isEmpty()) {
      return 0;
    }
    return Integer.parseInt(input);
  }
}
