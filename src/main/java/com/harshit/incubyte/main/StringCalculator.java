package com.harshit.incubyte.main;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

  private static List<Integer> getIntListFromStringArray(String[] strArr) {
    List<Integer> list = new ArrayList<Integer>();
    for (String n : strArr) {
      list.add(getInt(n));
    }
    return list;
  }

  private static int getSumFromStringArray(String input, String delimitor) {
    List<Integer> noList = getIntListFromStringArray(getStringArray(input, delimitor));
    checkForNegativeNumbers(noList);
    return noList.stream().mapToInt(Integer::intValue).sum();
  }

  private static void checkForNegativeNumbers(List<Integer> noList) {
    List<Integer> negativeList = noList.stream().filter(n -> n < 0).collect(Collectors.toList());
    if (negativeList.size() > 0) {
      throw new RuntimeException("negatives not allowed: " + convertListToString(negativeList));
    }
  }

  private static String convertListToString(List<Integer> list) {
    StringBuffer sb = new StringBuffer();
    list.forEach(n -> {
      if (!sb.toString().isEmpty()) {
        sb.append(",");
      }
      sb.append(n);
    });
    return sb.toString();
  }

  private static int getInt(String str) {
    if (str.isEmpty()) {
      return 0;
    } else {
      return Integer.parseInt(str);
    }
  }
}
