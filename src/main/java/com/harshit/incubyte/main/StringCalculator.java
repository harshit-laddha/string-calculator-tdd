package com.harshit.incubyte.main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
  public static int add(String input) {
    if (input.startsWith("//")) {
      Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
      matcher.matches();
      String delimitor = matcher.group(1);
      String inputStr = matcher.group(2);
      return getSumFromStringArray(inputStr, delimitor);
    } else {
      if (input.isEmpty()) {
        return 0;
      } else {
        return getSumFromStringArray(input, ",|\n");
      }
    }
  }

  private static String[] getStringArray(String input, String delimitor) {
    return input.split(delimitor);
  }

  private static int getSumFromStringArray(String input, String delimitor) {
    String[] strArr = getStringArray(input, delimitor);
    int sum = 0;
    for (String n : strArr) {
      sum += getInt(n);
    }
    return sum;
  }

  private static int getInt(String str) {
    if (str.isEmpty()) {
      return 0;
    } else {
      return Integer.parseInt(str);
    }
  }
}
