package com.harshit.incubyte.main;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {
  public static int add(String input) {
    if (input.startsWith("//")) {
      Object[] delimitors = getDelimiterForCustomDelimiter(input);
      String inputStr = getNumbersForCustomDelimiter(input);
      return getSumFromStringArray(inputStr, delimitors);
    } else {
      if (input.isEmpty()) {
        return 0;
      } else {
        String[] delimiters = new String[2];
        delimiters[0] = ",";
        delimiters[1] = "\n";
        return getSumFromStringArray(input, delimiters);
      }
    }
  }

  private static Object[] getDelimiterForCustomDelimiter(String input) {
    List<String> delimiters = new ArrayList<String>();
    String delimiterString = input.substring(2, input.indexOf("\n"));
    if (delimiterString.startsWith("[")) {
      while (!delimiterString.isEmpty()) {
        String delimiter = delimiterString.substring(delimiterString.indexOf("[") + 1,
            delimiterString.indexOf("]"));
        if (!delimiter.isEmpty()) {
          delimiters.add(delimiter);
        }
        delimiterString = delimiterString.substring(delimiterString.indexOf("]") + 1);
      }
    } else {
      delimiters.add(delimiterString);
    }
    return delimiters.toArray();
  }

  private static String getNumbersForCustomDelimiter(String input) {
    return input.substring(input.indexOf("\n") + 1);
  }

  private static String[] getStringArray(String input, Object[] delimiters) {
    String delimiterReg = "";
    for (Object d : delimiters) {
      String delimiter = String.valueOf(d);
      if (!delimiterReg.isEmpty()) {
        delimiterReg += "|";
      }
      delimiterReg += Pattern.quote(delimiter);
    }
    return input.split(delimiterReg);
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

  private static int getSumFromStringArray(String input, Object[] delimitors) {
    List<Integer> noList = getIntListFromStringArray(getStringArray(input, delimitors));
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
