package com.harshit.incubyte.main;

public class StringCalculator {
  public static int add(String input) {
    if (input.isEmpty()) {
      return 0;
    } else {
      int sum = 0;
      String[] strArr = input.split(",|\n");
      for (String n : strArr) {
        sum += getInt(n);
      }
      return sum;
    }
  }

  private static int getInt(String str) {
    if (str.isEmpty()) {
      return 0;
    } else {
      return Integer.parseInt(str);
    }
  }
}
