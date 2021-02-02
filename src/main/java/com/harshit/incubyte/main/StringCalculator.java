package com.harshit.incubyte.main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
  public static int add(String input) {
    if (input.startsWith("//")) {
      String delimitor = getDelimiterForCustomDelimiter(input);
      String inputStr = getNumbersForCustomDelimiter(input);
      return getSumFromStringArray(inputStr, delimitor);
    } else {
      if (input.isEmpty()) {
        return 0;
      } else {
        return getSumFromStringArray(input, ",|\n");
      }
    }
  }

  private static String getDelimiterForCustomDelimiter(String input) {
    return input.substring(2, input.indexOf("\n"));
  }

  private static String getNumbersForCustomDelimiter(String input) {
    return input.substring(input.indexOf("\n") + 1);
  }

  private static String[] getStringArray(String input, String delimitor) {
    return input.split(delimitor);
  }

  private static List<Integer> getIntListFromStringArray(String[] strArr) {
    List<Integer> list = new ArrayList<Integer>();
    for (String numberStr : strArr) {
      int no = getInt(numberStr);
      if (no > 1000) {
        continue;
      }
      list.add(no);
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
