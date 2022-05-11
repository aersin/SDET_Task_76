package com.NFL.pages;

import java.util.Arrays;

public class Mission_1 {
    public static void main(String[] args) {
        /*Given an alphanumeric String, write a function to split the string into substrings of consecutive
        letters or numbers, sort the individual string and append them back together.
        Example:
        Input: "DC501GCCCA098911"
        Output: "CD015ACCCG011899" */

        bruteForceWay("DC501GCCCA098911");

        System.out.println("regularExpressionWay = " + regularExpressionWay("DC501GCCCA098911"));

        System.out.println("stringBuilderWay = " + stringBuilderWay("DC501GCCCA098911"));


    }

    public static void bruteForceWay(String str) {

        //this is the regular way. Goes step by step but it is brute.
        String str1 = "";
        String result = "";

        //add each character to new empty string but if the next one is different(numbers or letters)
        //than the previous one, put "," which will help to create an array in the next step.
        for (int i = 0; i < str.length(); i++) {
            str1 += str.charAt(i);
            if (Character.isAlphabetic(str.charAt(i)) && i < str.length() - 1) {
                if (Character.isDigit(str.charAt(i + 1))) {
                    str1 += ",";
                }
            }

            if (Character.isDigit(str.charAt(i)) && i < str.length() - 1) {
                if (Character.isAlphabetic(str.charAt(i + 1))) {
                    str1 += ",";
                }
            }
        }
        //split the string with the help of the ","s
        String[] arr = str1.split(",");
        for (String each : arr) {
            char[] chars = each.toCharArray();
            //get all individual string one by one and sort those by the help of Arrays.sort method
            Arrays.sort(chars);
            for (char eachChar : chars) {
                //assign the sorted substrings to the finalized string
                result += eachChar;
            }
        }
        System.out.println(result);
    }

    public static String regularExpressionWay(String str) {

        //the code is more clear with "regular expression" so in this method it is preferred.

        //split the string into substrings of consecutive letters or numbers => [DC, 501, GCCCA, 098911]
        //predefined character classes of "java.util.regex.Pattern" class
        //  \d	A digit: [0-9]
        //  \D	A non-digit: [^0-9]
        String[] split = str.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");

        String result = "";

        for (String s : split) {
            //get all individual string one by one and sort those by the help of Arrays.sort method
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            //assign the sorted substrings to the finalized string
            result += new String(chars);
        }
        return result;
    }

    public static String stringBuilderWay(String str) {

        //with string builder no need to create an object each time.
        //can be appended to existing one. So it helps to make a better space management.

        //split the string into substrings of consecutive letters or numbers => [DC, 501, GCCCA, 098911]
        String[] split = str.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");

        StringBuilder result = new StringBuilder();

        for (String s : split) {
            //get all individual string one by one and sort those by the help of Arrays.sort method
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            //assign the sorted substrings to the finalized string
            result.append(chars);
        }
        return result.toString();
    }
}


