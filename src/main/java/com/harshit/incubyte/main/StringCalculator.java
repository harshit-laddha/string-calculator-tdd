package com.harshit.incubyte.main;

public class StringCalculator {
  public static int add(String input) {
    if (input.isEmpty()) {
      return 0;
    } else if (!input.contains(",")) {
      return Integer.parseInt(input);
    } else {
      int sum = 0;
      String[] strArr = input.split(",");
      for (String n : strArr) {
        sum += Integer.parseInt(n);
      }
      return sum;
    }
  }
}
