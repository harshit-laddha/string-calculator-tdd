package com.harshit.incubyte.main;

public class StringCalculator {
  public static int add(String input) {
    if (!input.contains(",")) {
      return getInt(input);
    } else {
      int sum = 0;
      String[] strArr = input.split(",");
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
